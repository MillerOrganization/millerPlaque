package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
public class ListConsomable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50,nullable = false)
    private String designation;
    private long numeroArticle;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "listConsomable",fetch = FetchType.LAZY,orphanRemoval = true)
    private Collection<Consomable> consomables=new HashSet<>();
    @ManyToOne
    private Categorie categorie;
}
