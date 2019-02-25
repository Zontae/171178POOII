
package servico;


import modelo.Categoria;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;
import modelo.ProdutoExportacao;
import java.util.ArrayList;

public class Dados {
    private static ArrayList <Cliente> LISTA_CLIENTES;
    private static ArrayList <Produto> LISTA_PRODUTOS;
    private static ArrayList <Pedido> LISTA_PEDIDOS;
    private static ArrayList <Categoria> LISTA_CATEGORIAS;

    public static void init() {
        
        LISTA_CLIENTES = new ArrayList();
        LISTA_PRODUTOS = new ArrayList();
        LISTA_PEDIDOS = new ArrayList();
        LISTA_CATEGORIAS = new ArrayList();

        
        LISTA_CLIENTES.add(new Cliente(1, "Zontae", "Rua Inverno", "34111137", 1, 10));
        LISTA_CLIENTES.add(new Cliente(1, "JamiScript", "Rua Verão", "8957417", 2, 0.10));
        LISTA_CLIENTES.add(new Cliente(1, "Gustov", "Rua Primavera", "95103570", 3, 15000));
        LISTA_CLIENTES.add(new Cliente(1, "Vinimybad", "Rua Outono", "77111992", 1, 1000));
        LISTA_CLIENTES.add(new Cliente(1, "Quévinho", "Rua Primavera", "156592956", 2, 180.10));
        
        
        
        
    }

    public static ArrayList<Pedido> getPedidos() {
        if(LISTA_PEDIDOS == null){
            init();
        }
        return LISTA_PEDIDOS;
    }
    
    
    public static ArrayList<Cliente> getClientes() {
        if(LISTA_CLIENTES == null){        
            init();
        }
        return LISTA_CLIENTES;
    }

    public static ArrayList<Produto> getProdutos() {
        if(LISTA_PRODUTOS == null){
            init();
        }
        return LISTA_PRODUTOS;
    }
    
    public static ArrayList<Categoria> getCategorias() {
        if(LISTA_CATEGORIAS == null){
            init();
        }
        return LISTA_CATEGORIAS;
    }
    

}
