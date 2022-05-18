package ma.millergraphics.it.Stock.model.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Collection;
import java.util.HashSet;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = PlaqueStandard.class,name = "plaque standard"),
		@JsonSubTypes.Type(value = Chute.class,name = "chute")
})
@Data @NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Plaque extends Article{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@ManyToOne
	private ListPlaques listPlaques;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "plaque")
	Collection<UtilisateurPlaque> utilisateurPlaques=new HashSet<UtilisateurPlaque>();
    
    public Plaque(Long id,long quantite,long quantiteMoisPrecedent) {
    	super(quantite,quantiteMoisPrecedent);
    	this.id=id;
		utilisateurPlaques=new HashSet<UtilisateurPlaque>();
    }
}
