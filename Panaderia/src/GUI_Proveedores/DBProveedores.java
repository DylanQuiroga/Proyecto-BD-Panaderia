/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Proveedores;



import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;;

/**
 *
 * @author Ethan
 */
public class DBProveedores {
    
    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";
    
    public DefaultTableModel cargarProveedores() throws SQLException{
        
        DefaultTableModel tablaDF = new DefaultTableModel();
        tablaDF.addColumn("Proveedor");
        tablaDF.addColumn("Direccion");
        tablaDF.addColumn("Correo");
        tablaDF.addColumn("Telefono contacto");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT p1.nombre, direccion, correo, numero\n" +
                    "FROM proveedores p1\n" +
                    "INNER JOIN correo_prov ON p1.rut_proveedor = correo_prov.rut_proveedor\n" +
                    "INNER JOIN numero_prov ON p1.rut_proveedor = numero_prov.rut_proveedor;";

            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] fila = new Object[4];
                fila[0] = resultSet.getString("nombre");
                fila[1] = resultSet.getString("direccion");
                fila[2] = resultSet.getString("correo");
                fila[3] = resultSet.getString("numero");
                tablaDF.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return tablaDF;
    } 
    
    public DefaultTableModel cargarInsumos(String busqueda) throws SQLException{
        DefaultTableModel tablaDF = new DefaultTableModel();
        tablaDF.addColumn("Proveedor");
        tablaDF.addColumn("Insumo");
        tablaDF.addColumn("Cantidad");
        tablaDF.addColumn("Precio");
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT p1.nombre as nombre_proveedor, insumo.nombre, cantidad, unidad_metrica, precio\n" +
                    "FROM proveedores p1\n" +
                    "INNER JOIN insumo ON p1.rut_proveedor = insumo.rut_proveedor\n" +
                    "WHERE insumo.nombre LIKE ?;";

            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, "%" + busqueda + "%");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] fila = new Object[4];
                fila[0] = resultSet.getString("nombre_proveedor");
                fila[1] = resultSet.getString("nombre");
                
                String cantidad = resultSet.getString("cantidad");
                String unidadMetrica = resultSet.getString("unidad_metrica");
                
                fila[2] = cantidad + " " + unidadMetrica;
                fila[3] = resultSet.getString("precio");
       
                tablaDF.addRow(fila);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        return tablaDF;
        
    }
     
    
}
