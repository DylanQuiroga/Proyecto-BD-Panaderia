package Venta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBVenta {

    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";

    String retorno[];
    int i = 0;

    public String[] cargarProductos() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM producto_local";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                i++;
            }

            retorno = new String[i];
            int i = 0;
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                retorno[i] = resultSet.getString("nombre_producto");
                i++;
            }

            return retorno;

        } catch (SQLException e) {
            return null;
        }

    }

    public int devolverCantidadMax(String Producto) {
        int retornar = 0;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM producto_local WHERE nombre_producto = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, Producto);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                retornar = resultSet.getInt("stock_producto");
            }
            
            return retornar;
            
        }catch(SQLException e){
            return (int) -1l;
        }
    }
    
    public int devolverPrecio(String Producto){
        int retornar = 0;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM producto_local WHERE nombre_producto = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, Producto);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                retornar = resultSet.getInt("precio_producto");
            }
            
            return retornar;
            
        }catch(SQLException e){
            return (int) -1l;
        }
    }

}
