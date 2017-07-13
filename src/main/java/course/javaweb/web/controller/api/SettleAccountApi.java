package course.javaweb.web.controller.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import course.javaweb.model.Content;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import course.javaweb.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class SettleAccountApi {

    private ContentService contentService;
    private TrxService trxService;

    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }
    @Autowired
    public void setTrxService(TrxService trxService) {
        this.trxService = trxService;
    }

    @RequestMapping(value = "/api/buy", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap settleAccount(@RequestBody String data, HttpSession httpSession, ModelMap modelMap){

        User loginUser = (User) httpSession.getAttribute("user");
        if( loginUser != null ){
            System.out.println("data: "+data);

            List<JSONObject> jsonObjectList = JSON.parseArray(data, JSONObject.class);
            for( JSONObject jsonObject : jsonObjectList ){
                Integer id = jsonObject.getInteger("id");
                Integer num = jsonObject.getInteger("number");
                System.out.println("JsonObj id: "+id+", num: "+num+"; ");
                Content content = contentService.getContentInfo(id);
                trxService.addTrx(content, num, loginUser);
                System.out.println("SettleAccountApi AddTrx Successful");
            }

            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", true);
        }else{
            modelMap.addAttribute("code", 401);
            modelMap.addAttribute("message", "failed");
        }


        return modelMap;
    }

}
