package ma.millergraphics.it.stock.cofiguration;

import ma.millergraphics.it.stock.model.bo.Plaque;
import ma.millergraphics.it.stock.model.dao.PlaqueRepository;
import ma.millergraphics.it.stock.service.PlaqueServiceImp;
import ma.millergraphics.it.stock.service.PlaquesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * the plaques configuration
 */

@Configuration
public class PlaquesConfiguration {

    @Bean
    public PlaquesService plaquesService(PlaqueRepository<Plaque> plaqueRepository){
        return new PlaqueServiceImp(plaqueRepository);
    }
}
