package isthatkirill.expertsystem.service;

import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final FactService factService;

    public void run() {
        Map<String, Double> resultCfs = new HashMap<>();

        List<Long> positiveFactIds = factService.getPositiveFacts();
        List<Job> jobs = jobRepository.findAll();

        // получения всех МД и расчет КУ
        for (Job job : jobs) {
            Double cf = job.getTrusts()
                    .stream()
                    .filter(trust -> positiveFactIds.contains(trust.getFact().getId()))
                    .mapToDouble(trust -> trust.getTrustCf() * trust.getFact().getWeight())
                    .sum();
            resultCfs.put(job.getName(), cf);
        }

        // нормализация
        Double minValue = Collections.min(resultCfs.values());
        Double maxValue = Collections.max(resultCfs.values());
        resultCfs.replaceAll((key, value) -> (value - minValue) / (maxValue - minValue));

        // сортировка по возрастанию
        resultCfs = resultCfs.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()) // Сортировка по убыванию
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // вывод в консоль
        for (Map.Entry<String, Double> entry : resultCfs.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

}
