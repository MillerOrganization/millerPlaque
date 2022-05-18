package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.ListPlaques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface ListPlaquesRepository extends JpaRepository<ListPlaques,Long> {
    @RestResource(path = "/byKeyword")
    List<ListPlaques> findByDesignationContainsOrNumeroArticleContains(@Param("kw") String designation,
                                                               @Param("kw") String numeroArticle);
}
