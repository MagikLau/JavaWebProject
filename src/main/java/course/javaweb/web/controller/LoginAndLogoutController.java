package course.javaweb.web.controller;

import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginAndLogoutController {
    private LoginService loginService;

    @Autowired
    private void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute("user") User user, HttpSession httpSession) {
        if (loginService.login(user)) {
            httpSession.setAttribute("user", user);
            return "index";
        } else
            return "login";
    }

    @RequestMapping("/logout")
    public String logout(ModelMap modelMap) {
        modelMap.remove("user");
        return "login";
    }


}
