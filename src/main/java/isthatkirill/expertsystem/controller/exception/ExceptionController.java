package isthatkirill.expertsystem.controller.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Kirill Emelyanov
 */

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public String anyExceptionHandle(final Exception e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }

}
