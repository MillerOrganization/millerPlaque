package ma.millergraphics.it.Stock.model.service;

import ma.millergraphics.it.Stock.model.bo.Plaque;


import java.util.List;

public interface PlaqueService {
    void completerPlaque(Plaque plaque);
    List<Plaque> getAll();
    Plaque getOne(Long id);
    void deleteOne(Long id);
    Plaque updateOne(Plaque plaque);
    Plaque AddOne(Plaque plaque);
    Plaque findByTailleAndList(String taille,String listPlaques);
    Plaque findByChuteByLongueurAndLargeur(String longueur,String largeur, String listPlaques);
    List<Plaque> findByLongueurAndLargeur(String longueur,String largeur);
}
