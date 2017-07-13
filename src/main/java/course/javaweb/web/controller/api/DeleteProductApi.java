package course.javaweb.web.controller.api;

import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.User;
import course.javaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class DeleteProductApi {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/api/delete", method = RequestMethod.POST)
    @ResponseBody
    public ModelMap deleteProductApi(@RequestParam("id") Integer id, HttpSession httpSession, ModelMap modelMap){

        System.out.println("data in deleteProductApi: "+id);

        int code = 201;
        String message = "default";
        Boolean result = false;

        Content content = new Content();
        content.setId(id);

        User loginUser = (User) httpSession.getAttribute("user");
        if (loginUser!=null){
            Product product = productService.getProduct(content, loginUser);
            String returnMassage = productService.deleteProduct(product);
            System.out.println("DeleteReturnMassage: "+returnMassage);
            if(returnMassage.equals("Success")){
                code = 200;
                message = "success";
                result = true;
            }else if(returnMassage.equals("IsSell")){
                code = 402;
                message = returnMassage;
            }else if(returnMassage.equals("DeleteFailed")){
                code = 403;
                message = returnMassage;
            }else if(returnMassage.equals("DeleteError")){
                code = 404;
                message = returnMassage;
            }else if(returnMassage.equals("getIdFailed")){
                code = 405;
                message = returnMassage;
            }else if(returnMassage.equals("NullPointerException")){
                code = 406;
                message = returnMassage;
            }else if(returnMassage.equals("GetIdFailed")){
                code = 407;
                message = returnMassage;
            }

        }else{
            code = 401;
            message = "NotLogin";
        }


        modelMap.addAttribute("code", code);
        modelMap.addAttribute("message", message);
        modelMap.addAttribute("result", result);

        return modelMap;
    }
}
