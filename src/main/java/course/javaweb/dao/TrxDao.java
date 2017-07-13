package course.javaweb.dao;

import course.javaweb.model.Trx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrxDao {
    List<Trx> findTrxAllByUser(Integer userid);
    List<Trx> findTrxAllByContent(Integer contentid);
    Trx getTrx(@Param("contentid") Integer contentid, @Param("userid") Integer userid);
    void addTrx(Trx trx);
}
