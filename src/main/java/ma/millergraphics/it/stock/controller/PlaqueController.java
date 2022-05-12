package ma.millergraphics.it.stock.controller;

import lombok.extern.log4j.Log4j2;
import ma.millergraphics.it.stock.model.bo.Plaque;
import ma.millergraphics.it.stock.service.PlaquesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/plaque")
public class PlaqueController {

    private final PlaquesService plaquesService;

    public PlaqueController(PlaquesService plaquesService) {
        this.plaquesService = plaquesService;
    }

    @GetMapping(path = "/")
    public List<Plaque> getPlaques(){
        log.info("getting all plaques");
        return plaquesService.getAllPlaques();
    }

    @GetMapping(path = "/{id}")
    public Plaque getById(@PathVariable Long id){
        log.info("getting plaque id = " + id);
        return plaquesService.getOnePlaque(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public void deletePlaque(@PathVariable Long id,
                             @RequestHeader(value = "Authorization", required=false) String credentials){
        log.info("delete plaque id = " + id);
        plaquesService.deletePlaque(id);
    }
}
