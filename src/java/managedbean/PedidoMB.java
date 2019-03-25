
package managedbean;

import modelo.Pedido;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import servico.PedidoService;

@ManagedBean
@SessionScoped
public class PedidoMB {
   private PedidoService pedidoService = new PedidoService();
   private Pedido ped = new Pedido();
   private Pedido selectedPedido;
   
   public void salvar(){
       pedidoService.salvar(ped);
       ped = new Pedido();
   }

    public ArrayList<Pedido> getPedidos() {
        return pedidoService.getListPedidos();
    }

    public Pedido getPed() {
        return ped;
    }

    public void setPed(Pedido ped) {
        this.ped = ped;
    }

    public Pedido getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(Pedido selectedPedido) {
        this.selectedPedido = selectedPedido;
    }
   
    public void deletePdd(){
        this.pedidoService.remove(selectedPedido);
        selectedPedido = null;
    }
    
    public void showMessage() {
        String summary = "Pedido Finalizado";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
}
