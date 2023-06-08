package sakila.web.mongo.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sakila.web.mongo.entities.Panier;
import sakila.web.mongo.repositories.PanierRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PanierServiceImpl implements  PanierService{

    private PanierRepository panierRepository;
    @Override
    public Panier create(Panier panier) {
        return panierRepository.save(panier);
    }

    @Override
    public Panier read(String id) {
        return panierRepository.findById(id).orElse(null);
    }

    @Override
    public List<Panier> readAll() {
        return panierRepository.findAll();
    }

    @Override
    public Panier update(Panier panier) {
        return panierRepository.save(panier);
    }


    @Override
    public void delete(String id) {
        panierRepository.deleteById(String.valueOf(id));
    }



}
