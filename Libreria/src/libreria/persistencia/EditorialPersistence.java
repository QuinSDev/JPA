package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

public class EditorialPersistence {
    
    private EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("LibreriaPU");
    private EntityManager em = emf.createEntityManager();
    
    public void conectEdtirial() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }
    
    public void disconectEditorial() {
        if (em.isOpen()) {
            em.close();
        }
    }
    
    public void createEditorial(Editorial editorial) {
        conectEdtirial();
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
        disconectEditorial();
    }
    
}
