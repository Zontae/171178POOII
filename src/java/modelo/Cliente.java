
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table( name = "TBL_Cliente")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    
    @Column(length=50, nullable=false)
    private String nome;
    
    @Column(length=70, nullable=false)
    private String endereco;
    private String telefone;
    private Status status = Status.INATIVO;
    private double limite;
    
    @Transient
    private ArrayList pedidos;

    public Cliente(String nome, String endereco, String telefone, double limite) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.limite = limite;
    }

    public Cliente(){
        
    }
    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ArrayList getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.codigo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }
    
    
    
}
