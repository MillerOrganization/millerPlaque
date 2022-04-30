package ma.millergraphics.it.Stock.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.millergraphics.it.Stock.model.bo.Role;

import java.util.List;

@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByDesignation(String designation);
}
