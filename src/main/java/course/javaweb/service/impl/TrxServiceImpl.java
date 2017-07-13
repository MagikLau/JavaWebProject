package course.javaweb.service.impl;

import course.javaweb.dao.ContentDao;
import course.javaweb.dao.TrxDao;
import course.javaweb.model.BuyInfo;
import course.javaweb.model.Content;
import course.javaweb.model.Trx;
import course.javaweb.model.User;
import course.javaweb.service.TrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TrxServiceImpl implements TrxService {

    private TrxDao trxDao;
    private ContentDao contentDao;

    @Autowired
    public void setTrxDao(TrxDao trxDao) {
        this.trxDao = trxDao;
    }
    @Autowired
    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    public List<Trx> findTrxAllByUser(User user){
        List<Trx> result = trxDao.findTrxAllByUser(user.getId());

        return result;
    }
    public void addTrx(BuyInfo buyInfo, User user){
        Content content = new Content();
        content.setId(buyInfo.getId());
        content = contentDao.getContentInfo(content);
        Trx trx = new Trx();
        trx.setContentId(content.getId());
        trx.setNum(buyInfo.getNumber());
        trx.setPersonId(user.getId());
        trx.setPrice(content.getPrice().intValue());
        trx.setTime((new Date()).getTime());
        trxDao.addTrx(trx);
        System.out.println("addTrx in TrxServiceImpl: " + trx);
    }
}
