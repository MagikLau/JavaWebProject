package course.javaweb.dao;

import course.javaweb.model.Content;
import course.javaweb.model.Product;

import java.util.List;

public interface ContentDao {
    Content getContentInfo(Content content);
    List<Content> findContentAll();
    Product getProduct(Content content);
}
