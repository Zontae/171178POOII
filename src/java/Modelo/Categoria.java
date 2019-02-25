
package modelo;


public class Categoria {
    
    private String descricao;

    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    public Categoria() {
    }

    

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }
}
