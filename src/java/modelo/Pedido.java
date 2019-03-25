
package modelo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author kevin
 */

//@Entity
public class Pedido{
    
 //   @Id
 //   @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
   // @Transient
    private Date date;
    private ArrayList<ItemPedido> itens;
  //  @Transient
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
