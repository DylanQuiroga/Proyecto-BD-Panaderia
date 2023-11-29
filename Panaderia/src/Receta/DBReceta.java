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
    
    public DefaultTableModel cargarIngredientes(DefaultTableModel tablaDF) throws SQLException {
        try {
            tablaDF.setColumnIdentifiers(ingredientes);
            
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "select * from ingredientes";     
            PreparedStatement preparedStatement = connection.prepareStatement(consulta); 
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
    
}
