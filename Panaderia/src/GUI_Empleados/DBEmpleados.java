package GUI_Empleados;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;

public class DBEmpleados {
    
    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";
    
    String ids [] = { "Rut", "Primer nombre", "Primer apellido", "Direccion", "Rol"};
    
    public DefaultTableModel cargarEmpleados(DefaultTableModel tablaDF) throws SQLException{
        
        tablaDF.setColumnIdentifiers(ids);
        
        Connection connection = DriverManager.getConnection(url,username,password);
        String consulta = "SELECT * FROM admin";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()){
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_admin");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = resultSet.getString("direccion");
            fila[4] = "Administrador/a";
            tablaDF.addRow(fila);
        }
        
        consulta = "SELECT * FROM cajero";
        preparedStatement = connection.prepareStatement(consulta);
        resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()){
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_cajero");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = resultSet.getString("direccion");
            fila[4] = "Cajero/a";
            tablaDF.addRow(fila);
        }
        
        consulta = "SELECT * FROM panadero";
        preparedStatement = connection.prepareStatement(consulta);
        resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()){
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_panadero");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = resultSet.getString("direccion");
            fila[4] = "Panadero/a";
            tablaDF.addRow(fila);
        }
        
        return tablaDF;
        
    }
    
    public boolean anadir(String rut, String nombre1, String nombre2, String apellido1, String apellido2, String contrasena, String direccion, String horario, int salario, String contrato){
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String consulta = "SELECT * FROM admin";
            
        }catch(SQLException e){
            return false;
        }
        return false;
    }
    
}
