package ma.millergraphics.it.Stock.model.bo;

import java.util.*;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Entity
@Table(name="taillePlaque")
@Data
public class TaillePlaque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private String designation;
	private long longueur;
	private long largeur;
	@Transient
	private long surface;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "taille", fetch = FetchType.EAGER)
	private Collection<PlaqueStandard> plaqueStandards=new HashSet<PlaqueStandard>();
	
	public void calculerSurface() {
		this.surface=this.largeur*this.longueur;
	}
}
