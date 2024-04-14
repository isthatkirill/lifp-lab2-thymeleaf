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
        model.addAttribute("jobs", jobService.getJobs());
        return "addfact";
    }

    @GetMapping("/facts/update")
    public String getUpdateFactPage(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        model.addAttribute("facts", factService.getFacts());
        return "updatefact";
    }

    @GetMapping("/facts/delete")
    public String getDeleteFactPage(Model model) {
        model.addAttribute("facts", factService.getFacts());
        return "deletefact";
    }

    @PostMapping("/advice")
    public String getResults(@RequestParam Map<String, String> answers, Model model) {
        model.addAttribute("resultCfs", jobService.getResults(answers));
        return "result";
    }

    @PostMapping("/facts/add")
    public String addFact(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("factCreated", factService.saveFact(params));
        return "start";
    }

    @PatchMapping("/facts/update/{factId}")
    public String updateFact(Model model, @PathVariable Long factId, @RequestParam Map<String, String> params) {
        model.addAttribute("factUpdated", factService.updateFact(factId, params));
        return "start";
    }

    @DeleteMapping("/facts/delete/{factId}")
    public String deleteFact(Model model, @PathVariable Long factId) {
        factService.deleteFact(factId);
        model.addAttribute("factDeleted", factId);
        return "start";
    }

}
