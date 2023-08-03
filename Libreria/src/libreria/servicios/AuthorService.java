package libreria.servicios;

import java.util.List;
import java.util.Scanner;
import libreria.entidades.Author;
import libreria.persistencia.AuthorPersistence;

public class AuthorService {

    Scanner read = new Scanner(System.in);
    AuthorPersistence authorP = new AuthorPersistence();
    Author author;
    List<Author> authors = null;

    public Author createAuthor() {

        String name = "";

        do {
            try {
                System.out.print("Enter the author's name: ");
                name = read.nextLine();

                if (name == null || name.isEmpty()) {
                    System.out.println("-".repeat(50));
                    throw new IllegalAccessException("You must enter the name!\n");
                }
                
                if (authorDuplicate(name) != null) {
                    return author = authorDuplicate(name);
                } else {
                    return author = authorP.createPersistence(name);
                }
                
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        } while (name.isEmpty());
        return null;

    }

    public void modifyAuthor() {

        String name = "";

        do {
            try {
                System.out.print("\nEnter the author id: ");
                String ide = read.nextLine();
                Integer id = Integer.parseInt(ide);

                author = authorP.findAuthor(id);

                if (author != null) {
                    do {
                        try {
                            System.out.print("Enter the author's name: ");
                            name = read.nextLine();

                            if (name == null || name.isEmpty()) {
                                System.out.println("-".repeat(50));
                                throw new IllegalArgumentException("You must "
                                        + "indicate a name!\n");
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                    } while (name.isEmpty());

                    authorP.modifyAuthor(id, name);
                }

            } catch (NumberFormatException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid ID!");
            }

        } while (author == null);

    }

    public void deleteAuthor() {

        do {
            try {
                System.out.print("\nEnter the author id: ");
                String ide = read.nextLine();
                Integer id = Integer.parseInt(ide);

                author = authorP.findAuthor(id);

                if (author != null) {
                    authorP.deleteAuthor(id);
                }

            } catch (NumberFormatException e) {
                System.out.println("-".repeat(50));
                System.out.println("Enter a valid ID!");
            }

        } while (author == null);

    }
    
    public Author authorDuplicate(String name) {
        
        try {
            authors = authorP.authorSearch();
            
            for (Author author1 : authors) {
                if (author1.getNombre().equalsIgnoreCase(name)) {
                    return author1;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
        
    }

    public void authorSearch() {

        String name = "";
        
        do {
            try {
                System.out.print("\nEnter the author name: ");
                name = read.nextLine();

                if (name == null || name.isEmpty()) {
                    System.out.println("-".repeat(50));
                    throw new IllegalArgumentException("You must indicate a name!\n");
                }

                authors = authorP.authorSearch();

                if (authors.isEmpty() || authors == null) {
                    System.out.println("-".repeat(50));
                    throw new IllegalArgumentException("The author with the "
                            + "specified name does not exist!");
                }
                
                System.out.println("-".repeat(50));
                for(Author author1 : authors) {
                    if (author1.getNombre().contains(name)) {
                        System.out.println("Name: " + author1.getNombre());
                    }
                    
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        } while (name.isEmpty() || authors.isEmpty());

    }

}
