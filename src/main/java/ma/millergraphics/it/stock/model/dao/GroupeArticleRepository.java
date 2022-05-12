package ma.millergraphics.it.stock.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.millergraphics.it.stock.model.bo.GroupeArticle;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GroupeArticleRepository extends JpaRepository<GroupeArticle,Long>{

}
