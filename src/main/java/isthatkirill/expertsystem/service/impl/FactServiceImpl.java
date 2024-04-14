package isthatkirill.expertsystem.service.impl;

import isthatkirill.expertsystem.model.Fact;
import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.model.Trust;
import isthatkirill.expertsystem.repository.FactRepository;
import isthatkirill.expertsystem.repository.JobRepository;
import isthatkirill.expertsystem.repository.TrustRepository;
import isthatkirill.expertsystem.service.FactService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class FactServiceImpl implements FactService {

    private final FactRepository factRepository;
    private final JobRepository jobRepository;
    private final TrustRepository trustRepository;

    @Override
    public List<Fact> getFacts() {
        return factRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Fact saveFact(Map<String, String> params) {
        Fact fact = new Fact();
        fact.setDescription(params.remove("description"));
        fact.setWeight(Double.parseDouble(params.remove("weight")));
        fact = factRepository.save(fact);
        saveTrusts(params, fact);
        return fact;
    }

    @Override
    public void deleteFact(Long factId) {
        factRepository.deleteById(factId);
    }

    @Override
    public Fact updateFact(Long factId, Map<String, String> params) {
        params.remove("_method");
        params.remove("id");

        Fact fact = checkIfFactExists(factId);
        String weight = params.remove("weight");
        String description = params.remove("description");
        fact.setDescription(!description.isBlank() ? description : fact.getDescription());
        fact.setWeight(Double.parseDouble(
                !weight.isBlank() ? weight : String.valueOf(fact.getWeight())
        ));

        updateTrusts(params, factId);
        return factRepository.save(fact);
    }

    private void updateTrusts(Map<String, String> params, Long factId) {
        params.forEach((key, value) -> {
            if (!value.isBlank()) {
                Job job = checkIfJobExists(Long.parseLong(key));
                Trust trust = checkIfTrustExists(factId, job.getId());
                trust.setTrustCf(Double.parseDouble(value));
                trustRepository.save(trust);
            }
        });
    }

    private void saveTrusts(Map<String, String> params, Fact fact) {
        params.forEach((key, value) -> {
            Trust trust = new Trust();
            trust.setFact(fact);
            trust.setJob(checkIfJobExists(Long.parseLong(key)));
            trust.setTrustCf(Double.parseDouble(value));
            trustRepository.save(trust);
        });
    }

    private Trust checkIfTrustExists(Long factId, Long jobId) {
        return trustRepository.findByFactIdAndJobId(factId, jobId)
                .orElseThrow(EntityNotFoundException::new);
    }

    private Fact checkIfFactExists(Long factId) {
        return factRepository.findById(factId)
                .orElseThrow(EntityNotFoundException::new);
    }

    private Job checkIfJobExists(Long jobId) {
        return jobRepository.findById(jobId)
                .orElseThrow(EntityNotFoundException::new);
    }

}
