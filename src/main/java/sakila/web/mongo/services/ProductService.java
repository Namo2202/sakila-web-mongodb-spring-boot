package sakila.web.mongo.services;

import sakila.web.mongo.entities.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product read(String id);
    List<Product> readAll();

    Product update(Product product);

    void delete(Long id);

    List<Product> findByStr(String str);
}
