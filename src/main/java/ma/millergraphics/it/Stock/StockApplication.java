package ma.millergraphics.it.Stock;

import ma.millergraphics.it.Stock.model.bo.*;
import ma.millergraphics.it.Stock.model.dao.ListPlaquesRepository;
import ma.millergraphics.it.Stock.model.dao.PlaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
@CrossOrigin("http://localhost:4200")
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class StockApplication implements CommandLineRunner ,WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
				.allowedHeaders("*")
				.allowedOrigins("http://localhost:4200","http://localhost:8081");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
	public static void main(String[] args) {
		SpringApplication.run(StockApplication.class, args);
	}
	@Autowired
	RepositoryRestConfiguration configuration;
	@Autowired
	PlaqueRepository plaqueRepository;
	@Autowired
	ListPlaquesRepository listPlaquesRepository;

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		configuration.exposeIdsFor(Utilisateur.class, TaillePlaque.class, GroupeArticle.class,Role.class
		,ListPlaques.class,Plaque.class);
	}
}
