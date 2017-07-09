package course.javaweb.service;

import course.javaweb.model.User;

public interface LoginService {
    User login(String username, String password);
}
