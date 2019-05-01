
package modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import static javax.persistence.DiscriminatorType.STRING;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table( name = "TBL_Produtos")
@Inheritance(strategy=SINGLE_TABLE)
@DiscriminatorColumn(name="Tipo", discriminatorType=STRING, length=10)
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Codigo", nullable = false)
    private int codigo;
    
    @Column(length = 30, nullable = false)
    private String nome;
    
    @OneToOne(cascade = CascadeType.ALL)
    private Categoria categoria;
    
    @Column(name="Preço", nullable = false)
    private double preco;
    
    @Column(name="Moeda", nullable = false)
    private Moeda moeda = Moeda.REAL;
    
    @Column(name="Imposto", nullable = false)
    private double imposto;

    public Produto(String nome, Categoria categoria, double preco, int moeda, double imposto) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
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

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", categoria=" + categoria + ", preco=" + preco + ", moeda=" + moeda + ", imposto=" + imposto + '}';
    }

    
}
