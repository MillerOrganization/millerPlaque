package ma.millergraphics.it.Stock.model.bo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class PlaqueStandard extends Plaque {
	/*
	 * @Id private Long id;
	 */
	@ManyToOne
	private TaillePlaque taille;
	
	public PlaqueStandard(Long id,String designation,long numeroArticle,
    		GroupeArticle groupeArticle,long quantite,long quantiteMoisPrecedent,
    		TaillePlaque taillePlaque) {
		super(id,designation,numeroArticle,groupeArticle, quantite, quantiteMoisPrecedent);
		taille=taillePlaque;
	}
	
	
}
