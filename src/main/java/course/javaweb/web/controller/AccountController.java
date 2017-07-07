package course.javaweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @RequestMapping(value = "/account")
    public ModelAndView account() {
        return new ModelAndView("account");
    }
}
