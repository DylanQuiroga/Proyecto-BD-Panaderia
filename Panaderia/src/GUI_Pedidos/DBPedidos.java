/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI_Pedidos;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;;

/**
 *
 * @author Ethan
 */
public class DBPedidos {
    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";
    
    public DefaultTableModel cargarPedidos() throws SQLException{
        
        DefaultTableModel tablaDF = new DefaultTableModel();
        tablaDF.addColumn("ID");
        tablaDF.addColumn("Nombre");
        tablaDF.addColumn("Cantiad");
        tablaDF.addColumn("Precio");
        tablaDF.addColumn("Fecha");
        tablaDF.addColumn("Proveedor");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT id_pedido, nombre_insumo, cantidad, unidad_metrica, precio_total, dia_pedido, mes_pedido, anio_pedido, nombre\n" +
                    "FROM pedidos p\n" +
                    "INNER JOIN proveedores ON p.rut_proveedor = proveedores.rut_proveedor;";

            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Object[] fila = new Object[6];
                fila[0] = resultSet.getString("id_pedido");
                fila[1] = resultSet.getString("nombre_insumo");
                
                // PARA SELECCIONAR CANTIDAD + UNIDAD METRICA
                String cantidad = resultSet.getString("cantidad");
                String unidadMetrica = resultSet.getString("unidad_metrica");
                fila[2] = cantidad + " " + unidadMetrica;
                
                fila[3] = "$ " + resultSet.getString("precio_total");
                
                // PARA SELECCIONAR DIA MES Y AÑO
                String dia = resultSet.getString("dia_pedido");
                String mes = resultSet.getString("mes_pedido");
                String anio = resultSet.getString("anio_pedido");
                fila[4] = dia + "/" + mes + "/" + anio;
                
                
                fila[5] = resultSet.getString("nombre");
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
    
    
    public DefaultTableModel cargarFiltros(String proveedor_buscado, String pedido_buscado, String dia, String mes, String anio) throws SQLException{
        
        DefaultTableModel tablaDF = new DefaultTableModel();
        tablaDF.addColumn("ID");
        tablaDF.addColumn("Nombre");
        tablaDF.addColumn("Cantiad");
        tablaDF.addColumn("Precio");
        tablaDF.addColumn("Fecha");
        tablaDF.addColumn("Proveedor");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT id_pedido, nombre_insumo, cantidad, unidad_metrica, precio_total, dia_pedido, mes_pedido, anio_pedido, nombre\n" +
                    "FROM pedidos p INNER JOIN proveedores ON p.rut_proveedor = proveedores.rut_proveedor WHERE 1=1";

            List<String> condiciones = new ArrayList<>();
            
            if(!proveedor_buscado.isEmpty()){
                condiciones.add("nombre LIKE '%" + proveedor_buscado + "%'");
            }
            if(!pedido_buscado.isEmpty()){
                try{
                    int id = Integer.parseInt(pedido_buscado);
                    condiciones.add("id_pedido = " + id);
                    System.out.println("ID");
                }
                catch(NumberFormatException e){
                    condiciones.add("nombre_insumo LIKE '%" + pedido_buscado + "%'");
                    System.out.println("STRING");
                }
            }
            if(!dia.isEmpty() && !mes.isEmpty() && !anio.isEmpty()){
                condiciones.add("dia_pedido= '" + dia + "' AND mes_pedido= '" + mes + "' AND anio_pedido= '" + anio + "'");         
            }
            
            consulta += " AND " + String.join(" AND ", condiciones) + ";";
            
            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
                 
            while (resultSet.next()) {
                Object[] fila = new Object[6];
                fila[0] = resultSet.getString("id_pedido");
                fila[1] = resultSet.getString("nombre_insumo");
                
                // PARA SELECCIONAR CANTIDAD + UNIDAD METRICA
                String cantidad = resultSet.getString("cantidad");
                String unidadMetrica = resultSet.getString("unidad_metrica");
                fila[2] = cantidad + " " + unidadMetrica;
                
                fila[3] = "$ " + resultSet.getString("precio_total");
                
                fila[4] = resultSet.getString("dia_pedido") + "/" + resultSet.getString("mes_pedido") + "/" + resultSet.getString("anio_pedido");
                
                
                fila[5] = resultSet.getString("nombre");
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
    
    public DefaultTableModel cargarGastosMensuales() throws SQLException{
        DefaultTableModel tablaDF = new DefaultTableModel();
        tablaDF.addColumn("Gastos Anuales");
        tablaDF.addColumn("Gastos Mensuales");
        tablaDF.addColumn("Gastos totales");
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT anio_pedido, mes_pedido, SUM(precio_total) as total FROM pedidos GROUP BY anio_pedido, mes_pedido ORDER BY anio_pedido, mes_pedido;";
            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
                 
            while (resultSet.next()) {
                Object[] fila = new Object[3];
                fila[0] = resultSet.getString("anio_pedido");
                fila[1] = resultSet.getString("mes_pedido");
                fila[2] = "$" + resultSet.getString("total");
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
    
    public DefaultTableModel cargarGastosAnuales() throws SQLException{
        DefaultTableModel tablaDF = new DefaultTableModel();
        tablaDF.addColumn("Gastos Anuales");
        tablaDF.addColumn("Gastos totales");
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT anio_pedido, SUM(precio_total) as total FROM pedidos GROUP BY anio_pedido ORDER BY anio_pedido;";
            preparedStatement = connection.prepareStatement(consulta);
            resultSet = preparedStatement.executeQuery();
                 
            while (resultSet.next()) {
                Object[] fila = new Object[2];
                fila[0] = resultSet.getString("anio_pedido");
                fila[1] = "$" + resultSet.getString("total");
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
    
    public boolean anadir(int id, String pedido, String cantidad, String unidad_metrica, int precio, String dia, String mes, String anio, String rut_proveedor, String rutIngresado){
        try {            
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM proveedores WHERE rut_proveedor= '" + rut_proveedor + "';";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            
            if (resultSet.next()) {
                consulta = "INSERT INTO pedidos (id_pedido, nombre_insumo, cantidad, precio_total, unidad_metrica, dia_pedido, mes_pedido, anio_pedido, rut_proveedor)"
                        + "VALUES(" +id+ ", '"+pedido+"',"+cantidad+","+precio+",'"+unidad_metrica+"',"+dia+","+mes+","+anio+", '"+rut_proveedor+"');";
    
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.executeUpdate();

                return true;

            } 
            else{
                JOptionPane.showMessageDialog(null, "PROVEEDOR NO EXISTE","ALERTA", JOptionPane.WARNING_MESSAGE);               
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        
    }
    public int devolverID(){
        try{
            int id=0;
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT MAX(id_pedido) AS maximo FROM pedidos";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                id = resultSet.getInt("maximo");
            }

            id++;
            return id;
        }
        catch (SQLException e){
            System.out.println(e);
            return 0;
        }
    }
    
}
