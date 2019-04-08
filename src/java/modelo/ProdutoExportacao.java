
package modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Exp")
public class ProdutoExportacao extends Produto implements Serializable{
    
    @Column(name="Destino", nullable=false)
    private String destino;

    public ProdutoExportacao(String nome, Categoria categoria, double preco, int moeda, double imposto,String destino) {
        super(nome, categoria, preco, moeda, imposto);
        this.destino = destino;
    }
    
    public String getDestino() {
        return destino;
    }

    public ProdutoExportacao() {
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    
}
