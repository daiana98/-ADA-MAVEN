package Persistencia;

import Entidad.Persona;

import java.util.ArrayList;
import java.util.List;

//logica de acceso de datos de negocio
public class PersonaDao extends Dao{

    public List<Persona> getPeople() throws Exception{
        try {

            String sql = "SELECT * FROM registros;";

            queryDatabase(sql);

            List<Persona> persons = new ArrayList<>();
            Persona person;

            //necesitamos un while para que recorra todos los registross
            while(resultSet.next()){
                person = new Persona();

                person.setPersonId(resultSet.getInt(1));//le digo que le paso un int y la posicion de donde saca el id en este caso la posicion 1
                person.setNombre(resultSet.getString(2));//saca el nombre de la columna 2
                person.setApellido(resultSet.getString(3));
                person.setEmail(resultSet.getString(4));

                persons.add(person);//agrego la persona a la lista

            }

            return persons;//retorno la lista de personas

        }catch (Exception e){
            System.out.println(e.getMessage());//imprimo las excepciones de DAO
            throw new Exception("Error al obtener personas");//genero una nueva excepcion si allo aqui
        }finally{
            disconnectDatabase();//me desconecto de la BD
        }
    }
}
