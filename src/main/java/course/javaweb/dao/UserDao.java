package course.javaweb.dao;

import course.javaweb.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    User getUserInfo(User user);
}
