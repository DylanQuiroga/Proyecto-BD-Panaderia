/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package productos_local;

import GUI_Empleados.*;
import GUI_Login.GUI_Login;
import GUI_Login.GUI_Opciones;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GUI_Empleado extends javax.swing.JFrame {

    String rutIngresado;

    /**
     * Creates new form NewJFrame
     *
     * @param rutLogin
     * @throws java.sql.SQLException
     */
    public GUI_Empleado(String rutLogin) throws SQLException {
        initComponents();
        rutIngresado = rutLogin;
        DefaultTableModel df = new DefaultTableModel();
        df = new DBproducto_local().cargarEmpleadosActivos(df);

        //String ids [] = { "Rut", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido", "Contraseña", "Direccion", "Horario de trabajo", "Salario", "Fecha de contratacion", "Numero"};
        Tabla.setModel(df);
        Tabla.setDefaultEditor(Object.class, null);

        jButton6.setVisible(false);

        Check.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
                        model.setRowCount(0);

                        DefaultTableModel df1 = new DefaultTableModel();

                        df1 = new DBproducto_local().cargarEmpleadosNOActivos(df1);
                        Tabla.setModel(df1);

                        jButton6.setVisible(true);
                        jButton5.setVisible(false);

                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    try {
                        DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
                        model.setRowCount(0);

                        DefaultTableModel df2 = new DefaultTableModel();

                        df2 = new DBproducto_local().cargarEmpleadosActivos(df2);
                        Tabla.setModel(df2);

                        jButton6.setVisible(false);
                        jButton5.setVisible(true);

                    } catch (SQLException ex) {
                        Logger.getLogger(GUI_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });

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
        Check = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Check.setText("Mostrar empleados eliminados");
        Check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckActionPerformed(evt);
            }
        });
        jPanel1.add(Check, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 310, -1));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cerrar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 20, 110, 30));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(Tabla);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1180, 390));

        jButton3.setBackground(new java.awt.Color(51, 153, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Modificar");
        jButton3.setAutoscrolls(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 550, 290, 40));

        jButton4.setBackground(new java.awt.Color(51, 153, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Añadir");
        jButton4.setAutoscrolls(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 290, 40));

        jButton5.setBackground(new java.awt.Color(51, 153, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Eliminar");
        jButton5.setAutoscrolls(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 290, 40));

        jButton6.setBackground(new java.awt.Color(51, 153, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Reincorporar");
        jButton6.setAutoscrolls(true);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 550, 290, 40));

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Volver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Empleados");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 140, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-empl.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1201, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new GUI_Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = Tabla.getSelectedRow();
        String rol = (Tabla.getModel().getValueAt(row, 3).toString());
        String rut = (Tabla.getModel().getValueAt(row, 0).toString());
        this.dispose();
        new GUI_Modificar(rut, rol, rutIngresado).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new GUI_Añadir(rutIngresado).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int row = Tabla.getSelectedRow();
        String rut = (Tabla.getModel().getValueAt(row, 0).toString());
        String rol = (Tabla.getModel().getValueAt(row, 3).toString());

        if (!"Administrador/a".equals(rol)) {
            boolean aprobado = new DBproducto_local().eliminar(rut, rol);

            if (aprobado) {
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente");

                if (row >= 0) {
                    DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
                    model.removeRow(row);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
            }

        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
        new GUI_Opciones(rutIngresado).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckActionPerformed

    }//GEN-LAST:event_CheckActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row = Tabla.getSelectedRow();
        String rut = (Tabla.getModel().getValueAt(row, 0).toString());
        String rol = (Tabla.getModel().getValueAt(row, 3).toString());

        if (!"Administrador/a".equals(rol)) {
            boolean aprobado = new DBproducto_local().reincorporar(rut, rol);

            if (aprobado) {
                JOptionPane.showMessageDialog(null, "Datos reincorporados correctamente");

                if (row >= 0) {
                    DefaultTableModel model = (DefaultTableModel) Tabla.getModel();
                    model.removeRow(row);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error al reincorporar los datos");
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Empleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String rut = "";
                try {
                    new GUI_Empleado(rut).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GUI_Empleado.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Check;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
