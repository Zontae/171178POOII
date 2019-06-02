
package servico;

import modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;



public class CategoriaDBService {
    
    private EntityManagerFactory emf;
    
    public void salvarAtualizar(Categoria cat) {
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
            em.merge(cat);
       em.getTransaction().commit();
       em.close();    
    }
    
    public List<Categoria> getCategorias()
    {
        EntityManager em = emf.createEntityManager();
        List <Categoria> categorias = em.createQuery("Select c From Categoria c").getResultList();
        em.close();
        return categorias;
    }
    
        public Categoria getCategoriaByCodigo(int codigo)
    {
            EntityManager em = emf.createEntityManager();
            Categoria cat = em.find(Categoria.class, codigo);
            em.close();
            System.out.println("servico.CategoriaDBService.getCategoriaByCodigo()" + cat.getCodigo());
            return cat;
    }
}
