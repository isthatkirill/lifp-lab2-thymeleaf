package isthatkirill.expertsystem.service.impl;

import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.repository.JobRepository;
import isthatkirill.expertsystem.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

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
        return jobRepository.findAll();
    }

    private List<Long> filterTrueFacts(Map<String, String> facts) {
        return facts.entrySet().stream()
                .filter(entry -> entry.getValue().equalsIgnoreCase("true"))
                .map(entry -> Long.parseLong(entry.getKey()))
                .toList();
    }

}
