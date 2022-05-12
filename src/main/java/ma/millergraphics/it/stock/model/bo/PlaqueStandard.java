package ma.millergraphics.it.stock.model.bo;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class PlaqueStandard extends Plaque {
	/*
	 * @Id private Long id;
	 */
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@ManyToOne
	private TaillePlaque taille;
	
	public PlaqueStandard(Long id,String designation,long numeroArticle,
    		GroupeArticle groupeArticle,long quantite,long quantiteMoisPrecedent,
    		TaillePlaque taillePlaque) {
		super(id,designation,numeroArticle,groupeArticle, quantite, quantiteMoisPrecedent);
		taille=taillePlaque;
	}
	
	
}
