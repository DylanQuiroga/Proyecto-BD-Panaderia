package GUI_productos_local;

import GUI_Empleados.*;
import java.sql.*;
import java.io.*;
import java.lang.System.Logger;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DBproducto_local {

    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";
    String ids[] = {"id", "Nombre del producto", "Tipo", "Precio", "Stock"};

    public DefaultTableModel cargarProductoLocal(DefaultTableModel tablaDF) throws SQLException {

        tablaDF.setColumnIdentifiers(ids);

        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT * FROM producto_local ORDER BY id_producto ASC;";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[5];
            fila[0] = resultSet.getInt("id_producto");
            fila[1] = resultSet.getString("nombre_producto");
            fila[2] = resultSet.getString("tipo_producto");
            fila[3] = "$ " + resultSet.getInt("precio_producto");
            fila[4] = resultSet.getInt("stock_producto");
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

            
            comboBox.addItem("Seleccione la receta:");
            while (resultSet.next()) {
                String itemName = resultSet.getString("nombre_receta");
                comboBox.addItem(itemName);
            }

            
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace(); // Imprimir la traza completa del error
        }
    }

    public static void agregarProductos(String nombreReceta, int cantidadProductos) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            int noAumentarStock = 0;

            String consulta = "SELECT r.nombre_receta, i.nombre_insumo_inv, i.cantidad_disponible, ing.nombre_ingrediente, ing.unidad_metrica, ing.cantidad "
                    + "FROM receta r "
                    + "JOIN ingredientes ing ON r.nombre_receta = ing.nombre_receta "
                    + "JOIN insumos_disponibles i ON ing.nombre_ingrediente = i.nombre_insumo_inv "
                    + "WHERE r.nombre_receta = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, nombreReceta);

            ResultSet resultSet = preparedStatement.executeQuery();

            // Procesar resultados y actualizar existencias
            while (resultSet.next()) {
                String nombreInsumo = resultSet.getString("nombre_insumo_inv");
                int cantidadDisponible = resultSet.getInt("cantidad_disponible");
                String nombreIngrediente = resultSet.getString("nombre_ingrediente");
                String unidadMetrica = resultSet.getString("unidad_metrica");
                int cantidadIngrediente = resultSet.getInt("cantidad");

                //resta la cantidad utilizada de insumos
                int nuevaCantidad = cantidadDisponible - (cantidadIngrediente * cantidadProductos);

                // Valida que la nueva cantidad no sea negativa
                if (nuevaCantidad < 0) {
                    JOptionPane.showMessageDialog(null, "Error: No hay suficientes insumos disponibles para agregar " + cantidadProductos + " unidades de " + nombreReceta, "Error", JOptionPane.ERROR_MESSAGE);
                    noAumentarStock = 1;
                    return;
                }

                // Actualizar la tabla insumos_disponibles con la nueva cantidad
                String sqlUpdateInsumos = "UPDATE insumos_disponibles SET cantidad_disponible = ? WHERE nombre_insumo_inv = ?";
                PreparedStatement updateInsumosStatement = connection.prepareStatement(sqlUpdateInsumos);
                updateInsumosStatement.setInt(1, nuevaCantidad);
                updateInsumosStatement.setString(2, nombreInsumo);
                updateInsumosStatement.executeUpdate();
            }
            //Si nuevaCantidad es negativo, es decir, no hay insumos, no se actualiza el stock
            if (noAumentarStock == 0) {
                // Obtener el stock actual del producto_local
                String sqlSelectStock = "SELECT stock_producto FROM producto_local WHERE nombre_producto = ?";
                PreparedStatement selectStockStatement = connection.prepareStatement(sqlSelectStock);
                selectStockStatement.setString(1, nombreReceta);
                ResultSet stockResultSet = selectStockStatement.executeQuery();

                // Actualizar el stock_producto en la tabla producto_local
                if (stockResultSet.next()) {
                    int stockActual = stockResultSet.getInt("stock_producto");
                    int nuevoStock = stockActual + cantidadProductos;

                    String sqlUpdateStock = "UPDATE producto_local SET stock_producto = ? WHERE nombre_producto = ?";
                    PreparedStatement updateStockStatement = connection.prepareStatement(sqlUpdateStock);
                    updateStockStatement.setInt(1, nuevoStock);
                    updateStockStatement.setString(2, nombreReceta);
                    updateStockStatement.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Se han agregado " + cantidadProductos + " unidades de " + nombreReceta + " al stock.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error: No hay suficientes insumos disponibles para aumentar el stock");
            }

       
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

  

}
