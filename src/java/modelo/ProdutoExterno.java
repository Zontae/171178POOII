
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Exp")
public class ProdutoExterno extends Produto implements Serializable{
    
    @Column(name="Destino")
    private String destino;

    public ProdutoExterno(Produto produto,String destino) {
        super(produto.getNome(), produto.getCategoria(), produto.getPreco(), produto.getMoeda(), produto.getImposto());
        this.destino = destino;
    }
    
    public String getDestino() {
        return destino;
    }

    public ProdutoExterno() {
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
