package course.javaweb.web.controller.api;

import course.javaweb.model.Content;
import course.javaweb.service.ContentService;
import course.javaweb.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadApi {

    private ContentService contentService;

    @Autowired
    public void setContentService(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/api/upload")
    @ResponseBody
    public ModelMap Upload(@RequestParam("file") MultipartFile file, ModelMap modelMap, HttpServletRequest request) {

        String fileType = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")); // 文件后缀
        System.out.println("fileType is "+fileType);
        if (fileType.equalsIgnoreCase(".jpg")) {//FileType
            String realPath = request.getSession().getServletContext().getRealPath("/static/image");
            System.out.println("realPath is "+realPath);

            String fileName = file.getOriginalFilename();

            fileName = StringUtil.renameFileName(fileName);


            String webFile = "/static/image/" + fileName;
            String realFile = realPath + "/" + fileName;
            try {
                File targetFile = new File(realPath, fileName);
//                file.transferTo(new File(realFile));
                file.transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("realFile is "+realFile);
            System.out.println("webFile is "+webFile);
            modelMap.addAttribute("code", 200);
            modelMap.addAttribute("message", "success");
            modelMap.addAttribute("result", webFile);

        }else{
            modelMap.addAttribute("code", 400);
            modelMap.addAttribute("message", "error");
        }

        return modelMap;
    }
}
