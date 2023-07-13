package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialPersistence;

public class EditorialService {
    
    Scanner read = new Scanner(System.in);
    EditorialPersistence editorialP = new EditorialPersistence();
    Editorial editorial;
    
    public Editorial createEditorial() {
        String name = "";
        
        do {
            editorial = new Editorial();
            try {
                System.out.print("Enter the editorial's name: ");
                name = read.nextLine();
                
                if (name.isEmpty()) {
                    System.out.println("-".repeat(50));
                    throw new NullPointerException("You mus indicate a "
                            + "editorial name!");
                }
                editorial.setNombre(name);
                editorialP.createEditorial(editorial);
                return editorial;
                
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            
        } while (name.isEmpty());
        
        return null;
        
    }
}
