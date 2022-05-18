package ma.millergraphics.it.Stock.model.bo;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;


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
		super(id,quantite, quantiteMoisPrecedent);
		taille=taillePlaque;
	}
	
	
}
