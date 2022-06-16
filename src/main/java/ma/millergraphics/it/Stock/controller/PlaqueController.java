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
    @Autowired
    PlaqueRepository<Plaque> plaqueRepository;
    @Autowired
    TaillePlaqueRepository taillePlaqueRepository;
    @Autowired
    ListPlaquesRepository listPlaquesRepository;


    private void completerPlaque(Plaque plaque){
        plaque.calculerDifference();
        if(plaque instanceof PlaqueStandard){
            ((PlaqueStandard) plaque).getTaille().calculerSurface();
        }
        else ((Chute)plaque).calculerSurface();
    }

    @GetMapping(path = {"/",""})
    public List<Plaque> getAll(){
        /*List<Plaque> plaques=plaqueRepository.findAll();
        plaques.forEach(plaque -> {
            completerPlaque(plaque);
        });
        return plaques;*/
        return plaqueService.getAll();
    }

    @GetMapping(path = "/{id}")
    public Plaque getOne(@PathVariable Long id){
        /*Plaque plaque=plaqueRepository.findById(id).get();
        completerPlaque(plaque);
        return plaque;*/
        return plaqueService.getOne(id);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<Long> deleteOne(@PathVariable Long id,
                                          @RequestHeader(value = "Authorization", required=false) String credentials){
        /*plaqueRepository.deleteById(id);*/
        plaqueService.deleteOne(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(path = {"/",""})

    public @ResponseBody<T extends Plaque> ResponseEntity<Plaque> updateOne(@RequestBody
                                            T plaque){
        //Plaque p=plaqueRepository.findById(id).get();
        /*plaqueRepository.save((plaque))*/;
        plaqueService.updateOne(plaque);
        return new ResponseEntity(plaque, HttpStatus.OK);
    }

    @PostMapping(path = {"/",""})

    public @ResponseBody<T extends Plaque> ResponseEntity<Plaque> AddOne(@RequestBody
                                                                                    T plaque){
        //Plaque p=plaqueRepository.findById(id).get();
        /*plaqueRepository.save((plaque));*/
        plaqueService.AddOne(plaque);
        return new ResponseEntity(plaque, HttpStatus.CREATED);
    }
    @GetMapping(path = "/find")
    public List<Plaque> findByLongueurAndLargeur(@RequestParam(name = "longueur")String longueur,
                                                 @RequestParam(name = "largeur")String largeur){
        /*List<Plaque> chutes=plaqueRepository.findChutesByLongueurAndByLargeur(Long.parseLong(longueur),
                Long.parseLong(largeur));
        List<Plaque> plaquesStandard=plaqueRepository.findPlaqueStandardByLongueurAndByLargeur(Long.parseLong(longueur),
                Long.parseLong(largeur));
        Set<Plaque> setPlaques=new HashSet<Plaque>();
        setPlaques.addAll(chutes);
        setPlaques.addAll(plaquesStandard);
        List<Plaque> plaques=new ArrayList<>(setPlaques);
        plaques.forEach(plaque -> {
            completerPlaque(plaque);
        });
        return  plaques;*/
        return  plaqueService.findByLongueurAndLargeur(longueur,largeur);
    }

    @GetMapping(path = "/findPlaque")
    public Plaque findByTailleAndList(@RequestParam(name = "taille") String taille,
                                      @RequestParam(name = "listPlaques") String listPlaques){
        /*TaillePlaque t=taillePlaqueRepository.findById(Long.parseLong(taille)).get();
        ListPlaques lp=listPlaquesRepository.findById(Long.parseLong(listPlaques)).get();
        PlaqueStandard plaqueStandard=plaqueRepository.findByListPlaquesAndTaille(lp,t);
        return plaqueStandard;*/
        return plaqueService.findByTailleAndList(taille,listPlaques);
    }
    @GetMapping(path = "/findChute")
    public  Plaque findByChuteByLongueurAndLargeur(
            @RequestParam(name = "longueur") String longueur,
            @RequestParam(name = "largeur") String largeur,
            @RequestParam(name = "listPlaques") String listPlaques
    ){
        /*ListPlaques lp=listPlaquesRepository.findById(Long.parseLong(listPlaques)).get();
        Chute chute=plaqueRepository.findByListPlaquesAndLongueurAndLargeur(lp,
                Long.parseLong(longueur),
                Long.parseLong(largeur));
        return chute;*/
        return plaqueService.findByChuteByLongueurAndLargeur(longueur,largeur,listPlaques);
    }
}
