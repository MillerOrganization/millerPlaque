package ma.millergraphics.it.Stock.model.bo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class LigneCommande{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Commande commande;
    @ManyToOne
    private Consomable consomable;
    private long quantite;
}
