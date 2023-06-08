package sakila.web.mongo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sakila.web.mongo.entities.Product;
import sakila.web.mongo.repositories.ProductRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product read(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(String.valueOf(id));
    }

    @Override
    public List<Product> findByStr(String str) {
        return productRepository.findProductByNameContainingIgnoreCaseOrCategorieContainingIgnoreCase(str,str);
    }
}
