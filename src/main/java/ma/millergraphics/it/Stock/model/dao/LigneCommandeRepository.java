package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.Commande;
import ma.millergraphics.it.Stock.model.bo.Consomable;
import ma.millergraphics.it.Stock.model.bo.LigneCommande;
import ma.millergraphics.it.Stock.model.bo.LigneCommandeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collection;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Long> {
    @RestResource(path = "byCommande")
    Collection<LigneCommande> findByCommande_Id(Long commande);
}
