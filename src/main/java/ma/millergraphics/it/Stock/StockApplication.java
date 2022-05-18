package ma.millergraphics.it.Stock;

import ma.millergraphics.it.Stock.model.bo.*;
import ma.millergraphics.it.Stock.model.dao.ListPlaquesRepository;
import ma.millergraphics.it.Stock.model.dao.PlaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@SpringBootApplication
public class StockApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}
	@Autowired
	RepositoryRestConfiguration configuration;
	@Autowired
	PlaqueRepository plaqueRepository;
	@Autowired
	ListPlaquesRepository listPlaquesRepository;
	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Utilisateur.class, TaillePlaque.class, GroupeArticle.class,Role.class
		,ListPlaques.class,Plaque.class);
	}
}
