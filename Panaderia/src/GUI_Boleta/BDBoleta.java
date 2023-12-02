package GUI_Boleta;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class BDBoleta {

    static String driver = "org.postgresql.Driver";
    static String dbname = "panaderia";
    static String url = "jdbc:postgresql://10.4.3.195:5432/" + dbname;
    static String username = "panaderia";
    static String password = "im7stB6";

    String ids[] = {"Dia", "Mes", "Año", "Total", "Rut encargado"};

    public DefaultTableModel cargarBoletas(DefaultTableModel tablaDF) throws SQLException {
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

    public DefaultTableModel cargarBoletas_Dia(DefaultTableModel tablaDF, boolean act) throws SQLException {
        tablaDF.setColumnIdentifiers(ids);

        if (act) {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY dia ASC";
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
        } else {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY dia DESC";
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
        }

        return tablaDF;
    }

    public DefaultTableModel cargarBoletas_Mes(DefaultTableModel tablaDF, boolean act) throws SQLException {
        tablaDF.setColumnIdentifiers(ids);

        if (act) {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY mes ASC";
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
        } else {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY mes DESC";
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
        }

        return tablaDF;
    }

    public DefaultTableModel cargarBoletas_anio(DefaultTableModel tablaDF, boolean act) throws SQLException {
        tablaDF.setColumnIdentifiers(ids);

        if (act) {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY anio ASC";
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
        } else {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY anio DESC";
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
        }

        return tablaDF;

    }

    public DefaultTableModel cargarBoletas_cant(DefaultTableModel tablaDF, boolean act) throws SQLException {
        tablaDF.setColumnIdentifiers(ids);

        if (act) {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY total_venta ASC";
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
        } else {
            Connection connection = DriverManager.getConnection(url, username, password);
            String consulta = "SELECT * FROM venta ORDER BY total_venta DESC";
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
        }

        return tablaDF;

    }

    public void graficar1() throws SQLException, InterruptedException {
        String[] texto1, texto2;
        int i = 0;
        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT rut_encargado, SUM(total_venta) AS total_venta_por_encargado FROM venta GROUP BY rut_encargado";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            i++;
        }

        texto1 = new String[i];
        texto2 = new String[i];
        i = 0;
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            texto1[i] = resultSet.getString("rut_encargado");
            texto2[i] = resultSet.getString("total_venta_por_encargado");
            i++;
        }

        File file = new File("GUI_Boleta.java");
        String directoryPath = file.getAbsoluteFile().getParent();
        String direccionTexto1 = directoryPath + "\\src\\Python\\texto1.txt";
        String direccionTexto2 = directoryPath + "\\src\\Python\\texto2.txt";

        try {
            FileWriter writerRut = new FileWriter(direccionTexto1);
            FileWriter writerVenta = new FileWriter(direccionTexto2);

            for (String rut : texto1) {
                writerRut.write(rut + "\n");
            }

            for (String venta : texto2) {
                writerVenta.write(venta + "\n");
            }

            writerRut.close();
            writerVenta.close();

            String cmdStr = directoryPath + "\\src\\Python\\grafico1.py";
            ProcessBuilder Process_Builder = new ProcessBuilder("python", cmdStr).inheritIO();
            Process Demo_Process = Process_Builder.start();
            Demo_Process.waitFor();

            cmdStr = directoryPath + "\\src\\Python\\grafico.png";
            BufferedImage img = ImageIO.read(new File(cmdStr));

            JLabel label = new JLabel(new ImageIcon(img));
            JFrame frame = new JFrame();
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(BDBoleta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void graficar2(String anio) throws SQLException, InterruptedException {
        String[] texto1, texto2;
        int anioInt = Integer.parseInt(anio);
        int i = 0;
        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT mes, AVG(total_venta) as ventas_totales FROM venta WHERE anio = ? GROUP BY mes ORDER BY mes";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setInt(1, anioInt);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            i++;
        }

        texto1 = new String[i];
        texto2 = new String[i];
        i = 0;
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            texto1[i] = resultSet.getString("mes");
            texto2[i] = resultSet.getString("ventas_totales");
            i++;
        }

        File file = new File("GUI_Boleta.java");
        String directoryPath = file.getAbsoluteFile().getParent();
        String direccionTexto1 = directoryPath + "\\src\\Python\\texto1.txt";
        String direccionTexto2 = directoryPath + "\\src\\Python\\texto2.txt";

        try {
            FileWriter writerRut = new FileWriter(direccionTexto1);
            FileWriter writerVenta = new FileWriter(direccionTexto2);

            for (String rut : texto1) {
                writerRut.write(rut + "\n");
            }

            for (String venta : texto2) {
                writerVenta.write(venta + "\n");
            }

            writerRut.close();
            writerVenta.close();

            String cmdStr = directoryPath + "\\src\\Python\\grafico2.py";
            ProcessBuilder Process_Builder = new ProcessBuilder("python", cmdStr).inheritIO();
            Process Demo_Process = Process_Builder.start();
            Demo_Process.waitFor();

            cmdStr = directoryPath + "\\src\\Python\\grafico.png";
            BufferedImage img = ImageIO.read(new File(cmdStr));

            JLabel label = new JLabel(new ImageIcon(img));
            JFrame frame = new JFrame();
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(BDBoleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void graficar3() throws SQLException, InterruptedException {
        String[] texto1, texto2;
        int i = 0;
        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT anio, AVG(total_venta) as promedio FROM venta GROUP BY anio";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            i++;
        }

        texto1 = new String[i];
        texto2 = new String[i];
        i = 0;
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            texto1[i] = resultSet.getString("anio");
            texto2[i] = resultSet.getString("promedio");
            i++;
        }

        File file = new File("GUI_Boleta.java");
        String directoryPath = file.getAbsoluteFile().getParent();
        String direccionTexto1 = directoryPath + "\\src\\Python\\texto1.txt";
        String direccionTexto2 = directoryPath + "\\src\\Python\\texto2.txt";

        try {
            FileWriter writerRut = new FileWriter(direccionTexto1);
            FileWriter writerVenta = new FileWriter(direccionTexto2);

            for (String rut : texto1) {
                writerRut.write(rut + "\n");
            }

            for (String venta : texto2) {
                writerVenta.write(venta + "\n");
            }

            writerRut.close();
            writerVenta.close();

            String cmdStr = directoryPath + "\\src\\Python\\grafico3.py";
            ProcessBuilder Process_Builder = new ProcessBuilder("python", cmdStr).inheritIO();
            Process Demo_Process = Process_Builder.start();
            Demo_Process.waitFor();

            cmdStr = directoryPath + "\\src\\Python\\grafico.png";
            BufferedImage img = ImageIO.read(new File(cmdStr));

            JLabel label = new JLabel(new ImageIcon(img));
            JFrame frame = new JFrame();
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(BDBoleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void graficar4(String anio, String mes) throws SQLException, InterruptedException{
        String[] texto1, texto2;
        int i = 0;
        int anioInt = Integer.parseInt(anio);
        int mesInt = Integer.parseInt(mes);
        
        Connection connection = DriverManager.getConnection(url, username, password);
        String consulta = "SELECT dia, SUM(total_venta) as cantgen FROM venta WHERE mes = ? AND anio = ? GROUP BY dia ORDER BY dia ASC";
        PreparedStatement preparedStatement = connection.prepareStatement(consulta);
        preparedStatement.setInt(1, mesInt);
        preparedStatement.setInt(2, anioInt);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            i++;
        }

        texto1 = new String[i];
        texto2 = new String[i];
        i = 0;
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            texto1[i] = resultSet.getString("dia");
            texto2[i] = resultSet.getString("cantgen");
            i++;
        }

        File file = new File("GUI_Boleta.java");
        String directoryPath = file.getAbsoluteFile().getParent();
        String direccionTexto1 = directoryPath + "\\src\\Python\\texto1.txt";
        String direccionTexto2 = directoryPath + "\\src\\Python\\texto2.txt";

        try {
            FileWriter writerRut = new FileWriter(direccionTexto1);
            FileWriter writerVenta = new FileWriter(direccionTexto2);

            for (String rut : texto1) {
                writerRut.write(rut + "\n");
            }

            for (String venta : texto2) {
                writerVenta.write(venta + "\n");
            }

            writerRut.close();
            writerVenta.close();

            String cmdStr = directoryPath + "\\src\\Python\\grafico4.py";
            ProcessBuilder Process_Builder = new ProcessBuilder("python", cmdStr).inheritIO();
            Process Demo_Process = Process_Builder.start();
            Demo_Process.waitFor();

            cmdStr = directoryPath + "\\src\\Python\\grafico.png";
            BufferedImage img = ImageIO.read(new File(cmdStr));

            JLabel label = new JLabel(new ImageIcon(img));
            JFrame frame = new JFrame();
            frame.getContentPane().add(label, BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

        } catch (IOException ex) {
            Logger.getLogger(BDBoleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
