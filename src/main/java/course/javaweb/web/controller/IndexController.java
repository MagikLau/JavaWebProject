package course.javaweb.web.controller;

import course.javaweb.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping(path = {"/", "/index"})
    public String index(ModelMap modelMap, HttpSession httpSession) {
        System.out.println("httpSession in indexController: "+httpSession.getAttribute("user"));
        User user = (User) httpSession.getAttribute("user");
               if (user != null){modelMap.addAttribute("user", user);
                      System.out.println("user in IndexC modelMap:"+modelMap.get("user"));
                   }
        return "index";
    }
}
