package course.javaweb.web.controller;

import course.javaweb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping(path = {"/", "/index"})
    public String index(@ModelAttribute("user") User user, HttpSession httpSession) {
//        System.out.println("user in indexController: "+user.toString());
        System.out.println("httpSession in indexController: "+httpSession.getAttribute("user"));

        return "index";
    }
}
