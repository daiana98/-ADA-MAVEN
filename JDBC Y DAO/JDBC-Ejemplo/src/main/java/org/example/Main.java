package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String USER = "root";
        String PASSWORD = "root";
        String url = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";

        try {
            //conecion
            Connection connection = DriverManager.getConnection(url, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM registros");

            while (resultSet.next()){
                System.out.println(resultSet.getString("nombre") + " | " + resultSet.getString("apellido"));
            }

            connection.close();
            statement.close();
            resultSet.close();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}