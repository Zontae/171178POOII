
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

    public ProdutoExterno(String nome, Categoria categoria, double preco, int moeda, double imposto,String destino) {
        super(nome, categoria, preco, moeda, imposto);
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
