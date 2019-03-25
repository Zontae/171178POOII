
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Categoria{
    
    private int codigo;
    private String descricao;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
