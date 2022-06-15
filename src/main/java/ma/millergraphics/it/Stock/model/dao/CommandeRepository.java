package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface CommandeRepository extends JpaRepository<Commande,Long> {
    /*@RestResource(path = "/byClient")

    Collection<Commande> commandesByCommercial(String username);*/
    @RestResource(path = "/byCommercial")
    Collection<Commande> findByCommercial_Username(String username);
}
