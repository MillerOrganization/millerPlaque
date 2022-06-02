package ma.millergraphics.it.Stock.controller;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.Consomable;
import ma.millergraphics.it.Stock.model.service.ConsomableService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin("http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping(path = "consomable")
public class ConsomableController {
    private ConsomableService consomableService;
    @GetMapping(path = {"","/"})
    public Collection<Consomable> getConsomables(){
        return consomableService.getConsomables();
    }

    @GetMapping(path = "/byListConsomable")
    public Consomable getConsomableByListConsomable(@RequestParam("lc") String lc){
        return consomableService.getConsomableByListConsomable(lc);
    }
}
