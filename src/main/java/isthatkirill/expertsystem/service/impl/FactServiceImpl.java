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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class FactServiceImpl implements FactService {

    private final FactRepository factRepository;
    private final JobRepository jobRepository;
    private final TrustRepository trustRepository;

    @Override
    public List<Fact> getFacts() {
        return factRepository.findAll();
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

    private void saveTrusts(Map<String, String> params, Fact fact) {
        params.forEach((key, value) -> {
            Trust trust = new Trust();
            trust.setFact(fact);
            trust.setJob(checkIfJobExists(key));
            trust.setTrustCf(Double.parseDouble(value));
            trustRepository.save(trust);
        });
    }

    private Job checkIfJobExists(String name) {
        return jobRepository.findByName(name)
                .orElseThrow(EntityNotFoundException::new);
    }


}
