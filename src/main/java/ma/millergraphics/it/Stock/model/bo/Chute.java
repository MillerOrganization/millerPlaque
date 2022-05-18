package ma.millergraphics.it.Stock.model.bo;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Chute  extends Plaque{
	/*
	 * @Id private Long id;
	 */
	private long longueur;
	private long largeur;
	@Transient
	private long surface;
	
	public Chute(Long id,long quantite,long quantiteMoisPrecedent,
	long longueur,long largeur) {
		super(id,quantite, quantiteMoisPrecedent);
		this.longueur=longueur;
		this.largeur=largeur;
		calculerSurface();
	}
	
	public void calculerSurface() {
		surface=longueur*largeur;
	}
}
