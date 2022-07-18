package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
@Data
public class Commande {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date=new Date();
    @Temporal(TemporalType.TIME)
    private Date time=new Date();
    @ManyToOne
    private Client client;
    @ManyToOne
    private Utilisateur commercial;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "commande",fetch = FetchType.LAZY,orphanRemoval = true)
    private Collection<LigneCommande> ligneCommandes=new HashSet<>();

}
