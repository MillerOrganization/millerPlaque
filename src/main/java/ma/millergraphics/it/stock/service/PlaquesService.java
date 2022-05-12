package ma.millergraphics.it.stock.service;

import ma.millergraphics.it.stock.model.bo.Plaque;
import ma.millergraphics.it.stock.model.dao.PlaqueRepository;

import java.util.List;

public interface PlaquesService {
    List<Plaque> getAllPlaques();

    Plaque getOnePlaque(Long id);

    void deletePlaque(Long id);
}
