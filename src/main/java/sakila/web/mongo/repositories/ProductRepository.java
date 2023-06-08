package sakila.web.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import sakila.web.mongo.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
    List<Product> findProductByNameContainingIgnoreCaseOrCategorieContainingIgnoreCase(String str1, String str2);
}
