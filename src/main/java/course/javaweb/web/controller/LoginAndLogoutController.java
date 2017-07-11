package course.javaweb.web.controller;

import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginAndLogoutController {
    @Autowired
    private LoginService loginService;

//    private void setLoginService(LoginService loginService) {
//        this.loginService = loginService;
//    }

    @RequestMapping(value = "/login")
    public String login(HttpSession httpSession) {
        System.out.println("user in sessionAttribute: " + httpSession.getAttribute("user"));
            return "login";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap modelMap,HttpSession httpSession) {
        modelMap.remove("user");
        httpSession.removeAttribute("user");
        return "login";
    }


}
