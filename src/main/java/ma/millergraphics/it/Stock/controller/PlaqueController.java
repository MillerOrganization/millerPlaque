package ma.millergraphics.it.Stock.controller;

import ma.millergraphics.it.Stock.model.bo.Chute;
import ma.millergraphics.it.Stock.model.bo.Plaque;
import ma.millergraphics.it.Stock.model.bo.PlaqueStandard;
import ma.millergraphics.it.Stock.model.dao.PlaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "plaque")
public class PlaqueController {
    @Autowired
    PlaqueRepository<Plaque> plaqueRepository;

    private void completerPlaque(Plaque plaque){
        plaque.calculerDifference();
        if(plaque instanceof PlaqueStandard){
            ((PlaqueStandard) plaque).getTaille().calculerSurface();
        }
        else ((Chute)plaque).calculerSurface();
    }

    @GetMapping(path = "/")
    public List<Plaque> getAll(){
        List<Plaque> plaques=plaqueRepository.findAll();
        plaques.forEach(plaque -> {
            completerPlaque(plaque);
        });
        return plaques;
    }

    @GetMapping(path = "/{id}")
    public Plaque getOne(@PathVariable Long id){
        Plaque plaque=plaqueRepository.findById(id).get();
        completerPlaque(plaque);
        return plaque;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteOne(@PathVariable Long id,
                                          @RequestHeader(value = "Authorization", required=false) String credentials){
        plaqueRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
