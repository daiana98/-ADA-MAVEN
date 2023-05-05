package Servicios;

import Entidades.Autor;
import Entidades.Libro;
import Persistencia.LibroDao;

import java.util.List;
import java.util.Scanner;

public class LibroServicio {

    Scanner entrada = new Scanner(System.in).useDelimiter("\n");

    private LibroDao libroDao = new LibroDao();

    public void CrearLibro() throws Exception{
        Libro libro = new Libro();
        Autor autor = new Autor();//por la relacion que hay con libro

        try {
            System.out.println("\n" + "Registros de Libros");

            //ISBN
            System.out.println("\n" + "Ingrese el ISBN del libro:");
            Long isbn = entrada.nextLong();

            libro.setIsbn(isbn);

            if (isbn == null || isbn.toString().trim().isEmpty()){
                throw new Exception("El isbn es obligatorio");
            }
            //Titulo
            System.out.println("\n" + "Ingrese el titulo: ");
            String titulo = entrada.next();

            libro.setTitulo(titulo);

            if (titulo == null || titulo.trim().isEmpty()){
                throw new Exception("El titulo es obligatorio");
            }

            //Anio
            System.out.println("\n" + "Ingrese el año: ");
            Integer anio = entrada.nextInt();

            libro.setAnio(anio);

            if (anio == null || anio.toString().trim().isEmpty()){
                throw new Exception("El año es obligatorio");
            }

            //Ejemplares
            System.out.println("\n" + "Ingrese los ejemplares: ");
            Integer ejemplares = entrada.nextInt();

            libro.setEjemplares(ejemplares);

            if (ejemplares == null || ejemplares.toString().trim().isEmpty()){
                throw new Exception("Los ejemplares son obligatorios");
            }

            //Autor
            System.out.println("\n" + "Ingrese el ID del Autor de este libro: ");
            Integer Id = entrada.nextInt();

            autor.setId(Id);//le paso el id al autor que ya tiene que estar registrado el autor
            libro.setAutor(autor);//NOSERA CON GET, bueno al parecer seteo el id

            if (Id == null || Id.toString().trim().isEmpty()){
                throw new Exception("El Autor es obligatorio y debe existir el registro");
            }

            System.out.println("¡Registro exitoso!");
            libroDao.Insertar(libro);
        }catch(Exception e){
            throw new Exception("Error al cargar un libro");
        }
    }

    public void MostrarLibroPorIsbn() throws Exception{

        try {

            System.out.println("\n" + "Ingrese el ISBN del libro que desea buscar: ");
            Long isbn = entrada.nextLong();

            Libro libro = libroDao.ObtenerPorIsbn(isbn);

            if (libro == null || isbn == null){
                System.out.println("El libro no existe");
            }else{
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", "ISBN", "Titulo", "Autor", "Año", "Ejemplares");
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", libro.getIsbn(), libro.getTitulo(), libro.getAutor().getNombreAutor(), libro.getAnio(), libro.getEjemplares());
            }
        }catch(Exception e){
            throw new Exception("Error al mostrar libro por ISBN");

        }
    }

    public void MostrarLibros() throws Exception{

        try {
            //genero la lista a mostrar
            List<Libro> libros = libroDao.ObtenerLibros();

            if (libros.isEmpty()){
                throw new Exception("La lista no contiene registros");
            }else{
                System.out.println("\n" + "Lista de Libros: ");
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", "ISBN", "Titulo", "Autor", "Año", "Ejemplares");

                for (Libro lib: libros) {
                    System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", lib.getIsbn(), lib.getTitulo(), lib.getAutor().getNombreAutor(), lib.getAnio(), lib.getEjemplares());
                }
            }
        }catch(Exception e){
            throw new Exception("error al mostrar los libros");
        }

    }


    public void MostrarLibroPorTitulo() throws Exception{

        try {

            System.out.println("\n" + "Ingrese el titulo del libro que desea buscar");
            String titulo = entrada.next();

            List<Libro> libros = libroDao.ObtenerPorTitulo(titulo);

            if (libros.isEmpty()){
                throw new Exception("No hay libros con ese titulo");
            }else{
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", "ISBN", "Titulo", "Autor", "Año", "Ejemplares");

                for (Libro lib: libros) {
                    System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", lib.getIsbn(), lib.getTitulo(), lib.getAutor().getNombreAutor(), lib.getAnio(), lib.getEjemplares());
                }
            }

        }catch(Exception e){
            throw new Exception("Error al mostrar libros por Titulo");
        }
    }

    public void MostrarLibroPorAutor() throws Exception{

        try {

            System.out.println("\n" + "Ingrese el Autor del libro que desea buscar");
            String autor = entrada.next();


            List<Libro> libros = libroDao.ObtenerPorAutor(autor);

            if (libros.isEmpty() || autor == null){
                throw new Exception("No hay libros con ese Autor");
            }else{
                System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", "ISBN", "Titulo", "Autor", "Año", "Ejemplares");

                for (Libro lib: libros) {
                    System.out.printf("%-20s%-25s%-20s%-20s%-20s\n", lib.getIsbn(), lib.getTitulo(), lib.getAutor().getNombreAutor(), lib.getAnio(), lib.getEjemplares());
                }
            }

        }catch(Exception e){
            throw new Exception("Error al mostrar libros por Autor");
        }

    }

    public void EditarLibro() throws Exception{
        try {

            System.out.println("Ingrese el isbn del libro que desea editar: ");
            Long isbn = entrada.nextLong();

            Libro libro = libroDao.ObtenerPorIsbn(isbn);

            System.out.println("\n" + "Ingrese el titulo del libro:");
            String titulo = entrada.next();

            libro.setTitulo(titulo);

            System.out.println("\n" + "Ingrese el año nuevamente del libro:");
            Integer anio = entrada.nextInt();

            libro.setAnio(anio);

            System.out.println("\n" + "Ingrese la cantidad de ejemplares nuevamente del libro:");
            Integer ejemplares = entrada.nextInt();

            libro.setEjemplares(ejemplares);

            System.out.println("\n" + "¡Se edito exitosamente!");

            libroDao.Actualizar(libro);

        }catch(Exception e){
            throw new Exception("No se encontro un libro con ese ISBN ");
        }

    }

    public void EliminarLibro() throws Exception{

        try {
            System.out.println("\n" + "Ingrese el ISBN del libro que desea eliminar");
            Long isbn = entrada.nextLong();

            Libro libro = libroDao.ObtenerPorIsbn(isbn);

            libroDao.Eliminar(libro);

            System.out.println("Se elimino exitosamente");
        }catch(Exception e){
            throw new Exception("No se encontro un libro con ese ISBN");
        }

    }

}
