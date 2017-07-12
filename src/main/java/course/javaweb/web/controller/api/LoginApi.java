package course.javaweb.web.controller.api;

import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/api")
public class LoginApi {
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap login(@RequestParam("userName") String userName,
                          @RequestParam("password") String password,
                          ModelMap modelMap, HttpSession httpSession) {
        System.out.println("user in LoginApi: "+userName+", "+password);
        User loginUser = loginService.login(userName, password);
        System.out.println("user in LoginApi: "+loginUser);
        if( loginUser != null ){
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", true);
//            modelMap.addAttribute("user", loginUser);
            httpSession.setAttribute("user", loginUser);
        }else{
//            modelMap.remove("user");
            httpSession.removeAttribute("user");
            modelMap.addAttribute("code", 401);
            modelMap.addAttribute("message", "failed");
            modelMap.addAttribute("result", false);
        }
        return modelMap;
    }
}
