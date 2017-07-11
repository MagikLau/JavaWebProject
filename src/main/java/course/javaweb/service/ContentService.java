package course.javaweb.service;

import course.javaweb.model.Content;
import course.javaweb.model.User;

import java.util.List;

public interface ContentService {
    List<Content> findContentAll();
    Content getContentInfo(Integer id);
}
