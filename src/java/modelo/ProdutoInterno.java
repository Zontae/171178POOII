
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

    public ProdutoInterno(Produto produto,boolean incentivo) {
        super(produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getMoeda(), produto.getMoeda());
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
