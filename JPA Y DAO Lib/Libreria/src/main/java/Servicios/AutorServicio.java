package Servicios;

import Entidades.Autor;
import Persistencia.AutorDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutorServicio {
    Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    private AutorDao autorDao = new AutorDao();


    public void crearAutor() throws Exception{

        Autor autor = new Autor();

        try {

            System.out.println("Ingrese el nombre del autor: ");
            String nombre = entrada.next();

            System.out.println("Ingrese el apellido del autor: ");
            String apellido = entrada.next();

            autor.setNombreAutor(nombre);
            autor.setApellidoAutor(apellido);

            if (nombre == null || nombre.trim().isEmpty() || apellido == null || apellido.trim().isEmpty()){//si es nulo que me tire la excepcion || si hay espacios que los obvie y me valide si esta vacio
                throw new Exception("Debe contener un nombre/apellido");
            }else{
                System.out.println("Se guardo exitosamente");
            }

            //guardar el autor ya me lo esta enviando a la BD
            autorDao.Insertar(autor);

        }catch (Exception e){
            throw e;//recupere las excepciones
        }
    }

    public void MostrarAutorPorNombre() throws Exception{

        try {
            //le preguntamos al usuario el nombre que busca
            System.out.println("Ingrese el nombre del autor que desea buscar: ");
            String nombre = entrada.next();

            //genero la lista a mostrar
            List<Autor> autores = autorDao.ObtenerPorNombre(nombre);

            if (autores.isEmpty()){
                throw new Exception("La lista no contiene registros");
            }else{
                System.out.println("\n" + "Resultado: ");
                System.out.printf("%-10s%-20s\n","ID", "NOMBRE");

                for (Autor autor:autores) {
                    System.out.printf("%-10s%-20s\n",autor.getId(), autor.getNombreAutor());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("No se encontro un autor con ese nombre");
        }

    }

    public void MostrarAutores() throws Exception{

        try {
            //genero la lista a mostrar
            List<Autor> autores = autorDao.ObtenerTodosAutoresRegistrados();

            if (autores.isEmpty()){
                throw new Exception("La lista no contiene registros");
            }else{
                System.out.println("\n" + "Lista de Autores: ");
                System.out.printf("%-10s%-20s%-20s\n","ID", "NOMBRE","APELLIDO");

                for (Autor autor:autores) {
                    System.out.printf("%-10s%-20s%-20s\n",autor.getId(), autor.getNombreAutor(), autor.getApellidoAutor());
                }
            }
        }catch(Exception e){
            throw e;
        }

    }

    public void MostrarAutorPorId() throws Exception{
        try {
            System.out.println("Ingrese el ID del autor que desea buscar");
            Integer Id = entrada.nextInt();

            Autor autor = autorDao.ObtenerPorId(Id);

            if (autor == null){
                throw new Exception("No existe el registro");
            }else{
                System.out.println("\n" + "Resultado: ");
                System.out.printf("%-15s%-40s\n","ID","NOMBRE","APELLIDO");

                System.out.printf("%-15s%-40s\n", autor.getId(), autor.getNombreAutor(), autor.getApellidoAutor());

            }
        }catch(Exception e){
            throw new Exception("No se encontro un autor con ese ID");
        }
    }

    public void EditarAutor() throws Exception{
        try {

            System.out.println("Ingrese el ID que desea actualizar: ");
            Integer Id = entrada.nextInt();

            Autor autor = autorDao.ObtenerPorId(Id);//obtenemos el obj autor

            System.out.println("\n" + "Ingrese el nuevo nombre del autor: ");
            String nombre = entrada.next();

            System.out.println("\n" + "Ingrese el nuevo apellido del autor: ");
            String apellido = entrada.next();

            autor.setNombreAutor(nombre);
            autor.setApellidoAutor(apellido);

            System.out.println("Se edito correctamente");

            autorDao.Actualizar(autor);

        }catch(Exception e){
            throw new Exception("No se encontro un autor con ese Id");
        }

    }

    public void EliminarAutor() throws Exception{

        try {
            System.out.println("\n" + "Ingrese el Id del autor que desea eliminar");
            Integer Id = entrada.nextInt();

            Autor autor = autorDao.ObtenerPorId(Id);

            autorDao.Eliminar(autor);

            System.out.println("Se elimino exitosamente");
        }catch(Exception e){
            throw new Exception("No se encontro un autor con ese ID");
        }

    }

}
