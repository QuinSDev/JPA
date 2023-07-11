package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Author;
import libreria.persistencia.AuthorPersistence;

public class AuthorService {

    Scanner read = new Scanner(System.in);
    AuthorPersistence authorP = new AuthorPersistence();
    Author author;

    public void createAuthor() {

        String name = "";

        do {
            try {
                System.out.print("\nEnter the author's name: ");
                name = read.nextLine();

                if (name == null || name.isEmpty()) {
                    System.out.println("-".repeat(24));
                    throw new IllegalAccessException("You must enter the name!\n");
                }

                authorP.createPersistence(name);

            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            }
        } while (name.isEmpty());

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

}
