package isthatkirill.expertsystem.service;

import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.repository.JobRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Kirill Emelyanov
 */

@Service
@RequiredArgsConstructor
public class InitService {

    private final JobService jobService;

    @PostConstruct
    public void init() {
        jobService.run();
    }

}
