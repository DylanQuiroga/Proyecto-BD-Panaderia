package insumos_disponibles;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class DBInsumos_dispo {

    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";

    String ids[] = {"Nombre del insumo", "Cantidad disponible", "Unidad metrica"};

    public DefaultTableModel cargarInsumos(DefaultTableModel tablaDF) throws SQLException {

        tablaDF.setColumnIdentifiers(ids);

        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT * FROM insumos_disponibles";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[3];
            fila[0] = resultSet.getString("nombre_insumo_inv");
            fila[1] = resultSet.getInt("cantidad_disponible");
            fila[2] = resultSet.getString("unidad_metrica");
            tablaDF.addRow(fila);
        }

        return tablaDF;

    }

    public static void generarComboBox(JComboBox<String> comboBox) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT nombre_receta FROM receta;";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            
            comboBox.removeAllItems();

            // Recorre los resultados y agregarlos al JComboBox
            comboBox.addItem("Mostrar todo");
            while (resultSet.next()) {
                String itemName = resultSet.getString("nombre_receta");
                comboBox.addItem(itemName);
            }

            
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public DefaultTableModel cargarInsumosPorReceta(DefaultTableModel tablaDF, String nombreReceta) throws SQLException {
        tablaDF.setColumnIdentifiers(ids);

        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT * FROM insumos_disponibles WHERE nombre_insumo_inv IN "
                + "(SELECT nombre_ingrediente FROM ingredientes WHERE nombre_receta = ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, nombreReceta);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[3];
            fila[0] = resultSet.getString("nombre_insumo_inv");
            fila[1] = resultSet.getInt("cantidad_disponible");
            fila[2] = resultSet.getString("unidad_metrica");
            tablaDF.addRow(fila);
        }

        return tablaDF;
    }

}


