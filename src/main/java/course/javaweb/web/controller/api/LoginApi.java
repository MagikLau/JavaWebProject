package course.javaweb.web.controller.api;

import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import freemarker.ext.servlet.HttpSessionHashModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by bboymc on 2017/7/9.
 */
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
//    @ModelAttribute("user") User user,
    public ModelMap login(@RequestParam("userName") String username,@RequestParam("password") String password, ModelMap map,HttpSession httpSession){
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);
        User u =loginService.login(user);
        if (u!=null) {
            map.addAttribute("message","success");
            map.addAttribute("code","200");
            map.addAttribute("result","success");
//            map.addAttribute("user",u);
            httpSession.setAttribute("user",u);
            System.out.println("api user: "+u);

        } else{

            map.addAttribute("code","400");
            map.addAttribute("result","error");
            map.addAttribute("message","登录失败");
        }
        return map;
    }
}
