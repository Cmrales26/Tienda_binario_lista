/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Objetos.Usuario;
import static Metodos.Login_Crear.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static Frames.Interfaz_usuario.*;

/**
 *
 * @author Camilo && Diana
 */
public class Modificar_cuenta extends javax.swing.JFrame {

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    public static String ID;
    final String usuario_viejo;
    String usuario;
    String apellido;
    String numero_de_telefono;
    String nombre;
    String mail;
    String contraseña;

    public Modificar_cuenta(String id) {
        initComponents();
        this.setLocationRelativeTo(this);
        ID = id;
        txtidentificacion.setEditable(false);
        usuarios = obtener_cliente();
        if (usuarios != null) {
            for (Usuario u : usuarios) {
                if (u.getNumeroIdentificacion().equals(ID)) {
                    usuario = u.getUsuario();
                    apellido = u.getApellido();
                    numero_de_telefono = u.getNumeroTelefonico();
                    nombre = u.getNombre();
                    mail = u.getEmail();
                    contraseña = u.getContrasena();
                }
            }
            txtuser.setText(usuario);
            txtnombre.setText(nombre);
            txtapellido.setText(apellido);
            txtmail.setText(mail);
            txttelefono.setText(numero_de_telefono);
            txtidentificacion.setText(ID);
            txtpass.setText(contraseña);
        }
        usuario_viejo = txtuser.getText();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        btnactualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interfaz  modificar cuenta");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(750, 558));
        setPreferredSize(new java.awt.Dimension(700, 469));
        setSize(new java.awt.Dimension(0, 0));

        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombreKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nombre");

        txtapellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtapellidoKeyTyped(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 204, 204));
        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Apellido");

        txtmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmailKeyTyped(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 204, 204));
        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 0, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("E-Mail");

        txtidentificacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidentificacionKeyTyped(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 204, 204));
        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html>Número de Identificacíon<html>");

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpassKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 204, 204));
        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");

        jLabel7.setBackground(new java.awt.Color(255, 204, 204));
        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Contraseña");

        txtuser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtuserKeyTyped(evt);
            }
        });

        btnactualizar.setBackground(new java.awt.Color(51, 0, 51));
        btnactualizar.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnactualizar.setForeground(new java.awt.Color(153, 153, 153));
        btnactualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/proceso.png"))); // NOI18N
        btnactualizar.setText("ACTUALIZAR DATOS");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modificar cuenta👤");

        jLabel8.setBackground(new java.awt.Color(255, 204, 204));
        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>Numero de Telefono<html>");

        txttelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttelefonoKeyTyped(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/super.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel5)
                .addGap(66, 66, 66)
                .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(232, 232, 232)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(420, 420, 420)
                .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(txtidentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(btnactualizar))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        String usuario_nuevo = txtuser.getText();
        String apellido_nuevo = txtapellido.getText();
        String numero_de_telefono_nuevo = txttelefono.getText();
        String nombre_nuevo = txtnombre.getText();
        String mail_nuevo = txtmail.getText();
        String contraseña_nuevo = txtpass.getText();
        boolean existe = false;
        for (Usuario us : usuarios) {
            if (us.getUsuario().equalsIgnoreCase(usuario_nuevo) && !usuario_nuevo.equals(usuario_viejo)) {
                existe = true;
            }
        }

        int modificar = JOptionPane.showConfirmDialog(this, "Está seguro que desea realizar los cambios", "Modificar datos",
                JOptionPane.YES_NO_CANCEL_OPTION);
        switch (modificar) {
            case 0:
                if (existe) {
                    JOptionPane.showMessageDialog(this, "El usuario: " + usuario_nuevo + " Ya se encuentra Registrado");
                    txtuser.setText(usuario_viejo);
                } else {
                    if (!txtuser.getText().equals("") && !txtnombre.getText().equals("") && !txtapellido.getText().equals("")
                            && !txtmail.getText().equals("") && !txtidentificacion.getText().equals("") && 
                            !txttelefono.getText().equals("") && !txtpass.getText().equals("")) {
                        JOptionPane.showMessageDialog(this, "Sus datos se han actializado correctamente");
                        for (Usuario u : usuarios) {
                            if (u.getNumeroIdentificacion().equals(ID)) {
                                u.setUsuario(usuario_nuevo);
                                u.setNombre(nombre_nuevo);
                                u.setApellido(apellido_nuevo);
                                u.setEmail(mail_nuevo);
                                u.setContrasena(contraseña_nuevo);
                                u.setNumeroTelefonico(numero_de_telefono_nuevo);
                                u.setNumeroIdentificacion(ID);
                            }
                        }
                        if (guardarUsuario(usuarios)) {
                            JOptionPane.showMessageDialog(this, "EL Usuario Se ha actualizado con Exito");
                        } else {
                            JOptionPane.showMessageDialog(this, "Ha Ocurrido Un error al Actualizar el Usuario");
                        }

                        this.dispose();
                        Interfaz_usuario ia = new Interfaz_usuario(usuario_nuevo, ID);
                        ia.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Se encuentran espacios en blanco");
                    }
                }
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Puede seguir realizando sus cambios");
                 txtuser.setText(usuario_viejo);
                break;
            case 2:
                this.dispose();
                Interfaz_usuario ia = new Interfaz_usuario(usuario_viejo, ID);
                ia.setVisible(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void txtuserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtuserKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txtuserKeyTyped

    private void txtnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txtnombreKeyTyped

    private void txtapellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtapellidoKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txtapellidoKeyTyped

    private void txtmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txtmailKeyTyped

    private void txttelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttelefonoKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txttelefonoKeyTyped

    private void txtidentificacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidentificacionKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txtidentificacionKeyTyped

    private void txtpassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "NO SE PERMITEN ESPACIOS");
        }
    }//GEN-LAST:event_txtpassKeyTyped

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtidentificacion;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
