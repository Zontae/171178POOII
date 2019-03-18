
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
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
    private String nome;
    private String endereco;
    private String telefone;
    private int status;
    private double limite;
    
    @Transient
    private ArrayList pedidos;

    public Cliente(String nome, String endereco, String telefone, int status, double limite) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.status = status;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
    
    
    
}
