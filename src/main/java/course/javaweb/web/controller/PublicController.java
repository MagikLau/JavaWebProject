package course.javaweb.web.controller;

import com.sun.deploy.net.HttpResponse;
import course.javaweb.model.Content;
import course.javaweb.model.User;
import course.javaweb.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class PublicController {
    private ContentService contentService;

    @Autowired
    public PublicController setContentService(ContentService contentService) {
        this.contentService = contentService;
        return this;
    }

    @RequestMapping("/public")
    public String publicSells() {
        return "public";
    }

    @RequestMapping("/publicSubmit")
    public String publicSubmit(ModelMap modelMap, HttpSession httpSession, //HttpResponse httpResponse,
                               @RequestParam("price") Integer price, @RequestParam("title") String title,
                               @RequestParam("image") String image, @RequestParam("summary") String summary,
                               @RequestParam("detail") String detail) {
        User loginUser = (User) httpSession.getAttribute("user");
        if( loginUser != null ){
            Content content = contentService.addContent(loginUser.getId(),
                    price, title, image, summary, detail, 1);
            System.out.println("content in Controller-publicSubmit: "+content);
//            modelMap.addAttribute("product", content);
            httpSession.setAttribute("product", content);
        }else {

        }

        return "publicSubmit";
    }
}
