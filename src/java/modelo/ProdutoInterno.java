
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Imp")
public class ProdutoInterno extends Produto implements Serializable{
    
    @Column(name="Incentivo")
    private boolean incentivo;

    public ProdutoInterno(String nome, Categoria categoria, double preco, int moeda, double imposto,boolean incentivo) {
        super(nome, categoria, preco, moeda, imposto);
        this.incentivo = incentivo;
    }

    public ProdutoInterno() {
        
    }
    
    public boolean isIncentivo() {
        return incentivo;
    }

    public void setIncentivo(boolean incentivo) {
        this.incentivo = incentivo;
    }
    
    
    
}
