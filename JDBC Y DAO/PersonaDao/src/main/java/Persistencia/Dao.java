package Persistencia;

import java.sql.*;
//dao = parte logica de mi conexion a la BD
public class Dao {

    protected Connection connection;
    protected Statement statement;
    protected ResultSet resultSet;

    private final String USER= "root";
    private final String PASSWORD= "root";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/jdbc?useSSL=false";

    protected void connectDatabase() throws Exception{
        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);//CONEXION BD

        }catch (ClassNotFoundException | SQLException e){
            throw new Exception("Error al conectarse");
        }
    }

    protected void disconnectDatabase() throws Exception{
        try {

            if (connection != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
        }catch (SQLException e){
            throw new Exception("Error al desconectarse");
        }
    }

    protected void queryDatabase(String sql) throws Exception{
        try {

            connectDatabase();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        }catch (SQLException e){
            throw new Exception("Error al consultar");
        }
    }

}
