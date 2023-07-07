package libreria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import libreria.entidades.Author;
import libreria.entidades.Book;
import libreria.entidades.Editorial;

public class Libreria {

    public static void main(String[] args) {
        
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Aquí puedes agregar la lógica para crear las tablas
            // Por ejemplo, puedes persistir una instancia de cada entidad
            // que represente una tabla en la base de datos
            em.persist(new Book());
            em.persist(new Author());
            em.persist(new Editorial());
            // ...

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
        
    }
    
}
