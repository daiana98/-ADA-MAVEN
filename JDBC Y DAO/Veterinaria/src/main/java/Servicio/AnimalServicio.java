package Servicio;

import Entidad.Animal;
import Persistencia.AnimalDao;

import java.util.List;

public class AnimalServicio {
    private final AnimalDao animalDao;

    public AnimalServicio() {
        animalDao = new AnimalDao();
    }

    public void imprimirLista() throws Exception{

        try {

            List<Animal> animals = animalDao.getAnimal();

            if (animals.isEmpty()) {
                throw new Exception("No existen Animales");
            }else{
                System.out.println("Lista de Animales");
                System.out.printf("%-15s%-15s%-20s\n", "NOMBRE", "AÑOS", "RAZA");
                for (Animal an:animals) {
                    System.out.printf("%-15s%-15s%-20s\n", an.getNombre(), an.getAños(), an.getRaza());
                }
            }

        }catch (Exception e){
            throw e;
        }
    }
}
