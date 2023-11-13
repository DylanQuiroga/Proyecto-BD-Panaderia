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

    String ids[] = {"Rut", "Primer nombre", "Primer apellido", "Direccion", "Rol"};

    public DefaultTableModel cargarEmpleados(DefaultTableModel tablaDF) throws SQLException {

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
            fila[3] = resultSet.getString("direccion");
            fila[4] = "Administrador/a";
            tablaDF.addRow(fila);
        }

        consulta = "SELECT * FROM cajero";
        preparedStatement = connection.prepareStatement(consulta);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
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

        while (resultSet.next()) {
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

    public boolean anadir(String rut, String nombre1, String nombre2, String apellido1, String apellido2, String contrasena, String direccion, String horario, int salario, String contrato, ArrayList<String> numeros, String rol) {
        try {
            String rutAdmin;

            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM admin";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rutAdmin = resultSet.getString("rut_admin");

                if ("Cajero".equals(rol)) {
                    consulta = "INSERT INTO cajero  (rut_cajero, rut_admin, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, contrasena, direccion, horario_trabajo, salario, fecha_contratacion) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(consulta);
                    preparedStatement.setString(1, rut);
                    preparedStatement.setString(2, rutAdmin);
                    preparedStatement.setString(3, nombre1);
                    preparedStatement.setString(4, nombre2);
                    preparedStatement.setString(5, apellido1);
                    preparedStatement.setString(6, apellido2);
                    preparedStatement.setString(7, contrasena);
                    preparedStatement.setString(8, direccion);
                    preparedStatement.setString(9, horario);
                    preparedStatement.setInt(10, salario);
                    preparedStatement.setString(11, contrato);
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
                    consulta = "INSERT INTO panadero  (rut_cajero, rut_admin, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido, contrasena, direccion, horario_trabajo, salario, fecha_contratacion) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                    preparedStatement = connection.prepareStatement(consulta);
                    preparedStatement.setString(1, rut);
                    preparedStatement.setString(2, rutAdmin);
                    preparedStatement.setString(3, nombre1);
                    preparedStatement.setString(4, nombre2);
                    preparedStatement.setString(5, apellido1);
                    preparedStatement.setString(6, apellido2);
                    preparedStatement.setString(7, contrasena);
                    preparedStatement.setString(8, direccion);
                    preparedStatement.setString(9, horario);
                    preparedStatement.setInt(10, salario);
                    preparedStatement.setString(11, contrato);
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

}
