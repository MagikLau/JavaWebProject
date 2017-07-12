package course.javaweb.service.impl;

import course.javaweb.dao.TrxDao;
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
    public void addTrx(){

    }
}
