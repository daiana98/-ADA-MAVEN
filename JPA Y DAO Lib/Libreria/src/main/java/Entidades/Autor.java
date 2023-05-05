package Entidades;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @Column(name = "autor_nombre", length = 100, nullable = false)
    private String nombreAutor;
    @Column(name = "autor_apellido", length = 100, nullable = false)
    private String apellidoAutor;

    //creamos la relacion con libro, un autor va a tener muchos libros
    // autor de libro, relacion uno a muchos bidireccional, mappedBy nos dice que la relacion esta en la tabla libro

    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(Integer id, String nombreAutor, String apellidoAutor, List<Libro> libros) {
        Id = id;
        this.nombreAutor = nombreAutor;
        this.apellidoAutor = apellidoAutor;
        this.libros = libros;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getApellidoAutor() {
        return apellidoAutor;
    }

    public void setApellidoAutor(String apellidoAutor) {
        this.apellidoAutor = apellidoAutor;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
