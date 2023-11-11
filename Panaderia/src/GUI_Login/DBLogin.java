package GUI_Login;

import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public class DBLogin {

    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";

    public boolean comprobarExistenciaAdmin(String rut, String contra) throws SQLException, ClassNotFoundException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String consulta = "SELECT * FROM admin WHERE rut_admin = ? AND contrasena = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);

            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, contra);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String rutSQL = resultSet.getString("rut_admin");
                String contraSQL = resultSet.getString("contrasena");
                return rutSQL.equals(rut) && contraSQL.equals(contra);
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la conexion con la base de datos");
            System.exit(0);
        }
        return false;
    }

    public boolean comprobarExistenciaCajero(String rut, String contra) throws SQLException, ClassNotFoundException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String consulta = "SELECT * FROM cajero WHERE rut_cajero = ? AND contrasena = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);

            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, contra);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String rutSQL = resultSet.getString("rut_cajero");
                String contraSQL = resultSet.getString("contrasena");
                return rutSQL.equals(rut) && contraSQL.equals(contra);
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la conexion con la base de datos");
            System.exit(0);
        }
        return false;
    }

    public boolean comprobarExistenciaPanadero(String rut, String contra) throws SQLException, ClassNotFoundException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String consulta = "SELECT * FROM panadero WHERE rut_panadero = ? AND contrasena = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);

            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, contra);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String rutSQL = resultSet.getString("rut_panadero");
                String contraSQL = resultSet.getString("contrasena");
                return rutSQL.equals(rut) && contraSQL.equals(contra);
            } else {
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error con la conexion con la base de datos");
            System.exit(0);
        }
        return false;
    }
}
