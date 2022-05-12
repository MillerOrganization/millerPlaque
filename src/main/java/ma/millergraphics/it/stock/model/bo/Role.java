package ma.millergraphics.it.stock.model.bo;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25,unique = true)
	private String designation;
	@ManyToMany(fetch = FetchType.EAGER,mappedBy = "roles")
	private Collection<Utilisateur> utilisateurs=new HashSet<Utilisateur>();
}
