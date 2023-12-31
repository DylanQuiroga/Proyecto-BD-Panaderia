/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Receta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rebv1
 */
public class GUI_Añadir_Receta extends javax.swing.JFrame {

    String rutIngresado;
    String[] ids = {"ingrediente", "unidad metrica", "cantidad"};
    DefaultTableModel df = new DefaultTableModel();

    /**
     * Creates new form GUI_Añadir_Receta
     */
    public GUI_Añadir_Receta(String rutLogin) throws SQLException {
        rutIngresado = rutLogin;
        initComponents();

        df.setColumnIdentifiers(ids);
        jTable1.setModel(df);
        jTable1.setDefaultEditor(Object.class, null);

        String[] unidad = {"gramos", "mililitros", "cucharaditas"};
        UnidadMetrica.addItem("");
        for (String item : unidad) {
            UnidadMetrica.addItem(item);
        }

        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NombreReceta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Descripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Ingrediente = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        UnidadMetrica = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Añadir Receta");
        jLabel1.setMaximumSize(new java.awt.Dimension(127, 32));
        jLabel1.setMinimumSize(new java.awt.Dimension(127, 32));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 170, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/equis.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        NombreReceta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreRecetaActionPerformed(evt);
            }
        });
        NombreReceta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NombreRecetaKeyPressed(evt);
            }
        });
        jPanel1.add(NombreReceta, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 270, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Ingredientes");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 120, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Nombre Receta");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, 30));

        Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DescripcionActionPerformed(evt);
            }
        });
        Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DescripcionKeyPressed(evt);
            }
        });
        jPanel1.add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 270, 90));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Descripcion");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        Ingrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngredienteActionPerformed(evt);
            }
        });
        Ingrediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                IngredienteKeyPressed(evt);
            }
        });
        jPanel1.add(Ingrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 160, 30));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 50, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Unidad Metrica");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 150, 30));

        jPanel1.add(UnidadMetrica, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 150, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Cantidad");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 90, 30));

        Cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CantidadActionPerformed(evt);
            }
        });
        Cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CantidadKeyPressed(evt);
            }
        });
        jPanel1.add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 50, 30));

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("AÑADIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 610, 240, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, 180));

        jButton4.setText("-");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 50, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_receta.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 670));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        try {
            String Seleccionado = null;
            new GUI_Receta(rutIngresado, Seleccionado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Receta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void NombreRecetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreRecetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreRecetaActionPerformed

    private void NombreRecetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombreRecetaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreRecetaKeyPressed

    private void DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionActionPerformed

    private void DescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DescripcionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DescripcionKeyPressed

    private void IngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngredienteActionPerformed

    private void IngredienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_IngredienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_IngredienteKeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (Ingrediente.getText().isEmpty() || UnidadMetrica.getSelectedItem().toString().isEmpty() || Cantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Introduzca valores en las 3 casillas: ingrediente, unidad y cantidad");
        } else {
            Object[] fila = new Object[3];
            String ingrediente = Ingrediente.getText();
            String unidadmetrica = (String) UnidadMetrica.getSelectedItem();
            int cantidad = Integer.parseInt(Cantidad.getText());
            fila[0] = ingrediente;
            fila[1] = unidadmetrica;
            fila[2] = cantidad;
            df.addRow(fila);
            Ingrediente.setText("");
            Cantidad.setText("");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void CantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadActionPerformed

    private void CantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CantidadKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CantidadKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String nombrereceta = NombreReceta.getText();
            String descripcion = Descripcion.getText();
            ArrayList<String> ingredientes = new ArrayList<>();
            ArrayList<String> unidadmetrica = new ArrayList<>();
            ArrayList<Integer> cantidad = new ArrayList<>();

            for (int i = 0; jTable1.getRowCount() > i; i++) {
                ingredientes.add(i, (String) jTable1.getValueAt(i, 0));
                unidadmetrica.add(i, (String) jTable1.getValueAt(i, 1));
                cantidad.add(i, (Integer) jTable1.getValueAt(i, 2));
            }

            if (NombreReceta.getText().isEmpty() || Descripcion.getText().isEmpty() || ingredientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellene todas las casillas");
            }else{
                boolean aprobado = new DBReceta().anadirReceta(nombrereceta, descripcion, ingredientes, unidadmetrica, cantidad);
                if (aprobado) {
                    JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                    this.dispose();
                    String Seleccionado = "";
                    new GUI_Receta(rutIngresado, Seleccionado).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al ingresar los datos a la base de datos");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor de la cantidad ingresela como numero");
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Añadir_Receta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int row = jTable1.getSelectedRow();
        df.removeRow(row);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Añadir_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Añadir_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Añadir_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Añadir_Receta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String rut = "";
                try {
                    new GUI_Añadir_Receta(rut).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_Añadir_Receta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cantidad;
    private javax.swing.JTextField Descripcion;
    private javax.swing.JTextField Ingrediente;
    private javax.swing.JTextField NombreReceta;
    private javax.swing.JComboBox<String> UnidadMetrica;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
