package ma.millergraphics.it.stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Plaque extends Article{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(length = 25,nullable = false)
    private String designation;
    @Column(nullable = false)
    private long numeroArticle;
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @ManyToOne
    private GroupeArticle groupeArticle;
    
    public Plaque(Long id,String designation,long numeroArticle,
    		GroupeArticle groupeArticle,long quantite,long quantiteMoisPrecedent) {
    	super(quantite,quantiteMoisPrecedent);
    	this.id=id;
    	this.designation=designation;
    	this.numeroArticle=numeroArticle;
    	this.groupeArticle=groupeArticle;
    }
}
