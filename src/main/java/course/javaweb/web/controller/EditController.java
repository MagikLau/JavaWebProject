package course.javaweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditController {
    @RequestMapping("/edit")
    public ModelAndView edit() {
        return new ModelAndView("edit");
    }

    @RequestMapping("/editSubmit")
    public ModelAndView editSubmit() {
        return new ModelAndView("editSubmit");
    }
}
