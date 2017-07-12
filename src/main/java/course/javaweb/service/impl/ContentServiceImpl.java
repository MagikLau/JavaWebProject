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

    public Content addContent(Integer userid, Integer price, String title, String image, String summary, String detail, Integer num){
        Content content = new Content();

        content.setPrice(price.longValue());
        content.setTitle(title);
        content.setImage(image);
        content.setSummary(summary);
        content.setDetail(detail);
        content.setSellerId(userid);
        content.setNum(num);
        System.out.println("Before AddContent in Service: "+content);

        contentDao.addContent(content);

        System.out.println("After AddContent in Service: "+content);

        return content;
    }
}
