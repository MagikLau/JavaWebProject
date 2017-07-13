package course.javaweb.web.controller;

import course.javaweb.dao.TrxDao;
import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.Trx;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import course.javaweb.service.ProductService;
import course.javaweb.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class IndexController {

    private ContentService contentService;
    private ProductService productService;
    private TrxDao trxDao;
    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @Autowired
    public void setTrxDao(TrxDao trxDao) {
        this.trxDao = trxDao;
    }

    @RequestMapping(path = {"/", "/index"})
    public String index(ModelMap modelMap, HttpSession httpSession,@RequestParam(value = "type", required = false) Integer type) {
        System.out.println("httpSession in indexController: "+httpSession.getAttribute("user"));
        User loginUser = (User) httpSession.getAttribute("user");
        List<Content> contentList = contentService.findContentAll();
        List<Product> productList;

        if (null == type) {
            type = 0;
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("type", type);
        modelMap.addAttribute("RequestParameters", map);

        if( loginUser == null ){
//            modelMap.addAttribute("productList", contentList);
            httpSession.setAttribute("productList", contentList);
        }else{
            httpSession.removeAttribute("productList");
//            modelMap.remove("productList");
            System.out.println("In IndexC LoginUser: "+loginUser);
            productList = productService.getProductList(loginUser);
//            modelMap.addAttribute("productList", productList);
            if (type.equals(1)) {
                for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext();
                        ) {
                    Product product = iterator.next();
                    if (product.getIsBuy() == true) {//已购买内容删除
                        iterator.remove();
                    }
                }
            }
            httpSession.setAttribute("productList", productList);
        }
//        System.out.println("modelMap.get(\"productList\"): "+modelMap.get("productList"));
        System.out.println("httpSession productList: "+httpSession.getAttribute("productList"));
        return "index";
    }


}
