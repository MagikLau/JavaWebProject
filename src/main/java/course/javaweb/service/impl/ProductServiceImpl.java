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
        if( user.getUserType() == 0 ){
            Trx trx = trxDao.getTrx(content.getId(), user.getId());
            product.setIsSell(false);
            if( trx != null ){
                product.setIsBuy(true);
                product.setBuyPrice(trx.getPrice());
                product.setTime(trx.getTime());
            }
        }else if( user.getUserType() == 1 ){
            List<Trx> trxList = trxDao.findTrxAllByContent(content.getId());
            product.setIsSell(false);
            if( !trxList.isEmpty() ){
                System.out.println("Seller: getProduct- setIsSell");
                product.setBuyNum(trxList.size());
                product.setIsSell(true);
            }
            System.out.println("IsSell? "+product.getIsSell());
        }
        System.out.println("product in ProductService: "+product);
        return product;
    }

    public List<Product> getProductList(User user){
        List<Product> productList = new ArrayList<Product>();
        List<Content> contentList = contentDao.findContentAll();
        for( Content content : contentList ){
            Product product = contentDao.getProduct(content);

            if( user.getUserType() == 0 ){
                Trx trx = trxDao.getTrx(content.getId(), user.getId());
                product.setIsBuy(false);
                if( trx != null ) {
                    product.setIsBuy(true);
                    product.setBuyPrice(trx.getPrice());
                    product.setTime(trx.getTime());
                }
            }else if( user.getUserType() == 1 ){
                List<Trx> trxList = trxDao.findTrxAllByContent(content.getId());
                product.setIsSell(false);
                if( !trxList.isEmpty() ) {
                    System.out.println("Seller: getProductList- setIsSell");
                    product.setBuyNum(trxList.size());
                    product.setIsSell(true);
                }
            }
            System.out.println("IsSell? "+product.getIsSell());
            productList.add(product);
        }
        System.out.println("productList in ProductService: "+productList);
        return productList;
    }

    public List<Product> getBuyList(User user){
        List<Product> buyList = null;
        List<Trx> trxList = trxDao.findTrxAllByUser(user.getId());
        if( trxList != null ){
            buyList = new ArrayList<Product>();
            for ( Trx t : trxList ){
                Content content = new Content();
                content.setId(t.getContentId());
                Product product = contentDao.getProduct(content);
//                product.setBuyNum(t.getNum());
                product.setBuyPrice(t.getPrice());
                product.setIsBuy(true);
                System.out.println("t.getTime(): "+t.getTime());
                product.setTime(t.getTime());
                buyList.add(product);
            }
        }
        System.out.println("buyList in getBuyList: "+buyList);
        return buyList;
    }

    public String deleteProduct(Product product){

        if(product==null){
            return "NullPointerException";
        }
        if(product.getId()==null||product.getId()==0){
            return "GetIdFailed";
        }
        if(product.getIsSell()){
            return "IsSell";
        }

        int affectedRow = contentDao.deleteContent(product.getId());


        if( affectedRow == 1 ){
            return "Success";
        }else if( affectedRow == 0 ){
            return "DeleteFailed";
        }else{
            return "DeleteError";
        }
    }

}
