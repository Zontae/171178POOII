
package servico;

import modelo.Pedido;
import java.util.ArrayList;


public class PedidoService {
    private ArrayList <Pedido> listPedidos = Dados.getPedidos();
    
    public void salvar(Pedido p){
        listPedidos.add(p);
    }

    public ArrayList<Pedido> getListPedidos() {
        return listPedidos;
    }

    public void setListPedidos(ArrayList<Pedido> listPedidos) {
        this.listPedidos = listPedidos;
    }
    
    public void remove(Pedido p){
        listPedidos.remove(p);
    }
}
