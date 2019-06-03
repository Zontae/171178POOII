
package managedbean;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;
import servico.PedidoDBService;

@ManagedBean
@SessionScoped
public class PedidoDBMB {
   private PedidoDBService pedidodbservice = new PedidoDBService();
   private ArrayList<Produto> pedido;
   private Pedido ped = new Pedido();
   
   public void salvar(){
       pedidodbservice.salvarAtualizar(ped);
       ped = new Pedido();
   }

    public List<Pedido> getPedidos() {
        return pedidodbservice.getPedidos();
    }

    public Pedido getPed() {
        return ped;
    }

    public void setPed(Pedido ped) {
        this.ped = ped;
    }
    
    public void showMessage() {
        String summary = "Pedido Finalizado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
}
