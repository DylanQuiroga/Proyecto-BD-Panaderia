/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Login;

import GUI_Boleta.GUI_Boleta;
import GUI_Empleados.GUI_Empleado;
import GUI_Pedidos.GUI_Pedidos;
import GUI_Proveedores.GUI_Proveedores;
import GUI_Venta.GUI_Venta;
import GUI_Receta.GUI_Receta;
import GUI_insumos_disponibles.GUI_ver_insumos_disponibles;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import GUI_productos_local.GUI_ver_producto_local;
/**
 *
 * @author Usuario
 */
public class GUI_Opciones extends javax.swing.JFrame {
    String rutIngresado;
    /**
     * Creates new form Opciones
     * @param rutLogin
     */
    public GUI_Opciones(String rutLogin) {
        initComponents();
        rutIngresado = rutLogin;
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

        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 400));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("OPCIONES");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 130, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/163059902-vendedor-de-cajero-en-el-vector-de-icono-de-color-de-mostrador-vendedor-de-cajero-en-el-mostrador.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 80, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/3565418.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 80, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Empleados");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, 90, 20));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Venta");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 50, 20));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Recetas");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 70, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/4237554.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 80, 80));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Proveedores");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 100, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono-Stock-Permanente.png"))); // NOI18N
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirInsumosDispo(evt);
            }
        });
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 80, 80));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Insumos");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 60, 20));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Boletas");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 70, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/1312307.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirProductoLocal(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 90, 90));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Productos del local");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 140, 20));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono-Actualizacion-Insumos.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 80, 80));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/554795 (1).png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, 80, 80));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pedidos");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 70, 20));

        jButton1.setBackground(new java.awt.Color(255, 204, 255));
        jButton1.setForeground(new java.awt.Color(153, 0, 153));
        jButton1.setText("Cerrar sesion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 110, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/boleta.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 80, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo_login.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new GUI_Login().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        this.dispose();
        try {
            new GUI_Empleado(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        try {
            new GUI_Venta(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
        try {
            new GUI_Proveedores(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        this.dispose();
        try {
            new GUI_Pedidos(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel14MouseClicked
  
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
        try {
            String Seleccionado = "";
            new GUI_Receta(rutIngresado, Seleccionado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void abrirInsumosDispo(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirInsumosDispo
        this.dispose();
        try {
            new GUI_ver_insumos_disponibles(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrirInsumosDispo

    private void abrirProductoLocal(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirProductoLocal
        this.dispose();
        try {
            new GUI_ver_producto_local(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_abrirProductoLocal

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       this.dispose();
        try {
            new GUI_Boleta(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Opciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(GUI_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Opciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String rut = "";
                new GUI_Opciones(rut).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
