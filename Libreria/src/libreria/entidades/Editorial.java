package libreria.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Editorial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Boolean high = true;

    public Editorial() {
    }

    public Editorial(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHigh() {
        return high;
    }

    public void setHigh(Boolean high) {
        this.high = high;
    }
    
    
}
