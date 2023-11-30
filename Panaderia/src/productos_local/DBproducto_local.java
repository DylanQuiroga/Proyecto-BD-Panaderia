package productos_local;

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

            // Limpiar el JComboBox antes de cargar nuevos datos
            comboBox.removeAllItems();

            // Recorrer los resultados y agregarlos al JComboBox
            comboBox.addItem("Seleccione la receta:");
            while (resultSet.next()) {
                String itemName = resultSet.getString("nombre_receta");
                comboBox.addItem(itemName);
            }

            // Cerrar recursos (result set, statement y connection)
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

                // Lógica para restar la cantidad utilizada de insumos
                int nuevaCantidad = cantidadDisponible - (cantidadIngrediente * cantidadProductos);

                // Validar que la nueva cantidad no sea negativa
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

            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean anadir(String rut, String nombre1, String nombre2, String apellido1, String apellido2, String contrasena, String direccion, String horario, int salario, String contrato, ArrayList<String> numeros, String rol, String rutIngresado) {
        try {
            String rutAdmin;

            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM admin";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rutAdmin = resultSet.getString("rut_admin");

                if ("Cajero".equals(rol)) {
                    consulta = "INSERT INTO cajero  (rut_cajero, rut_admin, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, contrasena, direccion, horario_trabajo, salario, fecha_contratacion, activo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(consulta);
                    preparedStatement.setString(1, rut);
                    preparedStatement.setString(2, rutIngresado);
                    preparedStatement.setString(3, nombre1);
                    preparedStatement.setString(4, nombre2);
                    preparedStatement.setString(5, apellido1);
                    preparedStatement.setString(6, apellido2);
                    preparedStatement.setString(7, contrasena);
                    preparedStatement.setString(8, direccion);
                    preparedStatement.setString(9, horario);
                    preparedStatement.setInt(10, salario);
                    preparedStatement.setString(11, contrato);
                    preparedStatement.setString(12, "SI");
                    preparedStatement.executeUpdate();

                    consulta = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?)";
                    preparedStatement = connection.prepareStatement(consulta);
                    int totalNum = numeros.size();
                    for (int i = 0; i < totalNum; i++) {
                        preparedStatement.setString(1, numeros.get(i));
                        preparedStatement.setString(2, rut);
                        preparedStatement.setString(3, rol);
                        preparedStatement.executeUpdate();
                    }
                    return true;

                } else if ("Panadero".equals(rol)) {
                    consulta = "INSERT INTO panadero  (rut_panadero, rut_admin, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, contrasena, direccion, horario_trabajo, salario, fecha_contratacion, activo) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(consulta);
                    preparedStatement.setString(1, rut);
                    preparedStatement.setString(2, rutIngresado);
                    preparedStatement.setString(3, nombre1);
                    preparedStatement.setString(4, nombre2);
                    preparedStatement.setString(5, apellido1);
                    preparedStatement.setString(6, apellido2);
                    preparedStatement.setString(7, contrasena);
                    preparedStatement.setString(8, direccion);
                    preparedStatement.setString(9, horario);
                    preparedStatement.setInt(10, salario);
                    preparedStatement.setString(11, contrato);
                    preparedStatement.setString(12, "SI");
                    preparedStatement.executeUpdate();

                    consulta = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?)";
                    preparedStatement = connection.prepareStatement(consulta);
                    int totalNum = numeros.size();
                    for (int i = 0; i < totalNum; i++) {
                        preparedStatement.setString(1, numeros.get(i));
                        preparedStatement.setString(2, rut);
                        preparedStatement.setString(3, rol);
                        preparedStatement.executeUpdate();
                    }
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public boolean modificar(String rut, String nombre1, String nombre2, String apellido1, String apellido2, String contrasena, String direccion, String horario, int salario, String contrato, ArrayList<String> numeros, String rol, String rutIngresado) {
        try {
            String rutAdmin;

            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM admin";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rutAdmin = resultSet.getString("rut_admin");

                if ("Cajero".equals(rol)) {
                    consulta = "UPDATE cajero SET rut_admin = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, contrasena = ?, direccion = ?, horario_trabajo = ?, salario = ?, fecha_contratacion = ? WHERE rut_cajero = ?";
                    preparedStatement = connection.prepareStatement(consulta);
                    preparedStatement.setString(1, rutIngresado);
                    preparedStatement.setString(2, nombre1);
                    preparedStatement.setString(3, nombre2);
                    preparedStatement.setString(4, apellido1);
                    preparedStatement.setString(5, apellido2);
                    preparedStatement.setString(6, contrasena);
                    preparedStatement.setString(7, direccion);
                    preparedStatement.setString(8, horario);
                    preparedStatement.setInt(9, salario);
                    preparedStatement.setString(10, contrato);
                    preparedStatement.setString(11, rut);
                    preparedStatement.executeUpdate();

                    //consulta = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?) ON CONFLICT (numero) DO NOTHING";
                    //preparedStatement = connection.prepareStatement(consulta);
                    int totalNum = numeros.size();
                    for (int i = 0; i < totalNum; i++) {
                        // Verificar si el número ya existe en la tabla
                        String consultaExistencia = "SELECT COUNT(*) FROM numero WHERE numero = ?";
                        PreparedStatement preparedStatementExistencia = connection.prepareStatement(consultaExistencia);
                        preparedStatementExistencia.setString(1, numeros.get(i));
                        resultSet = preparedStatementExistencia.executeQuery();

                        resultSet.next();
                        int count = resultSet.getInt(1);

                        // Insertar solo si el número no existe
                        if (count == 0) {
                            String consultaInsercion = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?)";
                            PreparedStatement preparedStatementInsercion = connection.prepareStatement(consultaInsercion);
                            preparedStatementInsercion.setString(1, numeros.get(i));
                            preparedStatementInsercion.setString(2, rut);
                            preparedStatementInsercion.setString(3, rol);
                            preparedStatementInsercion.executeUpdate();
                        }
                    }

                    return true;

                } else if ("Panadero".equals(rol)) {
                    consulta = "UPDATE panadero SET rut_admin = ?, primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, contrasena = ?, direccion = ?, horario_trabajo = ?, salario = ?, fecha_contratacion = ? WHERE rut_panadero = ?";
                    preparedStatement = connection.prepareStatement(consulta);
                    preparedStatement.setString(1, rutIngresado);
                    preparedStatement.setString(2, nombre1);
                    preparedStatement.setString(3, nombre2);
                    preparedStatement.setString(4, apellido1);
                    preparedStatement.setString(5, apellido2);
                    preparedStatement.setString(6, contrasena);
                    preparedStatement.setString(7, direccion);
                    preparedStatement.setString(8, horario);
                    preparedStatement.setInt(9, salario);
                    preparedStatement.setString(10, contrato);
                    preparedStatement.setString(11, rut);
                    preparedStatement.executeUpdate();

                    //consulta = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?) ON CONFLICT (numero) DO NOTHING";
                    //preparedStatement = connection.prepareStatement(consulta);
                    int totalNum = numeros.size();
                    for (int i = 0; i < totalNum; i++) {
                        // Verificar si el número ya existe en la tabla
                        String consultaExistencia = "SELECT COUNT(*) FROM numero WHERE numero = ?";
                        PreparedStatement preparedStatementExistencia = connection.prepareStatement(consultaExistencia);
                        preparedStatementExistencia.setString(1, numeros.get(i));
                        resultSet = preparedStatementExistencia.executeQuery();

                        resultSet.next();
                        int count = resultSet.getInt(1);

                        // Insertar solo si el número no existe
                        if (count == 0) {
                            String consultaInsercion = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?)";
                            PreparedStatement preparedStatementInsercion = connection.prepareStatement(consultaInsercion);
                            preparedStatementInsercion.setString(1, numeros.get(i));
                            preparedStatementInsercion.setString(2, rut);
                            preparedStatementInsercion.setString(3, rol);
                            preparedStatementInsercion.executeUpdate();
                        }
                    }

                    return true;
                } else if ("Administrador/a".equals(rol)) {
                    consulta = "UPDATE admin SET primer_nombre = ?, segundo_nombre = ?, primer_apellido = ?, segundo_apellido = ?, contrasena = ?, direccion = ?, horario_trabajo = ?, salario = ?, fecha_contratacion = ? WHERE rut_admin = ?";
                    preparedStatement = connection.prepareStatement(consulta);

                    preparedStatement.setString(1, nombre1);
                    preparedStatement.setString(2, nombre2);
                    preparedStatement.setString(3, apellido1);
                    preparedStatement.setString(4, apellido2);
                    preparedStatement.setString(5, contrasena);
                    preparedStatement.setString(6, direccion);
                    preparedStatement.setString(7, horario);
                    preparedStatement.setInt(8, salario);
                    preparedStatement.setString(9, contrato);
                    preparedStatement.setString(10, rut);
                    preparedStatement.executeUpdate();

                    int totalNum = numeros.size();
                    for (int i = 0; i < totalNum; i++) {
                        // Verificar si el número ya existe en la tabla
                        String consultaExistencia = "SELECT COUNT(*) FROM numero WHERE numero = ?";
                        PreparedStatement preparedStatementExistencia = connection.prepareStatement(consultaExistencia);
                        preparedStatementExistencia.setString(1, numeros.get(i));
                        resultSet = preparedStatementExistencia.executeQuery();

                        resultSet.next();
                        int count = resultSet.getInt(1);

                        // Insertar solo si el número no existe
                        if (count == 0) {
                            String consultaInsercion = "INSERT INTO numero (numero, rut, tipo_empleado) VALUES (?,?,?)";
                            PreparedStatement preparedStatementInsercion = connection.prepareStatement(consultaInsercion);
                            preparedStatementInsercion.setString(1, numeros.get(i));
                            preparedStatementInsercion.setString(2, rut);
                            preparedStatementInsercion.setString(3, rol);
                            preparedStatementInsercion.executeUpdate();
                        }
                    }
                    return true;
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public boolean eliminar(String rut, String rol) {
        try {
            if ("Cajero/a".equals(rol)) {
                Connection connection = DriverManager.getConnection(url, username, password);
                String consulta = "UPDATE cajero SET activo = ? WHERE rut_cajero = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, "NO");
                preparedStatement.setString(2, rut);
                preparedStatement.executeUpdate();

                /*consulta = "DELETE FROM numero WHERE rut = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                preparedStatement.executeUpdate();*/
                return true;
            } else if ("Panadero/a".equals(rol)) {
                Connection connection = DriverManager.getConnection(url, username, password);
                String consulta = "UPDATE panadero SET activo = ? WHERE rut_panadero = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, "NO");
                preparedStatement.setString(2, rut);
                preparedStatement.executeUpdate();

                /*consulta = "DELETE FROM numero WHERE rut = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                preparedStatement.executeUpdate();*/
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public boolean reincorporar(String rut, String rol) {
        try {
            if ("Cajero/a".equals(rol)) {
                Connection connection = DriverManager.getConnection(url, username, password);
                String consulta = "UPDATE cajero SET activo = ? WHERE rut_cajero = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, "SI");
                preparedStatement.setString(2, rut);
                preparedStatement.executeUpdate();

                /*consulta = "DELETE FROM numero WHERE rut = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                preparedStatement.executeUpdate();*/
                return true;
            } else if ("Panadero/a".equals(rol)) {
                Connection connection = DriverManager.getConnection(url, username, password);
                String consulta = "UPDATE panadero SET activo = ? WHERE rut_panadero = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, "SI");
                preparedStatement.setString(2, rut);
                preparedStatement.executeUpdate();

                /*consulta = "DELETE FROM numero WHERE rut = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                preparedStatement.executeUpdate();*/
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return false;
    }

    public String[] cargarDatos(String rut, String rol) {
        String retorno[] = new String[10];
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta;
            PreparedStatement preparedStatement;

            if ("Administrador/a".equals(rol)) {
                consulta = "SELECT * FROM admin WHERE rut_admin = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    retorno[0] = resultSet.getString("rut_admin");
                    retorno[1] = resultSet.getString("primer_nombre");
                    retorno[2] = resultSet.getString("segundo_nombre");
                    retorno[3] = resultSet.getString("primer_apellido");
                    retorno[4] = resultSet.getString("segundo_apellido");
                    retorno[5] = resultSet.getString("contrasena");
                    retorno[6] = resultSet.getString("direccion");
                    retorno[7] = resultSet.getString("horario_trabajo");
                    retorno[8] = Integer.toString(resultSet.getInt("salario"));
                    retorno[9] = resultSet.getString("fecha_contratacion");
                    return retorno;

                }

            } else if ("Cajero/a".equals(rol)) {
                consulta = "SELECT * FROM cajero WHERE rut_cajero = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    retorno[0] = resultSet.getString("rut_cajero");
                    retorno[1] = resultSet.getString("primer_nombre");
                    retorno[2] = resultSet.getString("segundo_nombre");
                    retorno[3] = resultSet.getString("primer_apellido");
                    retorno[4] = resultSet.getString("segundo_apellido");
                    retorno[5] = resultSet.getString("contrasena");
                    retorno[6] = resultSet.getString("direccion");
                    retorno[7] = resultSet.getString("horario_trabajo");
                    retorno[8] = Integer.toString(resultSet.getInt("salario"));
                    retorno[9] = resultSet.getString("fecha_contratacion");
                    return retorno;

                }

            } else if ("Panadero/a".equals(rol)) {
                consulta = "SELECT * FROM panadero WHERE rut_panadero = ?";
                preparedStatement = connection.prepareStatement(consulta);
                preparedStatement.setString(1, rut);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    retorno[0] = resultSet.getString("rut_panadero");
                    retorno[1] = resultSet.getString("primer_nombre");
                    retorno[2] = resultSet.getString("segundo_nombre");
                    retorno[3] = resultSet.getString("primer_apellido");
                    retorno[4] = resultSet.getString("segundo_apellido");
                    retorno[5] = resultSet.getString("contrasena");
                    retorno[6] = resultSet.getString("direccion");
                    retorno[7] = resultSet.getString("horario_trabajo");
                    retorno[8] = Integer.toString(resultSet.getInt("salario"));
                    retorno[9] = resultSet.getString("fecha_contratacion");
                    return retorno;

                }
            }

        } catch (SQLException e) {
            for (int i = 0; i < retorno.length; i++) {
                retorno[i] = "Error";
            }
            return retorno;
        }
        for (int i = 0; i < retorno.length; i++) {
            retorno[i] = "Error";
        }
        return retorno;
    }

    public String[] cargarNumeros(String rut) {
        String retorno[];
        int totalNum = 0;

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta;
            PreparedStatement preparedStatement;

            consulta = "SELECT * FROM numero WHERE rut = ?";
            preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, rut);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                totalNum++;
            }

            retorno = new String[totalNum];
            int i = 0;
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                retorno[i] = resultSet.getString("numero");
                i++;
            }

            return retorno;

        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

}
