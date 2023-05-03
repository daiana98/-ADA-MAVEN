package Persistencia;

import Entidad.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalDao extends Dao{

    public List<Animal> getAnimal() throws Exception{
        try {

            String sql = "SELECT * FROM informacion;";

            queryDatabase(sql);

            List<Animal> animals = new ArrayList<>();
            Animal animal;

            //necesitamos un while para que recorra todos los registross
            while(resultSet.next()){
                animal = new Animal();

                animal.setId(resultSet.getInt(1));//le digo que le paso un int y la posicion de donde saca el id en este caso la posicion 1
                animal.setNombre(resultSet.getString(2));//saca el nombre de la columna 2
                animal.setAños(resultSet.getInt(3));
                animal.setRaza(resultSet.getString(4));

                animals.add(animal);//agrego el animal a la lista

            }

            return animals;//retorno la lista de animales

        }catch (Exception e){
            System.out.println(e.getMessage());//imprimo las excepciones de DAO
            throw new Exception("Error al obtener animales");//genero una nueva excepcion si allo aqui
        }finally{
            disconnectDatabase();//me desconecto de la BD
        }
    }
}
