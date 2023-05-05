package Servicios;

import java.util.Scanner;

public class MenuServicios {
    Scanner entrada = new Scanner(System.in);

    AutorServicio autorServicio = new AutorServicio();

    LibroServicio libroServicio = new LibroServicio();

    public void Menu() throws Exception{

        try {

            System.out.println("\n" + "----------Menu----------\n"
             + "1) Registrar un Autor.\n"
             + "2) Buscar Autor por Nombre. \n"
             + "3) Lista de autores registrados. \n"
             + "4) Buscar Autor por ID o codigo registro. \n"
             + "5) Editar Autores registrados. \n"
             + "6) Eliminar Autores registrados. \n"
             + "7) Registrar un Libro. \n"
             + "8) Buscar un Libro por ISBN. \n"
             + "9) Lista de Libros registrados. \n"
             + "10) Buscar Libros por Titulo. \n"
             + "11) Buscar Libros por Autor. \n"
             + "12) Editar Libro. \n"
             + "13) Eliminar Libros registrados. \n"
             + "14) Salir.");

            System.out.println("Seleccione una opcion: ");
            String respuesta = entrada.next();

            OpcionSeleccionada(respuesta);

        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new Exception("Debe contener una opcion valida");
        }

    }

    public void OpcionSeleccionada(String  respuesta) throws Exception{
        try {

            switch (respuesta){

                case "1":
                    autorServicio.crearAutor();
                    Menu();

                break;

                case "2":
                    autorServicio.MostrarAutorPorNombre();
                    Menu();
                break;

                case "3":
                    autorServicio.MostrarAutores();
                    Menu();
                    break;

                case "4":
                    autorServicio.MostrarAutorPorId();
                    Menu();
                    break;

                case "5":
                    autorServicio.EditarAutor();
                    Menu();
                    break;

                case "6":
                    autorServicio.EliminarAutor();
                    Menu();
                    break;

                case "7":
                    libroServicio.CrearLibro();
                    Menu();
                    break;

                case "8":
                    libroServicio.MostrarLibroPorIsbn();
                    Menu();
                    break;

                case "9":
                    libroServicio.MostrarLibros();
                    Menu();
                    break;

                case "10":
                    libroServicio.MostrarLibroPorTitulo();
                    Menu();
                    break;

                case "11":
                    libroServicio.MostrarLibroPorAutor();
                    Menu();
                    break;

                case "12":
                    libroServicio.EditarLibro();
                    Menu();
                    break;

                case "13":
                    libroServicio.EliminarLibro();
                    Menu();
                    break;

                case "14":
                    System.out.println("Consulta finalizada");
                    break;

                default:
                    System.out.println("Ingrese una opcion valida");
                    Menu();
            }

        }catch (Exception e){
            throw e;//tira toda las escepciones que se hicieron
        }
    }
}
