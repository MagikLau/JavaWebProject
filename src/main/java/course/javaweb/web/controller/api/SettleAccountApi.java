package course.javaweb.web.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.XmlRequestWrapper;
import course.javaweb.model.BuyInfo;
import course.javaweb.model.Product;
import course.javaweb.model.Trx;
import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import course.javaweb.service.TrxService;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class SettleAccountApi {
    private TrxService trxService;

    @Autowired
    public void setTrxService(TrxService trxService) {
        this.trxService = trxService;
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap SettleAccount(@RequestBody String data, HttpSession httpSession,ModelMap map){
        User loginUser = (User) httpSession.getAttribute("user");
        System.out.println("loginUser in SettleAccount: " + loginUser);

        List<BuyInfo> buyInfos = JSON.parseArray(data, BuyInfo.class);
        try {
            for(BuyInfo buyInfo : buyInfos) {
                System.out.println("buyInfo in SettleAccount: " + buyInfo.getId() + " " + buyInfo.getNumber());
                trxService.addTrx(buyInfo,loginUser);
                System.out.println("addTrx in SettleAccountApi ");
            }
            System.out.println("SettleAccountApi AddTrx Successful");
            map.addAttribute("code", 200);
            map.addAttribute("status", 200);
            map.addAttribute("message", "success");
        }catch (Exception e){
            map.addAttribute("code", 404);
            map.addAttribute("status", 304);
            map.addAttribute("message", "failed");
        }
        return map;
    }
}
