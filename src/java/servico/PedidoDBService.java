
package servico;

import modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import modelo.Cliente;
import modelo.Pedido;


public class PedidoDBService {
    private EntityManagerFactory emf;
    
    public void salvarAtualizar(Pedido ped) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
            em.merge(ped);
       em.getTransaction().commit();
       em.close();    
    }

    public List<Pedido> getPedidos()
    {
        EntityManager em = emf.createEntityManager();
        List <Pedido> pedidos = em.createQuery("Select p From Pedido p").getResultList();
        em.close();
        return pedidos;
    }
    
        public Pedido getPedidoByCodigo(int codigo)
    {
            EntityManager em = emf.createEntityManager();
            Pedido ped = em.find(Pedido.class, codigo);
            em.close();
            //System.out.println("servico.PedidoDBService.getPedidoByCodigo()" + cat.getCodigo());
            return ped;
    }


}
