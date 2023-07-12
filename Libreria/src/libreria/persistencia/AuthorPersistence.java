package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Author;

public class AuthorPersistence {

    private EntityManagerFactory emf;
    private EntityManager em;

    Author author = null;

    public AuthorPersistence() {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
        em = emf.createEntityManager();
    }

    public void AuthorPersistence() {
        emf = Persistence.createEntityManagerFactory("LibreriaPU");
        em = emf.createEntityManager();
    }

    public void createPersistence(String name) {

        AuthorPersistence();

        try {

            author = new Author();

            if (author == null) {
                throw new NullPointerException("You must indicate an author!");
            }

            author.setNombre(name);
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    public Author findAuthor(Integer id) {

        AuthorPersistence();

        try {

            author = em.find(Author.class, id);

            if (author == null) {
                System.out.println("-".repeat(50));
                throw new NullPointerException("The author ID is not valid!");
            }

            return author;

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void modifyAuthor(Integer id, String name) {

        AuthorPersistence();

        try {
            author = em.find(Author.class, id);

            author.setNombre(name);
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("\nError!" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    public void deleteAuthor(Integer id) {

        AuthorPersistence();

        try {
            em.getTransaction().begin();
            author = em.find(Author.class, id);
            author.setHigh(false);
            em.persist(author);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println("\nError!" + e.getMessage());
            em.getTransaction().rollback();
        } finally {
            closeEntityManager();
        }

    }

    public List<Author> authorSearch(String name) {

        AuthorPersistence();

        try {
            List<Author> authors = em.createQuery("SELECT a FROM Author a"
                    + " WHERE a.nombre LIKE :nombre")
                    .setParameter("nombre", name).getResultList();

            return authors;

        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } finally {
            closeEntityManager();
        }
        return null;

    }


    public void orderAuthor() {

        em.getTransaction().begin();
        List<Author> authors = em.createQuery("SELECT a "
                + "FROM Author a "
                + "ORDER BY a.id ASC", Author.class).getResultList();

        int newId = 1;
        for (Author author1 : authors) {
            if (em.contains(author1)) {
                author1.setId(newId);
                newId++;
                em.merge(author1);
            }

        }
        em.getTransaction().commit();

    }

    public void closeEntityManager() {

        em.close();
        emf.close();

    }

}
