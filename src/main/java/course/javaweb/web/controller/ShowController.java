package course.javaweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowController {
    @RequestMapping("/show")
    public ModelAndView show() {
        return new ModelAndView("show");
    }
}
