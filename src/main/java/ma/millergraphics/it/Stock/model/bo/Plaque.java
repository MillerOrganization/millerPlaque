package ma.millergraphics.it.Stock.model.bo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
