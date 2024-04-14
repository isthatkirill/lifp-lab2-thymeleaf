package isthatkirill.expertsystem.service.impl;

import isthatkirill.expertsystem.model.Fact;
import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.model.Trust;
import isthatkirill.expertsystem.repository.FactRepository;
import isthatkirill.expertsystem.repository.JobRepository;
import isthatkirill.expertsystem.repository.TrustRepository;
import isthatkirill.expertsystem.service.JobService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final FactRepository factRepository;
    private final TrustRepository trustRepository;

    @Override
    public Map<String, Double> getResults(Map<String, String> facts) {
        Map<String, Double> resultCfs = new HashMap<>();

        List<Long> trueFactIds = filterTrueFacts(facts);

        List<Job> jobs = jobRepository.findAll();

        for (Job job : jobs) {
            Double cf = job.getTrusts()
                    .stream()
                    .filter(trust -> trueFactIds.contains(trust.getFact().getId()))
                    .mapToDouble(trust -> trust.getTrustCf() * trust.getFact().getWeight())
                    .sum() / trueFactIds.size();
            resultCfs.put(job.getName(), cf);
        }

        Double minValue = Collections.min(resultCfs.values());
        Double maxValue = Collections.max(resultCfs.values());
        resultCfs.replaceAll((key, value) -> (value - minValue) / (maxValue - minValue));

        resultCfs = resultCfs.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        return resultCfs;
    }

    @Override
    public List<Job> getJobs() {
        return jobRepository.findAllByOrderByIdAsc();
    }

    @Override
    public Job saveJob(Map<String, String> params) {
        Job job = new Job();
        job.setName(params.remove("name"));
        job.setTrusts(saveTrusts(params, job));
        job = jobRepository.save(job);
        return job;
    }

    @Override
    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }

    @Override
    public Job updateJob(Long jobId, Map<String, String> params) {
        params.remove("id");
        params.remove("_method");

        Job job = checkIfJobExists(jobId);
        String name = params.remove("name");
        job.setName(!name.isBlank() ? name : job.getName());
        updateTrusts(params, jobId);

        return jobRepository.save(job);
    }

    private void updateTrusts(Map<String, String> params, Long jobId) {
        params.forEach((key, value) -> {
            if (!value.isBlank()) {
                Fact fact = checkIfFactExists(Long.parseLong(key));
                Trust trust = checkIfTrustExists(fact.getId(), jobId);
                trust.setTrustCf(Double.parseDouble(value));
                trustRepository.save(trust);
            }
        });
    }

    private List<Trust> saveTrusts(Map<String, String> params, Job job) {
        return params.entrySet().stream()
                .map(entry -> {
                    Trust trust = new Trust();
                    trust.setJob(job);
                    trust.setFact(checkIfFactExists(Long.parseLong(entry.getKey())));
                    trust.setTrustCf(Double.parseDouble(entry.getValue()));
                    return trust;
                }).toList();
    }

    private List<Long> filterTrueFacts(Map<String, String> facts) {
        return facts.entrySet().stream()
                .filter(entry -> entry.getValue().equalsIgnoreCase("true"))
                .map(entry -> Long.parseLong(entry.getKey()))
                .toList();
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
