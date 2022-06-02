package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
public class Categorie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25)
    private String designation;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "categorie")
    private Collection<ListConsomable> listConsomables=new HashSet<>();

}
