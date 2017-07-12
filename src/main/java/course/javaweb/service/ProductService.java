package course.javaweb.service;

import course.javaweb.model.Content;
import course.javaweb.model.Product;
import course.javaweb.model.User;

import java.util.List;

public interface ProductService {
    Product getProduct(Content content, User user);
    List<Product> getProductList(User user);
    List<Product> getBuyList(User user);
}
