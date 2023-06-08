package sakila.web.mongo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sakila.web.mongo.entities.Product;
import sakila.web.mongo.repositories.ProductRepository;
import sakila.web.mongo.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
@AllArgsConstructor
@CrossOrigin
public class ProductController {
    private ProductService service;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        log.trace("Product create -->{}",product);
        return service.create(product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id){
        return service.read(String.valueOf(id));
    }
    @GetMapping("/all")
    public List<Product> getAll(){
        return service.readAll();
    }
    @GetMapping("/search/{str}")
    public List<Product> serachFor(@PathVariable String str){
        return service.findByStr(str);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable String id,@RequestBody  Product updatedProduct) {
        var existingProduct = service.read(id);
        if (existingProduct == null) {
            return null;
        }
        else {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setCode(updatedProduct.getCode());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPicture(updatedProduct.getPicture());
            existingProduct.setCategorie(updatedProduct.getCategorie());
            existingProduct.setPrice(updatedProduct.getPrice());
            return service.update(existingProduct);
        }


    }

}
