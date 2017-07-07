package course.javaweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {
    @RequestMapping(value = "/public")
    public ModelAndView publicSells() {
        return new ModelAndView("public");
    }

    @RequestMapping("/publicSubmit")
    public ModelAndView publicSubmit() {
        return new ModelAndView("publicSubmit");
    }
}
