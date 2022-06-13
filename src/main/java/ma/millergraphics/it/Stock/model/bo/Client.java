package ma.millergraphics.it.Stock.model.bo;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false,unique = true)
    private String nom;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    Collection<Commande> commandes=new HashSet<>();

}
