/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI_Empleados;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class GUI_Modificar extends javax.swing.JFrame {

    String rutIngresado;

    /**
     * Creates new form Añadir
     *
     * @param rut
     * @param rutLogin
     * @param rol
     */
    public GUI_Modificar(String rut, String rol, String rutLogin) {
        initComponents();
        Rut.setText(rut);
        rutIngresado = rutLogin;

        if ("Administrador/a".equals(rol)) {
            Rol.addItem(rol);
            Rol.setSelectedIndex(2);
            Rol.disable();

        } else if ("Cajero/a".equals(rol)) {
            Rol.setSelectedIndex(0);
        } else if ("Panadero/a".equals(rol)) {
            Rol.setSelectedIndex(1);
        }

        String[] datos = new DBEmpleados().cargarDatos(rut, rol);
        String[] numero = new DBEmpleados().cargarNumeros(rut);

        iniciarDatos(datos);
        cargatNum(numero);

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

        totalNum = new javax.swing.JComboBox<>();
        Rol = new javax.swing.JComboBox<>();
        Contrato = new javax.swing.JTextField();
        Numero = new javax.swing.JTextField();
        Horario = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        Contrasena = new javax.swing.JTextField();
        Apellido1 = new javax.swing.JTextField();
        Apellido2 = new javax.swing.JTextField();
        Nombre2 = new javax.swing.JTextField();
        Rut = new javax.swing.JTextField();
        Salario1 = new javax.swing.JTextField();
        Nombre1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        getContentPane().add(totalNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 190, 30));

        Rol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cajero", "Panadero" }));
        getContentPane().add(Rol, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 180, 30));

        Contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContratoActionPerformed(evt);
            }
        });
        Contrato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ContratoKeyPressed(evt);
            }
        });
        getContentPane().add(Contrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 180, 30));

        Numero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumeroActionPerformed(evt);
            }
        });
        Numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NumeroKeyPressed(evt);
            }
        });
        getContentPane().add(Numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, 180, 30));

        Horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HorarioActionPerformed(evt);
            }
        });
        Horario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HorarioKeyPressed(evt);
            }
        });
        getContentPane().add(Horario, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, 180, 30));

        Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionActionPerformed(evt);
            }
        });
        Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DireccionKeyPressed(evt);
            }
        });
        getContentPane().add(Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 180, 30));

        Contrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContrasenaActionPerformed(evt);
            }
        });
        Contrasena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ContrasenaKeyPressed(evt);
            }
        });
        getContentPane().add(Contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 180, 30));

        Apellido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido1ActionPerformed(evt);
            }
        });
        Apellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Apellido1KeyPressed(evt);
            }
        });
        getContentPane().add(Apellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 200, 180, 30));

        Apellido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Apellido2ActionPerformed(evt);
            }
        });
        Apellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Apellido2KeyPressed(evt);
            }
        });
        getContentPane().add(Apellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 180, 30));

        Nombre2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre2ActionPerformed(evt);
            }
        });
        Nombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Nombre2KeyPressed(evt);
            }
        });
        getContentPane().add(Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 180, 30));

        Rut.setEnabled(false);
        Rut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RutActionPerformed(evt);
            }
        });
        Rut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RutKeyPressed(evt);
            }
        });
        getContentPane().add(Rut, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 180, 30));

        Salario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salario1ActionPerformed(evt);
            }
        });
        Salario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Salario1KeyPressed(evt);
            }
        });
        getContentPane().add(Salario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 180, 30));

        Nombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre1ActionPerformed(evt);
            }
        });
        Nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Nombre1KeyPressed(evt);
            }
        });
        getContentPane().add(Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 180, 30));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Modificar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 630, 210, 40));

        jButton2.setText("-");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 40, 30));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 40, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/equis.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 30, 30));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fecha de contrato");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 160, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Numero");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 160, 30));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Horario");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 160, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Rol");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 50, 30));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dirección");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 160, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Contraseña");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 160, 30));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Segundo apellido");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 160, 30));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Primer apellido");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 160, 30));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Salario");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 160, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Segundo nombre");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 160, 30));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rut");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 50, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Primer nombre");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 140, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modificar empleado");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 240, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo-empl.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 740));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Apellido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apellido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido1ActionPerformed

    private void Apellido1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Apellido1KeyPressed

    }//GEN-LAST:event_Apellido1KeyPressed

    private void RutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RutActionPerformed

    private void RutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_RutKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_RutKeyPressed

    private void Nombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre1ActionPerformed

    private void Nombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre1KeyPressed

    private void Nombre2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre2ActionPerformed

    private void Nombre2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre2KeyPressed

    private void Apellido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Apellido2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido2ActionPerformed

    private void Apellido2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Apellido2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Apellido2KeyPressed

    private void ContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContrasenaActionPerformed

    private void ContrasenaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContrasenaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContrasenaKeyPressed

    private void DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionActionPerformed

    private void DireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DireccionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionKeyPressed

    private void HorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorarioActionPerformed

    private void HorarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HorarioKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorarioKeyPressed

    private void NumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroActionPerformed

    private void NumeroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumeroKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumeroKeyPressed

    private void ContratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContratoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContratoActionPerformed

    private void ContratoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContratoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContratoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
        try {
            new GUI_Empleado(rutIngresado).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            String rut = Rut.getText();
            String nombre1 = Nombre1.getText();
            String nombre2 = Nombre2.getText();
            String apellido1 = Apellido1.getText();
            String apellido2 = Apellido2.getText();
            String contrasena = Contrasena.getText();
            String direccion = Direccion.getText();
            String horario = Horario.getText();
            String salarioStr = Salario1.getText();
            int salario = Integer.parseInt(salarioStr);
            String contrato = Contrato.getText();

            int numItems = totalNum.getItemCount();
            ArrayList<String> numeros = new ArrayList<>();
            for (int i = 0; i < numItems; i++) {
                numeros.add(totalNum.getItemAt(i));
            }

            String rol = (String) Rol.getSelectedItem();

            if (rut.isEmpty() || nombre1.isEmpty() || nombre2.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty() || contrasena.isEmpty() || direccion.isEmpty() || horario.isEmpty() || Integer.toString(salario).isEmpty() || contrato.isEmpty() || numeros.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Rellene los espacios en blanco");
            } else {
                //boolean borrado = new DBEmpleados().eliminar(rutAntiguo, rol);
                boolean aprobado = new DBEmpleados().modificar(rut, nombre1, nombre2, apellido1, apellido2, contrasena, direccion, horario, salario, contrato, numeros, rol, rutIngresado);

                if (aprobado) {
                    JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                    this.dispose();
                    new GUI_Empleado(rutIngresado).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al ingresar los datos a la base de datos");
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El valor del salario ingreselo como numero.\nEjemplo: Para $10.000 ingrese 10000");
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1MouseClicked

    private void Salario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Salario1ActionPerformed

    private void Salario1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Salario1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Salario1KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int index = totalNum.getSelectedIndex();
        if (index != -1) { // -1 significa que no hay selección
            totalNum.removeItemAt(index);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String numero = Numero.getText();
        totalNum.addItem(numero);
        Numero.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                String rut = "";
                String rol = "";
                new GUI_Modificar(rut, rol, rut).setVisible(true);
            }
        });
    }

    private void iniciarDatos(String[] datos) {
        Rut.setText(datos[0]);
        Nombre1.setText(datos[1]);
        Nombre2.setText(datos[2]);
        Apellido1.setText(datos[3]);
        Apellido2.setText(datos[4]);
        Contrasena.setText(datos[5]);
        Direccion.setText(datos[6]);
        Horario.setText(datos[7]);
        Salario1.setText(datos[8]);
        Contrato.setText(datos[9]);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellido1;
    private javax.swing.JTextField Apellido2;
    private javax.swing.JTextField Contrasena;
    private javax.swing.JTextField Contrato;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Horario;
    private javax.swing.JTextField Nombre1;
    private javax.swing.JTextField Nombre2;
    private javax.swing.JTextField Numero;
    private javax.swing.JComboBox<String> Rol;
    private javax.swing.JTextField Rut;
    private javax.swing.JTextField Salario1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> totalNum;
    // End of variables declaration//GEN-END:variables

    private void cargatNum(String[] numero) {
        for (int i = 0; i < numero.length; i++) {
            totalNum.addItem(numero[i]);
        }
    }
}
