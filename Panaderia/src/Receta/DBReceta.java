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
    
    String ids[] = {"Nombre Receta", "Descripcion", "Ingredientes", "Unidad Metrica", "Cantidad"};
    public DefaultTableModel cargarRecetas(DefaultTableModel tablaDF) throws SQLException {
        try {
            tablaDF.setColumnIdentifiers(ids);
            
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "select receta.nombre_receta, receta.descripcion, "
                    + "ingredientes.nombre_ingrediente, ingredientes.unidad_metrica, "
                    + "ingredientes.cantidad from receta"
                    + ", ingredientes where receta.nombre_receta = ingredientes.nombre_receta;";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object[] fila = new Object[5];
                fila[0] = resultSet.getString("nombre_receta");
                fila[1] = resultSet.getString("descripcion");
                fila[2] = resultSet.getString("nombre_ingrediente");
                fila[3] = resultSet.getString("unidad_metrica");
                fila[4] = resultSet.getString("cantidad");
                tablaDF.addRow(fila);
            }

            return tablaDF;

        } catch (SQLException e) {
            return null;
        }

    }
    
}
