
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import modelo.Categoria;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.Moeda;
import modelo.Pedido;
import modelo.Produto;
import modelo.ProdutoInterno;
import modelo.Status;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
public class Main {
    
        public static void main(String [] args){
            
            Cliente c1 = new Cliente();
            Cliente c2 = new Cliente();
            Pedido p1 = new Pedido();
            Pedido p2 = new Pedido();
            ProdutoInterno pro1 = new ProdutoInterno();
            ProdutoInterno pro2 = new ProdutoInterno();
            Categoria cat1 = new Categoria();
            Categoria cat2 = new Categoria();
            ItemPedido ped1 = new ItemPedido();
            ItemPedido ped2 = new ItemPedido();
            
//--------------------------------------------------------------------
            try{
                cat1.setCategoria("Prazer");
                cat1.setDescricao("");
                cat2.setCategoria("Eletronico");
                cat2.setDescricao("");
                System.out.println("Etapa 1 - sucesso");
            }
            catch(EntityNotFoundException e){
                System.out.println("Etapa 1 - falho");
            }
            
//--------------------------------------------------------------------
            try{
                pro1.setNome("Livro");
                pro1.setCategoria(cat1);
                pro1.setPreco(35);
                pro1.setMoeda(Moeda.REAL);
                pro1.setImposto(0.25);
                pro1.setIncentivo(true);
                pro2.setNome("Bateria 5V");
                pro2.setCategoria(cat2);
                pro2.setPreco(22);
                pro2.setMoeda(Moeda.REAL);
                pro2.setImposto(0.15);
                pro2.setIncentivo(false);
                System.out.println("Etapa 2 - sucesso");
            }
            catch(EntityNotFoundException e){
                System.out.println("Etapa 2 - falho");
            }
            
//--------------------------------------------------------------------
            try{
                ped1.setProduto(pro1);
                ped1.setQuantidade(1);
                ped2.setProduto(pro2);
                ped2.setQuantidade(1);
                System.out.println("Etapa 3 - sucesso");
            }
            catch(EntityNotFoundException e){
                System.out.println("Etapa 3 - falho");
            }
            
//--------------------------------------------------------------------
            try{
                Date dat = new Date(2019, 04, 22);
                p1.setDate(dat);
                p1.setCliente(c1);
                p1.addItem(ped1);
                p2.setDate(dat);
                p2.setCliente(c2);
                p2.addItem(ped2);
                System.out.println("Etapa 4 - sucesso");
            }
            catch(EntityNotFoundException e){
                System.out.println("Etapa 4 - falho");
            }  
            
//--------------------------------------------------------------------
            try{
                c1.setNome("Alberto");
                c1.setEndereco("Aldair Var'res 33");
                c1.setTelefone("62916832");
                c1.setStatus(Status.FREEMIUM);
                c1.setLimite(650);
                c1.addPedido(p1);
                c2.setNome("Anna");
                c2.setEndereco("Alander Walter 67");
                c2.setTelefone("12943763");
                c2.setStatus(Status.PREMIUM);
                c2.setLimite(700);
                c2.addPedido(p2);
                System.out.println("Etapa 5 - sucesso");
            }
            catch(EntityNotFoundException e){
                System.out.println("Etapa 5 - falho");
            } 
            
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("POOIIDB");
            EntityManager em = factory.createEntityManager();
            
            try{
                em.merge(c1);
                em.merge(c2);
                em.merge(p1);
                em.merge(p2);
                em.merge(ped1);
                em.merge(ped2);
                em.merge(pro1);
                em.merge(pro2);
                em.merge(cat1);
                em.merge(cat2);
                System.out.println("Deu!");
            }
            catch(EntityNotFoundException e){
                System.out.println("Não deu!");
            }
            
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();
            factory.close();
    }
        
}
