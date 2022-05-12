package ma.millergraphics.it.stock.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import ma.millergraphics.it.stock.model.bo.Utilisateur;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("http://localhost:4200")
@RepositoryRestController
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByUsernameOrMail(String username,String mail);

}
