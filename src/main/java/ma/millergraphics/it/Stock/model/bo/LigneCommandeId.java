package ma.millergraphics.it.Stock.model.bo;

import lombok.AllArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
public class LigneCommandeId implements Serializable {
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Consomable consomable;
}
