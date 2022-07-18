package ma.millergraphics.it.Stock.controller;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.*;
import ma.millergraphics.it.Stock.model.dao.ListPlaquesRepository;
import ma.millergraphics.it.Stock.model.dao.PlaqueRepository;
import ma.millergraphics.it.Stock.model.dao.TaillePlaqueRepository;
import ma.millergraphics.it.Stock.model.service.PlaqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(path = "plaque")
@AllArgsConstructor
public class PlaqueController {
    private PlaqueService plaqueService;
    private void completerPlaque(Plaque plaque){
        plaque.calculerDifference();
        if(plaque instanceof PlaqueStandard){
            ((PlaqueStandard) plaque).getTaille().calculerSurface();
        }
        else ((Chute)plaque).calculerSurface();
    }
    @GetMapping(path = {"/",""})
    public List<Plaque> getAll(){
        return plaqueService.getAll();
    }
    @GetMapping(path = "/{id}")
    public Plaque getOne(@PathVariable Long id){
        return plaqueService.getOne(id);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteOne(@PathVariable Long id,
                                          @RequestHeader(value = "Authorization", required=false) String credentials){
        plaqueService.deleteOne(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PutMapping(path = {"/",""})
    public @ResponseBody<T extends Plaque> ResponseEntity<Plaque> updateOne(@RequestBody
                                            T plaque){
        plaqueService.updateOne(plaque);
        return new ResponseEntity(plaque, HttpStatus.OK);
    }
    @PostMapping(path = {"/",""})
    public @ResponseBody<T extends Plaque> ResponseEntity<Plaque> AddOne(@RequestBody
                                                                                    T plaque){
        plaqueService.AddOne(plaque);
        return new ResponseEntity(plaque, HttpStatus.CREATED);
    }
    @GetMapping(path = "/find")
    public List<Plaque> findByLongueurAndLargeur(@RequestParam(name = "longueur")String longueur,
                                                 @RequestParam(name = "largeur")String largeur){
        return  plaqueService.findByLongueurAndLargeur(longueur,largeur);
    }
    @GetMapping(path = "/findPlaque")
    public Plaque findByTailleAndList(@RequestParam(name = "taille") String taille,
                                      @RequestParam(name = "listPlaques") String listPlaques){
        return plaqueService.findByTailleAndList(taille,listPlaques);
    }
    @GetMapping(path = "/findChute")
    public  Plaque findByChuteByLongueurAndLargeur(
            @RequestParam(name = "longueur") String longueur,
            @RequestParam(name = "largeur") String largeur,
            @RequestParam(name = "listPlaques") String listPlaques
    ){
        return plaqueService.findByChuteByLongueurAndLargeur(longueur,largeur,listPlaques);
    }
}
