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
@RequestMapping("/expert-system/facts")
@RequiredArgsConstructor
public class FactController {

    private final FactService factService;
    private final JobService jobService;

    @GetMapping("/add")
    public String getAddFactPage(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        return "addfact";
    }

    @GetMapping("/update")
    public String getUpdateFactPage(Model model) {
        model.addAttribute("jobs", jobService.getJobs());
        model.addAttribute("facts", factService.getFacts());
        return "updatefact";
    }

    @GetMapping("/delete")
    public String getDeleteFactPage(Model model) {
        model.addAttribute("facts", factService.getFacts());
        return "deletefact";
    }

    @PostMapping("/add")
    public String addFact(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("factCreated", factService.saveFact(params));
        return "start";
    }

    @PatchMapping("/update/{factId}")
    public String updateFact(Model model, @PathVariable Long factId, @RequestParam Map<String, String> params) {
        model.addAttribute("factUpdated", factService.updateFact(factId, params));
        return "start";
    }

    @DeleteMapping("/delete/{factId}")
    public String deleteFact(Model model, @PathVariable Long factId) {
        factService.deleteFact(factId);
        model.addAttribute("factDeleted", factId);
        return "start";
    }

}
