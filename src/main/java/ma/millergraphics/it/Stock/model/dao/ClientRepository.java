package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface ClientRepository extends JpaRepository<Client,Long> {

    @RestResource(path = "/byNom")
    @Query("select c from Client as c where c.nom like %:nom%")
    List<Client> getClients(String nom);
}
