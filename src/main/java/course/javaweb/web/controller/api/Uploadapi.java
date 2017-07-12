package course.javaweb.web.controller.api;

import course.javaweb.model.Content;
import course.javaweb.model.User;
import course.javaweb.service.AddContentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;

/**
 * Created by bboymc on 2017/7/11.
 */
@Controller

public class Uploadapi {

    @RequestMapping(value = "/api/upload")
    @ResponseBody
    public ModelMap upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession httpSession,ModelMap map){
        String filePath = null;

        String path = "/static/image/"+file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                 filePath = request.getSession().getServletContext().getRealPath("/static/image")+"/"
                        + file.getOriginalFilename();
                // 转存文件
                System.out.println(filePath);
                file.transferTo(new File(filePath));
//                map.addAttribute("")
                httpSession.setAttribute("filepath",filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            map.addAttribute("code", 200);
            map.addAttribute("message", "success");
            map.addAttribute("result",path);
            return map;

        }
        map.addAttribute("code", 400);
        map.addAttribute("message", "error");

        return map;
    }
}
