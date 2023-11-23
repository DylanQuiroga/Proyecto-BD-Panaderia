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

    String ids[] = {"Rut", "Primer nombre", "Primer apellido", "Rol", "Activo"};

    public DefaultTableModel cargarEmpleadosActivos(DefaultTableModel tablaDF) throws SQLException {

        tablaDF.setColumnIdentifiers(ids);

        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT * FROM admin";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_admin");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = "Administrador/a";
            fila[4] = "SI";
            tablaDF.addRow(fila);
        }

        consulta = "SELECT * FROM cajero WHERE activo = ?";
        preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, "SI");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_cajero");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = "Cajero/a";
            fila[4] = resultSet.getString("activo");
            tablaDF.addRow(fila);
        }

        consulta = "SELECT * FROM panadero WHERE activo = ?";
        preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, "SI");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_panadero");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = "Panadero/a";
            fila[4] = resultSet.getString("activo");
            tablaDF.addRow(fila);
        }

        return tablaDF;

    }
    
        public DefaultTableModel cargarEmpleadosNOActivos(DefaultTableModel tablaDF) throws SQLException {

        tablaDF.setColumnIdentifiers(ids);

        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT * FROM cajero WHERE activo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, "NO");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_cajero");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = "Cajero/a";
            fila[4] = resultSet.getString("activo");
            tablaDF.addRow(fila);
        }

        consulta = "SELECT * FROM panadero WHERE activo = ?";
        preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setString(1, "NO");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Object[] fila = new Object[5];
            fila[0] = resultSet.getString("rut_panadero");
            fila[1] = resultSet.getString("primer_nombre");
            fila[2] = resultSet.getString("primer_apellido");
            fila[3] = "Panadero/a";
            fila[4] = resultSet.getString("activo");
            tablaDF.addRow(fila);
        }

        return tablaDF;

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
