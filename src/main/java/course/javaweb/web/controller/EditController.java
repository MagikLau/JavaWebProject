package course.javaweb.web.controller;

import course.javaweb.model.Content;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class EditController {
    private ContentService contentService;
    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping("/edit")
    public ModelAndView edit(HttpSession httpSession, @RequestParam("id") Integer id) {
        Content content1 = null;
        User loginUser = (User) httpSession.getAttribute("user");
        if( loginUser != null ){
            content1 = contentService.getContentInfo(id);
            httpSession.setAttribute("editProduct", content1);
        }else {

        }
        return new ModelAndView("edit","product",content1);
    }

    @RequestMapping("/editSubmit")
    public ModelAndView editSubmit(ModelMap modelMap, HttpSession httpSession,
                                   @RequestParam("price") long price, @RequestParam("title") String title,
                                   @RequestParam("image") String image, @RequestParam("summary") String summary,
                                   @RequestParam("detail") String detail,@RequestParam("id") Integer id) {
        Content product = new Content();
        Content content = null;
        User loginUser = (User) httpSession.getAttribute("user");
        product.setTitle(title);
        product.setSummary(summary);
        product.setDetail(detail);
        product.setImage(image);
        product.setSellerId(loginUser.getId());
        product.setId(id);
        product.setNum(1);
        product.setPrice(price);

        if( loginUser != null ){
            content= contentService.updateContent(product);
            System.out.println("content in Controller-publicSubmit: "+content);
            httpSession.setAttribute("product", content);

            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", content.getImage());
        }else {

        }
        return new ModelAndView("editSubmit","product",content);
    }
}
