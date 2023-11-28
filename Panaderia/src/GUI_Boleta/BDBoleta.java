package GUI_Boleta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class BDBoleta {
    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";
    
    String ids[] = {"Dia", "Mes", "Año", "Total", "Rut encargado"};
    
    public DefaultTableModel cargarBoletas(DefaultTableModel tablaDF) throws SQLException{
        tablaDF.setColumnIdentifiers(ids);
        
        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT * FROM venta";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        while (resultSet.next()) {
            Object[] fila = new Object[6];
            fila[0] = resultSet.getString("dia");
            fila[1] = resultSet.getString("mes");
            fila[2] = resultSet.getString("anio");
            fila[3] = resultSet.getString("total_venta");
            fila[4] = resultSet.getString("rut_encargado");
            tablaDF.addRow(fila);
        }
        
        return tablaDF;
    }
    
}
