package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UtilisateurPlaque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false)
    private int quantite;
    @ManyToOne
    private Utilisateur utilisateur;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToOne
    private Plaque plaque;
}
