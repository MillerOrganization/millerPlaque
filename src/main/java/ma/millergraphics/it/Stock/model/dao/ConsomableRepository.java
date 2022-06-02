package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.Consomable;
import ma.millergraphics.it.Stock.model.bo.ListConsomable;
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
public interface ConsomableRepository extends JpaRepository<Consomable,Long> {
    Consomable findByListConsomable(ListConsomable listConsomable);
    @RestResource(path = "/byKeyword")
    @Query(value = "select c from Consomable as c where c.listConsomable.designation LIKE %:keyword%"+
    " or c.listConsomable.categorie.designation LIKE %:keyword%")
    List<Consomable> findByKeyword(String keyword);
}
