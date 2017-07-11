package course.javaweb.service.impl;

import course.javaweb.dao.ContentDao;
import course.javaweb.model.Content;
import course.javaweb.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    private ContentDao contentDao;

    @Autowired
    public void setContentDao(ContentDao contentDao){
        this.contentDao = contentDao;
    }

    public List<Content> findContentAll(){
        List<Content> result;
        result = contentDao.findContentAll();

        return result;
    }
    public Content getContentInfo(Integer id){
        Content c = new Content();
        c.setId(id);
        return contentDao.getContentInfo(c);
    }
}
