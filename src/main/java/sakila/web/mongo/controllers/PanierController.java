package sakila.web.mongo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sakila.web.mongo.entities.Panier;
import sakila.web.mongo.services.PanierService;

import java.util.List;

@RestController
@RequestMapping("/panier")
@Slf4j
@AllArgsConstructor
@CrossOrigin
public class PanierController {
    private PanierService service;

    @PostMapping("/create")
    public Panier create(@RequestBody Panier panier){
        log.trace("Panier create -->{}",panier);
        return service.create(panier);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Panier getOne(@PathVariable String id){
        return service.read(id);
    }
    @GetMapping("/all")
    public List<Panier> getAll(){
        return service.readAll();
    }
}
