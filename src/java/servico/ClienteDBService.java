/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Cliente;

/**
 *
 * @author
 */
public class ClienteDBService {
    
    private EntityManagerFactory emf;
    
    public ClienteDBService (){
        emf = Persistence.createEntityManagerFactory("POOIIDB");
    }

    public void salvarAtualizar(Cliente cli) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
            em.merge(cli);
       em.getTransaction().commit();
       em.close();    
    }
    
    public List<Cliente> getClientes()
    {
        EntityManager em = emf.createEntityManager();
        List <Cliente> clientes = em.createQuery("Select c From Cliente c").getResultList();
        em.close();
        return clientes;
    }
    
    public Cliente getClienteByCodigo(int codigo)
    {
            EntityManager em = emf.createEntityManager();
            Cliente c = em.find(Cliente.class, codigo);
            em.close();
            System.out.println("servico.ClienteDBService.getClienteByCodigo()" + c.getCodigo());
            return c;
    }
    
}
