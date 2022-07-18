package ma.millergraphics.it.Stock.model.bo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
public class Consomable extends Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "consomable",fetch = FetchType.LAZY,orphanRemoval = true)
	Collection<UtilisateurConsomable> utilisateurConsomables=new HashSet<UtilisateurConsomable>();
	@ManyToOne
	private ListConsomable listConsomable;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "consomable",fetch = FetchType.LAZY,orphanRemoval = true)
	private Collection<LigneCommande> ligneCommandes=new HashSet<>();
}
