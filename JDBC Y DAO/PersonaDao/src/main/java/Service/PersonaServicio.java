package Service;

import Entidad.Persona;
import Persistencia.PersonaDao;

import java.util.List;

public class PersonaServicio {

    private final PersonaDao personaDao;

    public PersonaServicio(){
        personaDao = new PersonaDao();//creo una nueva persona Dao
    }

    //hago un metodo que me imprima la lista
    public void imprimirPersonas() throws Exception{
        try {

            List<Persona> persons = personaDao.getPeople();//creo una lista de la entidad persona y le guardo las personas que obtuve de la consulta

            if (persons.isEmpty()){
                throw new Exception("No existen personas");
            }else{
                System.out.println("Lista de Personas");
                System.out.printf("%-10s%-15s%-15s%-20s\n", "ID", "NOMBRE", "APELLIDO", "EMAIL");//la "printf" es para formato y en este caso lo primero me da la cantidad de espacios entre columnas

                for (Persona person: persons) {
                    System.out.printf("%-10s%-15s%-15s%-20s\n", person.getPersonId(), person.getNombre(), person.getApellido(), person.getEmail());
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
}
