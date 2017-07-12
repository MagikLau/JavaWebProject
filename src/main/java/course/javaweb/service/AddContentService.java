package course.javaweb.service;

import course.javaweb.model.Content;

import java.util.List;

/**
 * Created by bboymc on 2017/7/11.
 */
public interface AddContentService {
    int AddContent(Content content);
    List<Content> GetAllContent();
}
