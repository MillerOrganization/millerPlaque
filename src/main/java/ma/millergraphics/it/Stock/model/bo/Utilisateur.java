package ma.millergraphics.it.Stock.model.bo;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.millergraphics.it.Stock.hash.BCryptPasswordDeserializer;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private String nom;
	@Column(length = 25)
	private String prenom;
	@Column(length = 100,unique = true)
	private String mail;
	@Column(length = 25,unique = true)
	private String username;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonDeserialize(using = BCryptPasswordDeserializer.class )
	private String password;
	@Column(length = 15)
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles=new HashSet<Role>();
	@OneToMany(mappedBy = "utilisateur")
	private Collection<UtilisateurPlaque> utilisateurPlaques=new HashSet<UtilisateurPlaque>();
	
	public Utilisateur(Long id,String nom,String prenom,String mail,String password,
			String username,String phone,Date dateNaissance) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;
		this.password=password;
		this.username=username;
		this.phone=phone;
		this.dateNaissance=dateNaissance;
		roles=new HashSet<Role>();
		utilisateurPlaques=new HashSet<UtilisateurPlaque>();
	}

}
