
package managedbean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelo.Pedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.Produto;
import servico.ClienteService;
import servico.PedidoDBService;
import servico.ProdutoService;
import servico.ServiceGeneric;

@ManagedBean
@SessionScoped
public class PedidoDBMB {
   private ServiceGeneric<Pedido> genericService = new ServiceGeneric<Pedido>();
   private ArrayList<Produto> pedido;
   private Pedido ped = new Pedido();
   private Cliente cli = new Cliente();
   private Produto prod = new Produto();
   private Pedido selectdPed = new Pedido();
   private double totalPedido = 0;

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }
   
    public ArrayList<Produto> getPedido() {
        return pedido;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

    public Pedido getSelectdPed() {
        return selectdPed;
    }

    public void setSelectdPed(Pedido selectdPed) {
        this.selectdPed = selectdPed;
    }
   
   public void salvar(){
       genericService.salvarAtualizar(ped);
       ped = new Pedido();
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
    
    public void addProduto(Produto prod){
        pedido.add(prod);
        this.prod = new Produto();
    }
    
    public List<Cliente> getClientes(){
        ClienteService gen =  new ClienteService();
        return gen.getClientes();
    }
    
    public List<Produto> getProduto(){
        ProdutoService gen = new ProdutoService();
        return gen.getProdutos();
    }
    
    public void finalizarCompra(Cliente cli){
        this.ped = new Pedido();
	Date date = new Date();
        ped.setDate(date);
        ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();
        itens = convertProdutos(pedido);
        ped.setItens(itens);
        ped.setTotal(totalPedido);
        ped.setCliente(cli);
        genericService.salvarAtualizar(ped);
        this.ped = new Pedido();        
    }
    
    private ArrayList<ItemPedido> convertProdutos(ArrayList<Produto> produtos){
        ArrayList<ItemPedido> list = new ArrayList<ItemPedido>();
        for(Produto prod : produtos){
            ItemPedido item = new ItemPedido();
            item.setProduto(prod);
            item.setQuantidade(1);
            item.setTotal(prod.getPreco());
            list.add(item);
            totalPedido += prod.getPreco();
        }
        return list;
    }
}
