
package modelo;


import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kevin
 */

public class Pedido {
    private int numero;
    private Date date;
    private ArrayList<ItemPedido> itens;
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

    public void setNumero(int numero) {
        this.numero = numero;
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
