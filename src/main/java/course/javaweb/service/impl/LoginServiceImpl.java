package course.javaweb.service.impl;

import course.javaweb.dao.UserDao;
import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        User userInfo = userDao.getUserInfo(user);
        System.out.println("userInfo in service: "+userInfo);
        System.out.println("user in service: "+user);
        if (userInfo != null) {
            if (userInfo.getPassword().equals(user.getPassword())) {
                BeanUtils.copyProperties(userInfo, user);
                System.out.println("Password checked.");
            }else{
                System.out.println("Wrong password.");
                userInfo = null;
            }
        }
        return user;
    }
}
