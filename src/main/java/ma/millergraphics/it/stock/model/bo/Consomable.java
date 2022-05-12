package ma.millergraphics.it.stock.model.bo;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Consomable extends Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 25)
	private String designation;
}
