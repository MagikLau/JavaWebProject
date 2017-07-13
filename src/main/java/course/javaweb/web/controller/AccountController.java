package course.javaweb.web.controller;

import course.javaweb.model.Product;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import course.javaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AccountController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/account")
    public ModelAndView account( HttpSession httpSession) {
        User loginUser = (User) httpSession.getAttribute("user");
        List<Product> productList = null;
        if( loginUser == null ){
            System.out.println("Not Login yet in account.");
        }else{
//            httpSession.removeAttribute("productList");
            System.out.println("In AccountC LoginUser: "+loginUser);
            productList = productService.getBuyList(loginUser);
            System.out.println("In AccountC productList: "+productList);
//            httpSession.setAttribute("buyList", productList);
        }
        return new ModelAndView("account","buyList",productList);
    }
}
