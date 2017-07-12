package course.javaweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SettleAccountController {
    @RequestMapping(value = "/settleAccount")
    public String settleAccount(HttpSession httpSession) {
        return "settleAccount";
    }
}
