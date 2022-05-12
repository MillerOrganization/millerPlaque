package ma.millergraphics.it.stock.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.millergraphics.it.stock.model.bo.TaillePlaque;
@RepositoryRestResource
public interface TaillePlaqueRepository extends JpaRepository<TaillePlaque, Long> {

}
