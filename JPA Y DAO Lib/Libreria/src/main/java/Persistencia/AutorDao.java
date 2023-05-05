package Persistencia;

import Entidades.Autor;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class AutorDao {


    private final EntityManager em = Persistence
            .createEntityManagerFactory("MiPersistence")
            .createEntityManager();

    public void Insertar(Autor autor) throws Exception{

        try {

            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();

        }catch (Exception e){
            em.getTransaction().rollback();
            throw new Exception("Error al cargar autor");
        }
    }

    public List<Autor> ObtenerPorNombre(String nombre) throws Exception{

        try {

            return em.createQuery("SELECT a FROM Autor a WHERE a.nombreAutor LIKE :name",Autor.class)
                    .setParameter("name", nombre)
                    .getResultList();

        }catch(Exception e){
            throw new Exception("Error al buscar autor por el nombre");
        }
    }

    public List<Autor> ObtenerTodosAutoresRegistrados() throws Exception{

        try {

            return em.createQuery("SELECT a FROM Autor a",Autor.class).getResultList();

        }catch(Exception e){
            throw new Exception("Error al buscar los autores registrados");
        }

    }

    public Autor ObtenerPorId(Integer Id) throws Exception{
        try {

            Autor autor = em.find(Autor.class, Id);

            return autor;

        }catch (Exception e){
            throw new Exception("Error al buscar el autor por id");
        }
    }

    public void Actualizar(Autor autor) throws Exception{

        try {

            em.getTransaction().begin();//abrimos transaccion con el begin
            em.merge(autor);//aloja los cambios para enviar a la BD
            em.getTransaction().commit();//cerrar envio de datos

        }catch (Exception e){
            em.getTransaction().rollback();//tira el error de lo que esta transmitiendo
            throw new Exception("Error al actualizar autor");
        }
    }

    public void Eliminar(Autor autor) throws Exception{

        try {

            em.getTransaction().begin();
            em.remove(autor);
            em.getTransaction().commit();

        }catch(Exception e){
            em.getTransaction().rollback();
            throw new Exception("Error al eliminar autor");
        }

    }

}
