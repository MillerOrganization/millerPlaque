package ma.millergraphics.it.stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table(name = "groupeArticle")
public class GroupeArticle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25)
    private String designation;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "groupeArticle",fetch = FetchType.EAGER)
    private Collection<Plaque> plaques=new HashSet<Plaque>();
     
}
