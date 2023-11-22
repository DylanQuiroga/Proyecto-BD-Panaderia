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
    
    String retorno[];
    int i = 0;

    public String[] cargarRecetas() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM receta";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                i++;
            }

            retorno = new String[i];
            int i = 0;
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                retorno[i] = resultSet.getString("nombre_receta");
                i++;
            }

            return retorno;

        } catch (SQLException e) {
            return null;
        }

    }
    
}
