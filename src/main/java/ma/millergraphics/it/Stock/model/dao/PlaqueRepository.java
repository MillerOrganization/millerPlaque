package ma.millergraphics.it.Stock.model.dao;

import ma.millergraphics.it.Stock.model.bo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface PlaqueRepository<T extends Plaque> extends JpaRepository<T, Long>{
    /*List<Plaque> findByDesignationContains(String kw);*/
    @Query("select c from Chute  as c where (c.longueur>=:longueur and c.largeur>=:largeur) OR"+
    "(c.longueur>=:largeur and c.largeur>=:longueur)")
    List<Plaque> findChutesByLongueurAndByLargeur(@Param("longueur") long longueur,@Param("largeur")long largeur);
    @Query("from PlaqueStandard as p  where "+
    "(p.taille.longueur>=:longueur and p.taille.largeur>=:largeur) OR" +
            " (p.taille.longueur>=:largeur and p.taille.largeur>=:longueur)")
    List<Plaque> findPlaqueStandardByLongueurAndByLargeur(@Param("longueur") long longueur,
                                                          @Param("largeur")long largeur);

    PlaqueStandard findByListPlaquesAndTaille(ListPlaques listPlaques,
                                              TaillePlaque taille);
    Chute findByListPlaquesAndLongueurAndLargeur(ListPlaques listPlaques,
                                       long longueur,long largeur);
}
