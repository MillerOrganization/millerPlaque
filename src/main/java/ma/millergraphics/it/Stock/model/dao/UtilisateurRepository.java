package ma.millergraphics.it.Stock.model.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.millergraphics.it.Stock.model.bo.Utilisateur;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestController
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	@RestResource(path = "/byUsername")
	Utilisateur findByUsernameOrMail(@Param("username") String username,@Param("username") String mail);
	@RestResource(path = "/byKeyword")
	List<Utilisateur> findByNomContainsOrPrenomContainsOrUsernameContains(@Param("kw") String kw,
																		  @Param("kw") String kw1,
																		  @Param("kw") String kw2);
}
