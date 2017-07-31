package course.javaweb.service.impl;

import course.javaweb.dao.TrxDao;
import course.javaweb.model.Content;
import course.javaweb.model.Trx;
import course.javaweb.model.User;
import course.javaweb.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrxServiceImpl implements TrxService {

    private TrxDao trxDao;

    @Autowired
    public void setTrxDao(TrxDao trxDao) {
        this.trxDao = trxDao;
    }

    public List<Trx> findTrxAllByUser(User user){
        List<Trx> result = trxDao.findTrxAllByUser(user.getId());

        return result;
    }

    public void addTrx(Content content, Integer buyNum, User user){
        Trx trx = new Trx();
        trx.setContentId(content.getId());

        trx.setPersonId(user.getId());
        trx.setPrice(content.getPrice().intValue());
        trx.setTime(System.currentTimeMillis());
// 时间直接获取数据库当前时间now()
        trxDao.addTrx(trx);

    }
}
