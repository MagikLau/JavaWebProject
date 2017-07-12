package course.javaweb.web.controller.api;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.XmlRequestWrapper;
import course.javaweb.model.Product;
import course.javaweb.model.Trx;
import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import course.javaweb.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class SettleAccountApi {
    private TrxService trxService;

    @Autowired
    public void setTrxService(TrxService trxService) {
        this.trxService = trxService;
    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST,produces = MediaType.JSON)
    @ResponseBody
    public ModelMap SettleAccount(HttpSession httpSession){
        User loginUser = (User) httpSession.getAttribute("user");
        System.out.println("loginUser in SettleAccount: " + loginUser);
        //System.out.println("buyList in SettleAccount: " + xhr.toString());



    }
}
