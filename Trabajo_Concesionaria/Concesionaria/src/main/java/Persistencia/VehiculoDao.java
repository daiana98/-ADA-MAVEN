package Persistencia;

import Entidad.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class VehiculoDao extends Dao{
    public List<Vehiculo> getAutos() throws Exception{
        try {

            String sql = "SELECT * FROM registros;";

            queryDatabase(sql);

            List<Vehiculo> vehiculos = new ArrayList<>();
            Vehiculo vehiculo;

            //necesitamos un while para que recorra todos los registross
            while(resultSet.next()){
                vehiculo = new Vehiculo();

                vehiculo.setId(resultSet.getInt(1));//le digo que le paso un int y la posicion de donde saca el id en este caso la posicion 1
                vehiculo.setMarca(resultSet.getString(2));
                vehiculo.setModelo(resultSet.getString(3));
                vehiculo.setColor(resultSet.getString(4));
                vehiculo.setStock(resultSet.getInt(5));

                vehiculos.add(vehiculo);//agrego el vehiculo a la lista

            }

            return vehiculos;//retorno la lista de vehiculos

        }catch (Exception e){
            System.out.println(e.getMessage());//imprimo las excepciones de DAO
            throw new Exception("Error al obtener vehiculos");//genero una nueva excepcion si allo aqui
        }finally{
            disconnectDatabase();//me desconecto de la BD
        }
    }
}
