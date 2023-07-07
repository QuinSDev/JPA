package libreria.servicios;

import java.util.Scanner;
import libreria.persistencia.AuthorPersistence;

public class AuthorService {

    Scanner read = new Scanner(System.in);
    AuthorPersistence authorP = new AuthorPersistence();

    public void createAuthor() {
        
        String name = "";
        
        do {
            try {
                System.out.print("Enter the author's name: ");
                name = read.nextLine();

                if (name == null || name.isEmpty()) {
                    System.out.println("-".repeat(24));
                    throw new IllegalAccessException("You must enter the name!\n");
                }
                
                authorP.createPersistence(name);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (name.isEmpty());

    }

}
