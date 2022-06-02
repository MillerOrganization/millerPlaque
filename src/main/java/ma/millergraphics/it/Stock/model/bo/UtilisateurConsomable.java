package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UtilisateurConsomable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private int quantite;
    @ManyToOne
    private Utilisateur utilisateur;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToOne
    private Consomable consomable;

}
