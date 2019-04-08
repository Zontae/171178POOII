
package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kevin
 */

@Entity
@Table(name="TBL_PEDIDO")
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Codigo", nullable = false)
    private int numero;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Data Pedido", nullable = false)
    private Date date;
    
    @OneToMany(cascade=CascadeType.PERSIST)
    private ArrayList<ItemPedido> itens;
    
    @ManyToOne
    @Column(name="Cliente", nullable = false)
    private Cliente cliente;
    
    
    public double totalPedido(){
        return 0;
    }
    
    public double totalImposto(){
        return 0;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", date=" + date + ", itens=" + itens + ", cliente=" + cliente + '}';
    }
    
    
    
}
