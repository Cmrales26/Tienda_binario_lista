/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import static Metodos.Productos.*;
import static Metodos.Agregar_Carrito_al_archivo.*;
import Objetos.Compras;
import Objetos.Producto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Camilo && Diana
 */
public class InterfazAdmin extends javax.swing.JFrame {

    Login lg = new Login();
    DefaultTableModel dtm;
    DefaultTableModel dtmtwo;
    int filas;
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<Compras> compras = new ArrayList<Compras>();
    //Solucion en esta interfaz

    public InterfazAdmin() {
        initComponents();
        jPanel3.setBackground(Color.WHITE);
        btnmodifikr.setVisible(false);
        txtbuscar.setText("Buscar por : Identificación, fecha o usuario");
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //dtmtwo = new DefaultTableModel(20, 7);
        String titu[] = new String[]{"No.Pedido", "Fecha de compra", "Codigo", "Producto", "Cantidad de productos",
            "Precio Total", "Cliente", "Id del cliente"};

        dtmtwo = new DefaultTableModel(titu, 0);
        jTablehistorial.setModel(dtmtwo);
        
        compras = obtener_compras();
        if (productos != null) {
            for (Compras com : compras) {
                Vector vc = obj_vector_compras(com);

                dtmtwo.addRow(vc);
            }
        }

        jTablehistorial.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTablehistorial.getColumnModel().getColumn(0).setPreferredWidth(48);
        jTablehistorial.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTablehistorial.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTablehistorial.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTablehistorial.getColumnModel().getColumn(4).setPreferredWidth(115);
        
        String titulos[] = new String[]{
            "Nombre",
            "Precio",
            "Codigo"
        };
        dtm = new DefaultTableModel(titulos, 0);
        jTableproductos.setModel(dtm);

        productos = obtener_productos();
        if (productos != null) {
            for (Producto e : productos) {
                Vector v = obj_vector(e);

                dtm.addRow(v);
            }
        }
    }

    public Vector obj_vector(Producto e) {
        Vector v = new Vector();
        v.add(e.getProducto());
        v.add(e.getPrecio());
        v.add(e.getCodigo());
        return v;
    }
    public Vector obj_vector_compras(Compras c){
        Vector vc = new Vector();
        vc.add(c.getNo_pedido());
        vc.add(c.getFecha_de_compra());
        vc.add(c.getCodigo_Producto());
        vc.add(c.getProducto());
        vc.add(c.getCantidad_de_productos());
        vc.add(c.getPrecio_Total());
        vc.add(c.getCliente());
        vc.add(c.getId_Cliente());
        return vc;
    }

    void limpiar() {
        txtcodigoproducto.setText("");
        txtnombreproducto.setText("");
        txtprecioproducto.setText("");
    }

    void guardar() {
        boolean existe = false;
        String codigo = txtcodigoproducto.getText();

        for (Producto prd : productos) {
            if (prd.getCodigo().equals(codigo)) {
                existe = true;
            }
        }

        if (existe) {
            JOptionPane.showMessageDialog(this, "El codigo: " + txtcodigoproducto.getText() + " Ya se ecuentra registrado, Porfavor ingrese un nuevo codigo");
        } else {
            Producto pr = new Producto(txtnombreproducto.getText(), txtprecioproducto.getText(), txtcodigoproducto.getText());
            productos.add(pr);
            if (guardarProductos(productos)) {
                dtm.addRow(obj_vector(pr));
                JOptionPane.showMessageDialog(this, "El producto ha sido guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error a la hora de guardar el producto");
            }
        }
    }

    void modicar_producto() {
        int fila;
        fila = jTableproductos.getSelectedRow();
        if (fila != -1) {
            int seguro = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea modificar El  producto: "
                    + jTableproductos.getValueAt(fila, 0) + "Con codigo: " + jTableproductos.getValueAt(fila, 2) + "?",
                    "Modificar Producto", JOptionPane.YES_NO_OPTION);
            switch (seguro) {
                case 0:
                    jTableproductos.setValueAt(txtnombreproducto.getText(), fila, 0);
                    jTableproductos.setValueAt(txtprecioproducto.getText(), fila, 1);
                    jTableproductos.setValueAt(txtcodigoproducto.getText(), fila, 2);

                    productos.get(fila).setProducto(txtnombreproducto.getText());
                    productos.get(fila).setPrecio(txtprecioproducto.getText());
                    productos.get(fila).setCodigo(txtcodigoproducto.getText());

                    if (guardarProductos(productos)) {
                        JOptionPane.showMessageDialog(this, "El producto ha sido guardado");
                        limpiar();
                        txtcodigoproducto.setEditable(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error a la hora de guardar el producto");
                    }

                    break;
                case 1:
                    JOptionPane.showConfirmDialog(this, "No se han realizado cambios en el producto");
                    btnmodifikr.setVisible(false);
                    break;
                default:
                    JOptionPane.showConfirmDialog(this, "No se han realizado cambios en el producto");
                    btnmodifikr.setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Se debe selecionar un producto de la tabla");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableproductos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Codigo = new javax.swing.JLabel();
        txtnombreproducto = new javax.swing.JTextField();
        txtprecioproducto = new javax.swing.JTextField();
        txtcodigoproducto = new javax.swing.JTextField();
        btnagg = new javax.swing.JButton();
        btnmodifikr = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablehistorial = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtbuscarcliente = new javax.swing.JTextField();
        txtbuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interfaz administrador");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tienda.png"))); // NOI18N
        jLabel1.setText("Super tiendas y Almacenes DVMQ ");

        jLabel8.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jLabel8.setText("CERRAR SESIÓN");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 180, 209));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/caja.png"))); // NOI18N
        jLabel2.setText("PRODUTOS");

        jTableproductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableproductosMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableproductos);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/contract.png"))); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/salary.png"))); // NOI18N
        jLabel5.setText("Precio");

        Codigo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Codigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/analysis.png"))); // NOI18N
        Codigo.setText("Codigo");

        btnagg.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnagg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/boton-agregar (1).png"))); // NOI18N
        btnagg.setText("Agregar");
        btnagg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaggActionPerformed(evt);
            }
        });

        btnmodifikr.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnmodifikr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        btnmodifikr.setText("Modificar");
        btnmodifikr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodifikrActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/order.png"))); // NOI18N
        jLabel3.setText("<html>AGREGAR O MODIFICAR UN PRODUCTO<html>");

        jPanel2.setBackground(new java.awt.Color(153, 180, 209));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/folder.png"))); // NOI18N
        jLabel6.setText("ADMIN PANEL - TODOS LOS PRODUCTOS COMPRADOS");

        jTablehistorial.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTablehistorial);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Buscar Cliente ");

        txtbuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtbuscarMouseClicked(evt);
            }
        });
        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 3, 18)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/find.png"))); // NOI18N
        jLabel11.setText("Buscar");

        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*La busqueda del cliente puede tardar unos segundos, si no realiza la busqueda intente nuevamente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtbuscarcliente))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(1569, 1569, 1569)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(btnagg, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(btnmodifikr, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(txtprecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(29, 29, 29)
                                        .addComponent(txtcodigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Codigo)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnmodifikr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnagg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(361, 361, 361)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        int opcion = JOptionPane.showConfirmDialog(this, "¿Esta seguro que desea cerrar sesion?", "Cerrar Seion", JOptionPane.YES_NO_OPTION);
        switch (opcion) {
            case 0:
                Login lg = new Login();
                lg.setVisible(true);
                JOptionPane.showMessageDialog(this, "Sesion Finalizada");
                this.dispose();
                break;
            case 1:
                JOptionPane.showMessageDialog(this, "Continue en la interfaz");
                break;
            default:
                JOptionPane.showMessageDialog(this, "Continue en la interfaz");
        }

    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnaggActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaggActionPerformed
        guardar();
    }//GEN-LAST:event_btnaggActionPerformed

    private void jTableproductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableproductosMouseReleased
        txtnombreproducto.setText(jTableproductos.getValueAt(jTableproductos.getSelectedRow(), 0).toString());
        txtprecioproducto.setText(jTableproductos.getValueAt(jTableproductos.getSelectedRow(), 1).toString());
        txtcodigoproducto.setText(jTableproductos.getValueAt(jTableproductos.getSelectedRow(), 2).toString());
        txtcodigoproducto.setEditable(false);
        jTableproductos.setEnabled(false);
        jTableproductos.setEnabled(true);
        btnmodifikr.setVisible(true);

    }//GEN-LAST:event_jTableproductosMouseReleased

    private void btnmodifikrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodifikrActionPerformed
        txtcodigoproducto.setEditable(true);
        jTableproductos.setEnabled(true);
        modicar_producto();
        btnmodifikr.setVisible(false);
    }//GEN-LAST:event_btnmodifikrActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed


    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased

        //Es posible buscar por: fechas, usuario o id.
        DefaultTableModel dt = (DefaultTableModel) jTablehistorial.getModel();
        String busqueda = txtbuscar.getText();
        TableRowSorter<DefaultTableModel> reader = new TableRowSorter<DefaultTableModel>(dt);
        jTablehistorial.setRowSorter(reader);
        reader.setRowFilter(RowFilter.regexFilter(busqueda));

    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtbuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtbuscarMouseClicked
        txtbuscar.setText("");
    }//GEN-LAST:event_txtbuscarMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Codigo;
    private javax.swing.JButton btnagg;
    private javax.swing.JButton btnmodifikr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablehistorial;
    private javax.swing.JTable jTableproductos;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtbuscarcliente;
    private javax.swing.JTextField txtcodigoproducto;
    private javax.swing.JTextField txtnombreproducto;
    private javax.swing.JTextField txtprecioproducto;
    // End of variables declaration//GEN-END:variables
}
