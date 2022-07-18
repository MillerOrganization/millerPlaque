package ma.millergraphics.it.Stock.model.service;

import lombok.AllArgsConstructor;
import ma.millergraphics.it.Stock.model.bo.*;
import ma.millergraphics.it.Stock.model.dao.ListPlaquesRepository;
import ma.millergraphics.it.Stock.model.dao.PlaqueRepository;
import ma.millergraphics.it.Stock.model.dao.TaillePlaqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class PlaqueServiceImpl implements PlaqueService{

    private PlaqueRepository<Plaque> plaqueRepository;

    private TaillePlaqueRepository taillePlaqueRepository;

    private ListPlaquesRepository listPlaquesRepository;
    @Override
    public void completerPlaque(Plaque plaque) {
        plaque.calculerDifference();
        if(plaque instanceof PlaqueStandard){
            ((PlaqueStandard) plaque).getTaille().calculerSurface();
        }
        else ((Chute)plaque).calculerSurface();
    }

    @Override
    public List<Plaque> getAll() {
        List<Plaque> plaques=plaqueRepository.findAll();
        plaques.forEach(plaque -> {
            completerPlaque(plaque);
        });
        return plaques;
    }

    @Override
    public Plaque getOne(Long id) {
        Plaque plaque=plaqueRepository.findById(id).get();
        completerPlaque(plaque);
        return plaque;
    }

    @Override
    public void deleteOne(Long id) {
        plaqueRepository.deleteById(id);
    }

    @Override
    public Plaque updateOne(Plaque plaque) {
        return plaqueRepository.save((plaque));
    }

    @Override
    public Plaque AddOne(Plaque plaque) {
        return plaqueRepository.save((plaque));
    }

    @Override
    public Plaque findByTailleAndList(String taille, String listPlaques) {
        TaillePlaque t=taillePlaqueRepository.findById(Long.parseLong(taille)).get();
        ListPlaques lp=listPlaquesRepository.findById(Long.parseLong(listPlaques)).get();
        PlaqueStandard plaqueStandard=plaqueRepository.findByListPlaquesAndTaille(lp,t);
        return plaqueStandard;
    }

    @Override
    public Plaque findByChuteByLongueurAndLargeur(String longueur, String largeur, String listPlaques) {
        ListPlaques lp=listPlaquesRepository.findById(Long.parseLong(listPlaques)).get();
        Chute chute=plaqueRepository.findByListPlaquesAndLongueurAndLargeur(lp,
                Long.parseLong(longueur),
                Long.parseLong(largeur));
        return chute;
    }

    @Override
    public List<Plaque> findByLongueurAndLargeur(String longueur, String largeur) {
        List<Plaque> chutes=plaqueRepository.findChutesByLongueurAndByLargeur(Long.parseLong(longueur),
                Long.parseLong(largeur));
        List<Plaque> plaquesStandard=plaqueRepository.findPlaqueStandardByLongueurAndByLargeur(Long.parseLong(longueur),
                Long.parseLong(largeur));
        Collection<Plaque> setPlaques=new ArrayList<>();
        setPlaques.addAll(chutes);
        setPlaques.addAll(plaquesStandard);
        List<Plaque> plaques=new ArrayList<>(setPlaques);
        plaques.forEach(plaque -> {
            completerPlaque(plaque);
            System.out.println(plaque.getListPlaques().getDesignation());
        });
        return  plaques;
    }
}
