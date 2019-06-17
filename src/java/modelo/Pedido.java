
package modelo;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kevin
 */

@Entity
@Table( name = "TBL_PEDIDO")
public class Pedido implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="Codigo", nullable = false)
    private int numero;
    
    @Temporal(TemporalType.DATE)
    @Column(name="DataPedido", nullable = false)
    private Date date;
    
    @OneToMany
    @JoinColumn(name = "IdPedido")
    private List<ItemPedido> itens = new ArrayList<ItemPedido>();
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idcliente")
    private Cliente cliente;
    
    @Column(name="Total", nullable = false)
    private double total;

    public Pedido(Date date, ArrayList<ItemPedido> itens, Cliente cliente, double total) {
        this.date = date;
        this.itens = itens;
        this.cliente = cliente;
        this.total = total;
    }

    public Pedido() {
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
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

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }
    
    public void addItem(ItemPedido itemPedido){
        this.itens.add(itemPedido);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", date=" + date + ", cliente=" + cliente + '}';
    }

    
    
    
    
}
