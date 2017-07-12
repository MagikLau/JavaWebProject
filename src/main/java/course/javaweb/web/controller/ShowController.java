package course.javaweb.web.controller;

import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import course.javaweb.service.ProductService;
import course.javaweb.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

import static javafx.scene.input.KeyCode.H;

@Controller
public class ShowController {

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

    @RequestMapping("/show")
    public ModelMap show(@RequestParam("id") Integer id, ModelMap modelMap, HttpSession httpSession) {
        Product product ;
        Content content = contentService.getContentInfo(id);
        User loginUser = (User) httpSession.getAttribute("user");
        if( loginUser == null ){
            modelMap.addAttribute("product", content);
            System.out.println("In show : modelMap.get(\"product\"): (in fact: content) "+modelMap.get("product"));
        }else{
            product = productService.getProduct(content, loginUser);
            modelMap.addAttribute("product", product );
            System.out.println("In show : modelMap.get(\"product\"): "+modelMap.get("product"));
        }

        return modelMap;
    }
}
