package org.example;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MiUnidadDePersistencia");//le paso el nombre de la persistencia

        //Obtener una instancia de Entity Manager desde el EntityManagerFactory
        EntityManager entityManager = emf.createEntityManager();

        //Iniciar transaccion
        entityManager.getTransaction().begin();

        //Crear una instancia de Usuario y establecer sus atributos
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Perez");
        usuario.setCorreoElectronico("juan.perez@gmail.com");

        //Pesistir el usuario en la base de datos - Enviarlo
        entityManager.persist(usuario);

        //ConFirmar la transaccion
        entityManager.getTransaction().commit();

        //Cerrar el entityManager
        entityManager.close();
    }
}