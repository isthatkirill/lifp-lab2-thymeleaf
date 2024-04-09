package isthatkirill.expertsystem.controller;

import isthatkirill.expertsystem.service.FactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static isthatkirill.expertsystem.util.Constants.COMMON_NAVBAR;

/**
 * @author Kirill Emelyanov
 */

@Controller
@RequestMapping("/expert-system")
@RequiredArgsConstructor
public class MainController {

    private final FactService factService;

    @GetMapping("/start")
    public String start(Model model) {
        model.addAttribute("COMMON_NAVBAR", COMMON_NAVBAR);
        return "start";
    }

    @GetMapping("/advice")
    public String showFacts(Model model) {
        model.addAttribute("COMMON_NAVBAR", COMMON_NAVBAR);
        model.addAttribute("facts", factService.getFacts());
        return "advice";
    }

}
