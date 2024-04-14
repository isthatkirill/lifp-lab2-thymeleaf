package isthatkirill.expertsystem.controller;

import isthatkirill.expertsystem.service.FactService;
import isthatkirill.expertsystem.service.JobService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/advice")
    public String getResults(@RequestParam Map<String, String> answers, Model model) {
        model.addAttribute("resultCfs", jobService.getResults(answers));
        return "result";
    }

}
