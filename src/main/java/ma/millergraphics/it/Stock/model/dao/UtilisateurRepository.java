package ma.millergraphics.it.Stock.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.millergraphics.it.Stock.model.bo.Utilisateur;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("http://localhost:4200")
@RepositoryRestController
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByUsernameOrMail(String username,String mail);

}
