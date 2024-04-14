package isthatkirill.expertsystem.controller;

import isthatkirill.expertsystem.service.FactService;
import isthatkirill.expertsystem.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

@Controller
@RequestMapping("/expert-system/jobs")
@RequiredArgsConstructor
public class JobController {

    private final FactService factService;
    private final JobService jobService;

    @GetMapping("/add")
    public String getAddJobPage(Model model) {
        model.addAttribute("facts", factService.getFacts());
        return "addjob";
    }

    @GetMapping("/update")
    public String getUpdateFactPage(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        model.addAttribute("facts", factService.getFacts());
        return "updatejob";
    }

    @GetMapping("/delete")
    public String getDeleteJobPage(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        return "deletejob";
    }

    @PostMapping("/add")
    public String addJob(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("jobCreated", jobService.saveJob(params));
        return "start";
    }

    @PatchMapping("/update/{jobId}")
    public String updateFact(Model model, @PathVariable Long jobId, @RequestParam Map<String, String> params) {
        model.addAttribute("jobUpdated", jobService.updateJob(jobId, params));
        return "start";
    }

    @DeleteMapping("/delete/{jobId}")
    public String deleteJob(Model model, @PathVariable Long jobId) {
        jobService.deleteJob(jobId);
        model.addAttribute("jobDeleted", jobId);
        return "start";
    }

}
