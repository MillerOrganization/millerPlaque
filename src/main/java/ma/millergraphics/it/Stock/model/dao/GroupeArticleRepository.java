package ma.millergraphics.it.Stock.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.millergraphics.it.Stock.model.bo.GroupeArticle;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface GroupeArticleRepository extends JpaRepository<GroupeArticle,Long>{

}
