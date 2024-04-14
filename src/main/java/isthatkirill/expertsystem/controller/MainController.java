package isthatkirill.expertsystem.controller;

import isthatkirill.expertsystem.model.Fact;
import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.service.FactService;
import isthatkirill.expertsystem.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Emelyanov
 */

@Slf4j
@Controller
@RequestMapping("/expert-system")
@RequiredArgsConstructor
public class MainController {

    private final FactService factService;
    private final JobService jobService;

    @GetMapping("/start")
    public String start(Model model) {
        return "start";
    }

    @GetMapping("/advice")
    public String getAdvicePage(Model model) {
        model.addAttribute("facts", factService.getFacts());
        return "advice";
    }

    @GetMapping("/facts/add")
    public String getAddFactPage(Model model) {
        List<Job> jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        return "addfact";
    }

    @GetMapping("/facts/delete")
    public String getDeleteFactPage(Model model) {
        List<Fact> facts = factService.getFacts();
        model.addAttribute("facts", facts);
        return "deletefact";
    }

    @PostMapping("/advice")
    public String getResults(@RequestParam Map<String, String> answers, Model model) {
        Map<String, Double> resultCfs = jobService.getResults(answers);
        model.addAttribute("resultCfs", resultCfs);
        return "result";
    }

    @PostMapping("/facts/add")
    public String addFact(@RequestParam Map<String, String> params, Model model) {
        Fact fact = factService.saveFact(params);
        model.addAttribute("factCreated", fact);
        return "start";
    }

    @DeleteMapping("/facts/delete/{factId}")
    public String deleteFact(Model model, @PathVariable Long factId) {
        factService.deleteFact(factId);
        model.addAttribute("factDeleted", factId);
        return "start";
    }


}
