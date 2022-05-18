package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
public class ListPlaques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25,nullable = false,unique = true)
    private String designation;
    @Column(nullable = false,unique = true)
    private long numeroArticle;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToOne
    private GroupeArticle groupeArticle;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "listPlaques",fetch = FetchType.EAGER)
    private Collection<Plaque> plaques=new HashSet<>();
}
