package ma.millergraphics.it.stock.model.bo;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@MappedSuperclass
public abstract class Article implements Serializable{
    private long quantite;
    private long quantiteMoisPrecedent;
    @Transient
    private long difference;
    
    public void calculerDifference() {
    	difference=quantite-quantiteMoisPrecedent;
    }
    
    public Article(long quantite,long quantiteMoisPrecedent) {
    	this.quantite=quantite;
    	this.quantiteMoisPrecedent=quantiteMoisPrecedent;
    	calculerDifference();
    }
}
