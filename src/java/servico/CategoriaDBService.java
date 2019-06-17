
package servico;

import modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class CategoriaDBService {
    
    private EntityManagerFactory emf;

    public CategoriaDBService() {
        emf = emf = Persistence.createEntityManagerFactory("POOIIDB");
    }
    
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
        System.out.println(categorias.toString());
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

    public Categoria getCategoriaByCodigo(String value) {
        EntityManager em = emf.createEntityManager();
        Categoria c = em.find(Categoria.class, value);
        em.close();
        return c;
    }
}
