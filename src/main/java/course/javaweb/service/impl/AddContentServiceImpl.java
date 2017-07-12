package course.javaweb.service.impl;

import course.javaweb.dao.ContentDao;
import course.javaweb.model.Content;
import course.javaweb.service.AddContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bboymc on 2017/7/11.
 */
@Service
public class AddContentServiceImpl implements AddContentService {
    private ContentDao contentDao;
    @Autowired
    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }
    public int AddContent(Content content){
       int id  = contentDao.addContent(content);
        System.out.println(content.getId());
        return id;
    }
    public List<Content> GetAllContent(){
        List<Content> contents = contentDao.GetAllContent();
        return contents;
    }
}
