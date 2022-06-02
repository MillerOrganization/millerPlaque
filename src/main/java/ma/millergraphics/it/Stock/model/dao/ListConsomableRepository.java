package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.ListConsomable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface ListConsomableRepository extends JpaRepository<ListConsomable,Long> {
    @RestResource(path = "/byKeyword")
    @Query("select c from ListConsomable  as c where c.designation LIKE %?1%"+
            " or c.categorie.designation LIKE %?1% or c.numeroArticle LIKE %?1%")
    List<ListConsomable> findBykeyWord(@Param("kw") String keyword);
    ListConsomable findByDesignation(String designation);
}
