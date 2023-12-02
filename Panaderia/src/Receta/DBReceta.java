package Receta;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rebv1
 */
public class DBReceta {

    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";

    String recetas[] = {"Nombre Receta", "Descripcion"};
    String ingredientes[] = {"Nombre Ingrediente", "Unidad Metrica", "Cantidad"};

    public DefaultTableModel cargarRecetas(DefaultTableModel tablaDF) throws SQLException {
        try {
            tablaDF.setColumnIdentifiers(recetas);
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "select * from receta";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object[] fila = new Object[2];
                fila[0] = resultSet.getString("nombre_receta");
                fila[1] = resultSet.getString("descripcion");
                tablaDF.addRow(fila);
            }

            return tablaDF;

        } catch (SQLException e) {
            return null;
        }

    }

    public DefaultTableModel cargarIngredientes(DefaultTableModel tablaDF, String seleccionado) throws SQLException {
        try {
            tablaDF.setColumnIdentifiers(ingredientes);
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM ingredientes WHERE nombre_receta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, seleccionado);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultSet.getString("nombre_ingrediente");
                fila[1] = resultSet.getString("unidad_metrica");
                fila[2] = resultSet.getString("cantidad");
                tablaDF.addRow(fila);
            }

            return tablaDF;

        } catch (SQLException e) {
            return null;
        }

    }

    public boolean anadirReceta(String nombrereceta, String descripcion, ArrayList<String> ingredientes, ArrayList<String> unidadmetrica, ArrayList<Integer> cantidad) {
        try {
            
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "INSERT INTO receta (nombre_receta, descripcion) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, nombrereceta);
            preparedStatement.setString(2, descripcion);
            preparedStatement.executeUpdate();

            consulta = "INSERT INTO ingredientes (nombre_receta, nombre_ingrediente, unidad_metrica, cantidad) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(consulta);
            for (int i = 0; ingredientes.size() > i; i++) {
                preparedStatement.setString(1, nombrereceta);
                preparedStatement.setString(2, ingredientes.get(i));
                preparedStatement.setString(3, unidadmetrica.get(i));
                preparedStatement.setInt(4, cantidad.get(i));
                preparedStatement.executeUpdate();
            }
            return true;

        } catch (SQLException e) {
            
            System.out.println(e);
            return false;
            
        }

    }
    
    public boolean eliminarReceta(String seleccionado){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "DELETE FROM ingredientes WHERE nombre_receta = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, seleccionado);
            preparedStatement.executeUpdate();
            
            
            consulta = "DELETE FROM receta WHERE nombre_receta = ?";
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, seleccionado);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            
            System.out.println(e);
            return false;
            
        }
    }

}
