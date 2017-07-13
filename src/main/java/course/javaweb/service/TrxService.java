package course.javaweb.service;

import course.javaweb.model.Content;
import course.javaweb.model.Trx;
import course.javaweb.model.User;

import java.util.List;

public interface TrxService {
    List<Trx> findTrxAllByUser(User user);
    void addTrx(Content content, Integer buyNum, User user);
}
