package isthatkirill.expertsystem.service;

import isthatkirill.expertsystem.model.Job;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

public interface JobService {

    Map<String, Double> getResults(Map<String, String> facts);

    List<Job> getJobs();

}
