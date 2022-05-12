package ma.millergraphics.it.stock.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.millergraphics.it.stock.model.bo.Plaque;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface PlaqueRepository<T extends Plaque> extends JpaRepository<T, Long>{

}
