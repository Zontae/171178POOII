
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "TBL_CLIENTE")
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    
    @Column(name="Nome", length=50)
    private String nome;
    
    @Column(name="Endereço", length=70)
    private String endereco;
    
    @Column(name="Telefone")
    private String telefone;
    
    @Column(name="Status")
    private Status status = Status.INATIVO;
    
    @Column(name="Limite")
    private double limite = 500;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JoinColumn(name = "Numero Pedido")
    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(String nome, String endereco, String telefone, Status status, double limite) {
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public void addPedido(Pedido pedido){
        this.pedidos.add(pedido);
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

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", status=" + status + ", limite=" + limite + '}';
    }
    
    
    
}
