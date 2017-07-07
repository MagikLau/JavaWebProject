package course.javaweb.web.controller;

import course.javaweb.model.AsyncData;
import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class AsyncDataController {

    private static AsyncData asyncData = new AsyncData();

    private LoginService loginService;


    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public AsyncData login(User user) {
        if (loginService.login(user)) {
            asyncData.setCode(200);
            asyncData.setMessage("success");
            asyncData.setResult(true);
        } else {
            asyncData.setCode(400);
            asyncData.setMessage("登录失败，检查用户名或者密码");
            asyncData.setResult(true);
        }
        return asyncData;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public AsyncData delete(@RequestParam("id") Integer id) {
        asyncData.setCode(200);
        asyncData.setMessage("hello");
        asyncData.setResult(false);
        return asyncData;
    }


    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ResponseBody
    public AsyncData delete(List list) {
        asyncData.setCode(200);
        asyncData.setMessage("hello");
        asyncData.setResult(false);
        return asyncData;
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public AsyncData upload(Integer id) {
        asyncData.setCode(200);
        asyncData.setMessage("hello");
        asyncData.setResult(false);
        return asyncData;
    }

}
