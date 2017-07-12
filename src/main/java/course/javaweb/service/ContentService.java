package course.javaweb.service;

import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.User;

import java.util.List;

public interface ContentService {
    List<Content> findContentAll();
    Content getContentInfo(Integer id);
    Content addContent(Integer userid, Integer price, String title, String image, String summary, String detail, Integer num);
}
