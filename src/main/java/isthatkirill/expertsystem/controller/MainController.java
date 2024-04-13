package isthatkirill.expertsystem.controller;

import isthatkirill.expertsystem.model.Fact;
import isthatkirill.expertsystem.model.Job;
import isthatkirill.expertsystem.service.impl.FactServiceImpl;
import isthatkirill.expertsystem.service.impl.JobServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    private final FactServiceImpl factService;
    private final JobServiceImpl jobService;

    @GetMapping("/start")
    public String start(Model model) {
        return "start";
    }

    @GetMapping("/advice")
    public String getAdvicePage(Model model) {
        model.addAttribute("facts", factService.getFacts());
        return "advice";
    }

    @PostMapping("/advice")
    public String getResults(@RequestParam Map<String, String> answers, Model model) {
        Map<String, Double> resultCfs = jobService.getResults(answers);
        model.addAttribute("resultCfs", resultCfs);
        return "result";
    }

    @GetMapping("/facts")
    public String getAddFactPage(Model model) {
        List<Job> jobs = jobService.getJobs();
        model.addAttribute("jobs", jobs);
        return "addfact";
    }

    @PostMapping("/facts")
    public String addFact(@RequestParam Map<String, String> params, Model model) {
        Fact fact = factService.saveFact(params);
        model.addAttribute("factCreated", fact);
        return "start";
    }


}
