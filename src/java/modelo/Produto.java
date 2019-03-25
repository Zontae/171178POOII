
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

//@Entity
//@Table( name = "TBL_Produtos")
public class Produto{
    
   // @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    private String nome;
   // @Transient
    private Categoria categoria;
    private double preco;
    private int moeda;
    private double imposto;

    public Produto(String nome, Categoria categoria, double preco, int moeda, double imposto) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.moeda = moeda;
        this.imposto = imposto;
    }
    
    public Produto(){}
    
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getMoeda() {
        return moeda;
    }

    public void setMoeda(int moeda) {
        this.moeda = moeda;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    
}
