package course.javaweb.web.controller;

import course.javaweb.model.Content;
import course.javaweb.service.AddContentService;
import course.javaweb.web.controller.api.Uploadapi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PublicController {
    private AddContentService addContentService;

    @Autowired
    public void setAddContentService(AddContentService addContentService) {
        this.addContentService = addContentService;
    }
    @RequestMapping(value = "/public")
    public ModelAndView publicSells() {
        return new ModelAndView("public");
    }

    @RequestMapping("/publicSubmit")
    public ModelAndView publicSubmit(@RequestParam("title")String title, @RequestParam("summary")String summary
    , @RequestParam("detail")String text, @RequestParam("price") long price, HttpSession httpSession) {

        String icon = (String) httpSession.getAttribute("filepath");
        Content content = new Content();
        content.setIcon(icon);
        content.setPrice(price);
        content.setSummary(summary);
        content.setText(text);
        content.setTitle(title);
       int contentid = addContentService.AddContent(content);
        content.setId(contentid);
//        List<Content> contents = addContentService.GetAllContent();
        httpSession.setAttribute("product",content);

        return new ModelAndView("publicSubmit","product",content);

    }
}
