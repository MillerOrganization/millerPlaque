package ma.millergraphics.it.Stock.model.bo;

import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @OneToMany(mappedBy = "groupeArticle",fetch = FetchType.EAGER)
    private Collection<Plaque> plaques=new HashSet<Plaque>();
     
}
