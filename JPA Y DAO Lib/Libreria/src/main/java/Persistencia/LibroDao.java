package Persistencia;



import Entidades.Autor;
import Entidades.Libro;
import Servicios.LibroServicio;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class LibroDao {

    //creamos nuestro entitymanager CRUD
    private final EntityManager em = Persistence
            .createEntityManagerFactory("MiPersistence")
            .createEntityManager();

    public void Insertar(Libro libro) throws Exception{

        try {

            em.getTransaction().begin();
            em.persist(libro);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception("Error al cargar el libro");
        }
    }

    public List<Libro> ObtenerLibros() throws Exception{
        try {
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l", Libro.class).getResultList();
            return libros;
        }catch (Exception e){
            throw new Exception("Error al obtener libros");
        }
    }

    public Libro ObtenerPorIsbn(Long isbn) throws Exception{

        try {

            Libro libro = em.find(Libro.class, isbn);//busca por isbn
            return libro;
        }catch(Exception e){
            throw new Exception("Error al buscar libro por ISBN");
        }

    }

    public List<Libro> ObtenerPorTitulo(String titulo) throws Exception{

        try {
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :title",Libro.class)
                    .setParameter("title",titulo)
                    .getResultList();

            return libros;

        }catch(Exception e){
            throw new Exception("Error al buscar libros por Titulo");
        }

    }

    public List<Libro> ObtenerPorAutor(String autor) throws Exception{

        try {
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombreAutor LIKE :au",Libro.class)
                    .setParameter("au",autor)
                    .getResultList();
            return libros;
        }catch(Exception e) {
            throw new Exception("Error al buscar libros por Autor");
        }
    }

    public void Actualizar(Libro libro) throws Exception{

        try {

            em.getTransaction().begin();//abrimos transaccion con el begin
            em.merge(libro);//aloja los cambios para enviar a la BD
            em.getTransaction().commit();//cerrar envio de datos

        }catch (Exception e){
            em.getTransaction().rollback();//tira el error de lo que esta transmitiendo
            throw new Exception("Error al actualizar libro");
        }
    }

    public void Eliminar(Libro libro) throws Exception{

        try {

            em.getTransaction().begin();
            em.remove(libro);
            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar libro");
        }

    }

}
