package ma.millergraphics.it.stock.service;

import ma.millergraphics.it.stock.model.bo.Chute;
import ma.millergraphics.it.stock.model.bo.Plaque;
import ma.millergraphics.it.stock.model.bo.PlaqueStandard;
import ma.millergraphics.it.stock.model.dao.PlaqueRepository;

import java.util.List;

public class PlaqueServiceImp implements PlaquesService{

    private final PlaqueRepository<Plaque> plaqueRepository;

    public PlaqueServiceImp(PlaqueRepository<Plaque> plaqueRepository) {
        this.plaqueRepository = plaqueRepository;
    }

    private void completerPlaque(Plaque plaque){
        plaque.calculerDifference();
        if(plaque instanceof PlaqueStandard){
            ((PlaqueStandard) plaque).getTaille().calculerSurface();
        }
        else ((Chute)plaque).calculerSurface();
    }


    @Override
    public List<Plaque> getAllPlaques() {
        List<Plaque> plaques=plaqueRepository.findAll();
        plaques.forEach(plaque -> {
            completerPlaque(plaque);
        });
        return plaques;
    }

    @Override
    public Plaque getOnePlaque(Long id) {
        Plaque plaque=plaqueRepository.findById(id).get();
        completerPlaque(plaque);
        return plaque;
    }

    @Override
    public void deletePlaque(Long id) {
        plaqueRepository.deleteById(id);
    }
}
