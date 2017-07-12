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
    public ModelAndView account(ModelMap modelMap, HttpSession httpSession) {
        User loginUser = (User) httpSession.getAttribute("user");
        List<Product> productList = null;
        if( loginUser == null ){

        }else{
//            httpSession.removeAttribute("productList");
//            modelMap.remove("productList");
            System.out.println("In AccountC LoginUser: "+loginUser);
            productList = productService.getProductList(loginUser);
//            modelMap.addAttribute("buyList", productList);
//            httpSession.setAttribute("buyList", productList);
        }
        return new ModelAndView("account","buyList",productList);
    }
}
