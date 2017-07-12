package course.javaweb.web.controller;

import course.javaweb.dao.TrxDao;
import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import course.javaweb.service.ProductService;
import course.javaweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    private ContentService contentService;
    private ProductService productService;
    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path = {"/", "/index"})
    public String index(ModelMap modelMap, HttpSession httpSession) {
        System.out.println("httpSession in indexController: "+httpSession.getAttribute("user"));
        User loginUser = (User) httpSession.getAttribute("user");
        List<Content> contentList = contentService.findContentAll();
        if( contentList != null ){
            StringUtil.fileNum = contentList.get(contentList.size()-1).getId()+1;//设置文件上传时使用的编号
        }
        List<Product> productList;
        if( loginUser == null ){
//            modelMap.addAttribute("productList", contentList);
            httpSession.setAttribute("productList", contentList);
        }else{
            httpSession.removeAttribute("productList");
//            modelMap.remove("productList");
            System.out.println("In IndexC LoginUser: "+loginUser);
            productList = productService.getProductList(loginUser);
//            modelMap.addAttribute("productList", productList);
            httpSession.setAttribute("productList", productList);
        }
//        System.out.println("modelMap.get(\"productList\"): "+modelMap.get("productList"));
        System.out.println("httpSession productList: "+httpSession.getAttribute("productList"));
        return "index";
    }


}
