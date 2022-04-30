package ma.millergraphics.it.Stock.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.millergraphics.it.Stock.model.bo.TaillePlaque;
@RepositoryRestResource
public interface TaillePlaqueRepository extends JpaRepository<TaillePlaque, Long> {

}
