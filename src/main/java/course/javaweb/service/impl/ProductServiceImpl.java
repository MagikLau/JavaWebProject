package course.javaweb.service.impl;

import course.javaweb.dao.ContentDao;
import course.javaweb.dao.TrxDao;
import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.Trx;
import course.javaweb.model.User;
import course.javaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ContentDao contentDao;
    private TrxDao trxDao;
    @Autowired
    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }
    @Autowired
    public void setTrxDao(TrxDao trxDao) {
        this.trxDao = trxDao;
    }

    public Product getProduct(Content content, User user){
        Product product = contentDao.getProduct(content);
        List<Trx> trxList = trxDao.findTrxAllByContent(content.getId());
        Trx trx = trxDao.getTrx(content.getId(), user.getId());
        if( user.getUserType() == 0 ){
            if( trx != null ){
                product.setIsBuy(true);
                product.setBuyNum(trx.getNum());
                product.setBuyPrice(trx.getPrice());
                product.setTime(trx.getTime());
            }else{
                product.setIsSell(false);
                product.setBuyNum(0);
            }

        }else if( user.getUserType() == 1 ){
            if( trx != null ){
//                if( trx.getNum() > 0 ){//只做已有售卖记录的标记
//                    product.setIsSell(true);
//                }
                Integer sumSellNum = 0;
                for( Trx t : trxList ){
                    sumSellNum += t.getNum();
                }
                if( sumSellNum >= content.getNum() ){//超出售卖数的标记
                    product.setIsSell(true);//即完卖标记
                }else {
                    product.setBuyNum(sumSellNum);
                    product.setIsSell(false);
                }

            }else {
                product.setIsSell(false);
            }

        }
        System.out.println("product in ProductServce: "+product);
        return product;
    }

    public List<Product> getProductList(User user){
        List<Product> productList = new ArrayList<Product>();
        List<Trx> trxList = trxDao.findTrxAllByUser(user.getId());
        List<Content> contentList = contentDao.findContentAll();
        for( Content content : contentList ){
            Product product = contentDao.getProduct(content);
            Trx trx = trxDao.getTrx(content.getId(), user.getId());
            if( trx != null ) {
                product.setIsBuy(true);
            }else{
                product.setIsBuy(false);
            }
            if( user.getUserType() == 1 ){
                if( trx != null && content.getSellerId().equals(user.getId()) ) {
                    Integer sumSellNum = 0;
                    for( Trx t : trxList ){
                        sumSellNum += t.getNum();
                    }
                    if( sumSellNum >= content.getNum() ){//超出售卖数的标记
                        product.setIsSell(true);//即完卖标记
                    }else {
                        product.setBuyNum(sumSellNum);
                        product.setIsSell(false);
                    }
                }else{
                    product.setIsSell(false);
                }
            }

            productList.add(product);
        }
        System.out.println("productList in ProductServce: "+productList);
        return productList;
    }
}
