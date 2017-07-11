package course.javaweb.service.impl;

import course.javaweb.dao.UserDao;
import course.javaweb.model.User;
import course.javaweb.service.LoginService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service

public class LoginServiceImpl implements LoginService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User login(User user) {

        User userInfo = userDao.getUserInfo(user);

        if (userInfo != null) {
            System.out.println("berfore user: "+user);
            System.out.println("berfore userInfo : "+userInfo);
            if (userInfo.getPassword().equals(user.getPassword())) {
                BeanUtils.copyProperties(userInfo, user);
                System.out.println("after user: "+user);
                System.out.println("after userInfo: "+userInfo);
                return user;
            }
            return null;
        }
        return null ;
    }
}