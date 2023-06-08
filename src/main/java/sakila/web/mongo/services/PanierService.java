package sakila.web.mongo.services;

import sakila.web.mongo.entities.Panier;
import sakila.web.mongo.entities.Product;

import java.util.List;

public interface PanierService {

    Panier create(Panier panier);
    Panier read(String id);
    List<Panier> readAll();

    Panier update(Panier panier);

    void delete(String id);
}
