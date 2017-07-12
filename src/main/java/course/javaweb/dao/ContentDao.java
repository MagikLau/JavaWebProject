package course.javaweb.dao;

import course.javaweb.model.Content;

import java.util.List;

/**
 * Created by bboymc on 2017/7/11.
 */
public interface ContentDao {
    int addContent(Content content);
    List<Content> GetAllContent();
}
