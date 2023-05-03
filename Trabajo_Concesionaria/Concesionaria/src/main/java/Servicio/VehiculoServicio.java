package Servicio;

import Entidad.Vehiculo;
import Persistencia.VehiculoDao;

import java.util.List;

public class VehiculoServicio {
    private final VehiculoDao vehiculoDao;

    public VehiculoServicio(){
        vehiculoDao = new VehiculoDao();//creo un nuevo Vehiculo Dao
    }

    //hago un metodo que me imprima la lista
    public void imprimirVehiculos() throws Exception{
        try {

            List<Vehiculo> vehiculos = vehiculoDao.getAutos();//creo una lista de la entidad Vehiculos y le guardo LOS VEHICULOS que obtuve de la consulta

            if (vehiculos.isEmpty()){
                throw new Exception("No existen vehiculos");
            }else{
                System.out.println("Lista de Vehiculos");
                System.out.printf("%-10s%-15s%-15s%-20s\n", "MARCA", "MODELO", "COLOR", "STOCK");//la "printf" es para formato y en este caso lo primero me da la cantidad de espacios entre columnas

                for (Vehiculo vehiculo: vehiculos) {
                    System.out.printf("%-10s%-15s%-15s%-20s\n", vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getColor(), vehiculo.getStock());
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
}
