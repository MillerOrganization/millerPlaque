package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.UtilisateurConsomable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestController
public interface UtilisateurConsomableRepository extends JpaRepository<UtilisateurConsomable,Long> {
}
