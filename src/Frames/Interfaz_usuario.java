/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Metodos.Agregar_Carrito_al_archivo;
import Metodos.Agregar_productos_al_carrito;
import Objetos.Producto;
import java.util.*;
import static Metodos.Productos.*;
import static Metodos.Agregar_Carrito_al_archivo.*;
import Objetos.Compras;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JLabel;

/**
 *
 * @author Camilo && Diana
 */
public class Interfaz_usuario extends javax.swing.JFrame {

    DefaultTableModel dtm;
    DefaultTableModel dtm_historial;
    String usuario, id;
    int numero_pedido;
    int consecutivo_final;
    int fila = 0;
    String Fecha = Agregar_productos_al_carrito.agregar_fecha();
    Agregar_Carrito_al_archivo ag = new Agregar_Carrito_al_archivo();
    Agregar_productos_al_carrito ac = new Agregar_productos_al_carrito();
//    Agregar_compras_historial_Clientes agregar_historial = new Agregar_compras_historial_Clientes();
//    Modificar_historial_cliente modificar_historial = new Modificar_historial_cliente();
    int precioUnitario;
    String Preciototal;
    String codigoProducto;
    ArrayList<Producto> productos = new ArrayList<Producto>();
    ArrayList<Compras> compras = new ArrayList<Compras>();

    public Interfaz_usuario(String usuario, String id) {
        initComponents();
        Color color = new Color(255, 153, 153);
        jPanel1.setBackground(color);
        jPanel2.setBackground(Color.WHITE);
        jPanel3.setBackground(color);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.usuario = usuario;
        this.id = id;
        btnmodificarhistorial.setVisible(false);
        Cambiar_valores_en_el_archivo.setVisible(false);
        btnvolveracompras.setVisible(false);
        jLabel5.setVisible(false);
        jLabel7.setVisible(false);
        txtnuevonumerocompra.setVisible(false);
        jLabel8.setVisible(false);
        txtnuevocodpro.setVisible(false);
        jLabel9.setVisible(false);
        txtnuevoproducto.setVisible(false);
        jLabel11.setVisible(false);
        txtnuevoprecio4.setVisible(false);

        String titulos[] = new String[]{
            "No.Pedido",
            "Fecha de compra",
            "Codigo",
            "Producto",
            "Numero de productos",
            "Precio Total",
            "Cliente",
            "Id del cliente"
        };
        dtm = new DefaultTableModel(titulos, 1);
        jTableCarrito.setModel(dtm);
        jTableCarrito.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableCarrito.getColumnModel().getColumn(0).setPreferredWidth(48);
        jTableCarrito.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableCarrito.getColumnModel().getColumn(2).setPreferredWidth(30);
        jTableCarrito.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTableCarrito.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableCarrito.setValueAt(usuario, 0, 6); // Agrega el usuario
        jTableCarrito.setValueAt(id, 0, 7); // Agrega la id
        jTableCarrito.setValueAt(Fecha, 0, 1); // Agrega la fecha

        compras = obtener_compras();
        productos = obtener_productos();
        if (productos != null) {
            for (Producto p : productos) {
                jComboproductos.addItem(p.getProducto());
            }
        }

        for (Compras cmp : compras) {
            numero_pedido = Integer.parseInt(cmp.getNo_pedido());
        }

    }

    public void Agregar_consecutivo() {
        numero_pedido++;
    }

    public void restar_consecutivo() {
        numero_pedido--;
    }

    public void agregar_carrito() {
        if (!txtnumerodeproductos.getText().equals("0")) {
            if (!txtnumerodeproductos.getText().equalsIgnoreCase("")) {
                int num_productos = Integer.parseInt(txtnumerodeproductos.getText());
                for (Producto prd : productos) {
                    if (prd.getProducto().equals(jComboproductos.getSelectedItem().toString())) {
                        precioUnitario = Integer.parseInt(prd.getPrecio());
                        Preciototal = Integer.toString(precioUnitario * num_productos);
                        codigoProducto = prd.getCodigo();
                    }
                }
                jTableCarrito.setValueAt(codigoProducto, fila, 2);//Agrega el codifo del producto al carrito
                jTableCarrito.setValueAt(Preciototal, fila, 5);//Agregar Precio a la tabla
                jTableCarrito.setValueAt(jComboproductos.getSelectedItem().toString(), fila, 3);//Agrega el nombre del producto
                jTableCarrito.setValueAt(txtnumerodeproductos.getText(), fila, 4); //Agrega el numero de producto
                jTableCarrito.setValueAt(usuario, fila, 6); // Agrega el usuario
                jTableCarrito.setValueAt(id, fila, 7); // Agrega la id
                jTableCarrito.setValueAt(Fecha, fila, 1); // Agrega la fecha
                Agregar_consecutivo();
                jTableCarrito.setValueAt(Integer.toString(numero_pedido), fila, 0);
                fila++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe Ingresar Al menos Un prodcuto para realizar la compra");
            }
        } else {

            JOptionPane.showMessageDialog(this, "Sólo se admiten numeros mayores a 0");
        }

    }

    public void modificar_Carrito() {
        if (jTableCarrito.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una fila con valores para poder editar");
        } else {
            jTableCarrito.setValueAt(txtnumerodeproductos.getText(), jTableCarrito.getSelectedRow(), 4);
            jTableCarrito.setValueAt(jComboproductos.getSelectedItem().toString(), jTableCarrito.getSelectedRow(), 3);
            int num_productos = Integer.parseInt(txtnumerodeproductos.getText());
            for (Producto prd : productos) {
                if (prd.getProducto().equals(jComboproductos.getSelectedItem().toString())) {
                    precioUnitario = Integer.parseInt(prd.getPrecio());
                    Preciototal = Integer.toString(precioUnitario * num_productos);
                    codigoProducto = prd.getCodigo();
                }
            }
            jTableCarrito.setValueAt(codigoProducto, jTableCarrito.getSelectedRow(), 2);//Agrega el codifo del producto al carrito
            jTableCarrito.setValueAt(Preciototal, jTableCarrito.getSelectedRow(), 5);//Agregar Precio a la tabla
//          
        }
    }

    public void eliminar() {
        if (jTableCarrito.getSelectedRow() == 0) {
            JOptionPane.showMessageDialog(this, "No es posible eliminar esta fila debido a que debe haber mínimo un producto para realizar la compra");
        } else {
            dtm.removeRow(jTableCarrito.getSelectedRow());
            fila--;
            restar_consecutivo();
        }
    }

    public void realizar_compra() {
        int i;
        String no_pedido, fecha_de_compra, codigo, producto, numero, precio, cliente, id_;
        for (i = 0; i < jTableCarrito.getRowCount(); i++) {
            no_pedido = jTableCarrito.getValueAt(i, 0).toString();
            fecha_de_compra = jTableCarrito.getValueAt(i, 1).toString();
            codigo = jTableCarrito.getValueAt(i, 2).toString();
            producto = jTableCarrito.getValueAt(i, 3).toString();
            numero = jTableCarrito.getValueAt(i, 4).toString();
            precio = jTableCarrito.getValueAt(i, 5).toString();
            cliente = jTableCarrito.getValueAt(i, 6).toString();
            id_ = jTableCarrito.getValueAt(i, 7).toString();
            Compras cmp = new Compras(no_pedido, fecha_de_compra, codigo, producto, numero, precio, cliente, id_);
            compras.add(cmp);
            if (guardar_compra(compras)) {
            } else {
                JOptionPane.showMessageDialog(this, "Ha Ocurrido un error al realizar la compra");
            }
        }
        JOptionPane.showMessageDialog(this, "La compra Se ha realizado con Exito");
    }

    public void crear_nuevo_modelo() {
        String titulos_historial[] = new String[]{
            "No.Pedido",
            "Fecha de compra",
            "Codigo",
            "Producto",
            "Numero de productos",
            "Precio Total",
            "Cliente",
            "Id cliente"
        };
        dtm_historial = new DefaultTableModel(titulos_historial, 0);
        jTableCarrito.setModel(dtm_historial);
    }

    public void agregar_al_instorial() {
        for (Compras cm : compras) {
            if (cm.getId_Cliente().equalsIgnoreCase(id)) {
                Vector v = obj_vector_compras(cm);
                dtm_historial.addRow(v);
            }
        }
    }

    public Vector obj_vector_compras(Compras c) {
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

    public void modificar_historial() {
        if (jTableCarrito.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debe selecionar una fila con valores para poder editar");
        } else {
            jLabel12.setForeground(Color.red);
            jLabel12.setText("<html>En la parte superior se encuentran los cambios que se realizaran sobre su compra, "
                    + "si está seguro de realizar los cambios presione MODIFICAR EN EL ARCHIVO, si no lo está continúe "
                    + "modificando su producto<html>");
            jTableCarrito.setValueAt(txtnumerodeproductos.getText(), jTableCarrito.getSelectedRow(), 4);
            txtnumerodeproductos.setText(txtnumerodeproductos.getText());
            jTableCarrito.setValueAt(jComboproductos.getSelectedItem().toString(), jTableCarrito.getSelectedRow(), 3);
            txtnuevoproducto.setText(jComboproductos.getSelectedItem().toString());
            int numero_de_productos = Integer.parseInt(txtnumerodeproductos.getText());
            for (Producto prd : productos) {
                if (prd.getProducto().equals(jComboproductos.getSelectedItem().toString())) {
                    precioUnitario = Integer.parseInt(prd.getPrecio());
                    Preciototal = Integer.toString(precioUnitario * numero_de_productos);
                    codigoProducto = prd.getCodigo();
                }
            }
            jTableCarrito.setValueAt(codigoProducto, jTableCarrito.getSelectedRow(), 2);
            jTableCarrito.setValueAt(Preciototal, jTableCarrito.getSelectedRow(), 5);
            txtnuevonumerocompra.setText(jTableCarrito.getValueAt(jTableCarrito.getSelectedRow(), 0).toString());
            txtnuevocodpro.setText(codigoProducto);
            txtnuevoprecio4.setText(Preciototal);
            Cambiar_valores_en_el_archivo.setVisible(true);
            Cambiar_valores_en_el_archivo.setEnabled(true);
        }
    }

    public void actualizar_historial() {
        String numero_compras = txtnuevonumerocompra.getText();
        int seguridad_modificar = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea modificar este pedido", "Modificar pedido", JOptionPane.YES_NO_OPTION);
        if (seguridad_modificar == 0) {
            for (Compras com : compras) {
                if (com.getNo_pedido().equals(numero_compras)) {
                    com.setNo_pedido(numero_compras);
                    com.setCodigo_Producto(txtnuevocodpro.getText());
                    com.setProducto(txtnuevoproducto.getText());
                    com.setCantidad_de_productos(jTableCarrito.getValueAt(jTableCarrito.getSelectedRow(), 4).toString());
                    com.setPrecio_Total(txtnuevoprecio4.getText());
                }
            }
            if (guardar_compra(compras)) {
                JOptionPane.showMessageDialog(this, "El producto ha sido modificado");
            } else {
                JOptionPane.showMessageDialog(this, "Ocurrio un error al modificar el producto");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Continúe modificando su porducto");
        }
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnagregarcarrito = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtnuevoprecio4 = new javax.swing.JTextField();
        txtnuevonumerocompra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnuevocodpro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnuevoproducto = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCarrito = new javax.swing.JTable();
        btnmodificarcarrito = new javax.swing.JButton();
        btneliminarcarrito = new javax.swing.JButton();
        btnrealizarcompra = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnvolveracompras = new javax.swing.JButton();
        Cambiar_valores_en_el_archivo = new javax.swing.JButton();
        btnmodificarhistorial = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboproductos = new javax.swing.JComboBox<>();
        txtnumerodeproductos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interfaz usuario");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/tienda.png"))); // NOI18N
        jLabel1.setText("Super tiendas y Almacenes DVMQ");

        btnagregarcarrito.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnagregarcarrito.setText("AGREGAR AL CARRITO 🛒");
        btnagregarcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarcarritoActionPerformed(evt);
            }
        });

        txtnuevoprecio4.setEditable(false);

        txtnuevonumerocompra.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("NUEVO PRECIO");

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("NUMERO DE LA COMPRA");

        txtnuevocodpro.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NUEVO CODIGO DE PRODUCTO");

        txtnuevoproducto.setEditable(false);
        txtnuevoproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnuevoproductoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("NUEVO PRODUCTO");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CAMBIOS QUE SE REALIZARÁN");

        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("<html>SELECIONE UN PRODUCTO AGREGE AL CARRITO Y TERMINE SU COMPRA 🎆<html>");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(txtnuevonumerocompra, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(txtnuevoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addComponent(txtnuevocodpro, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(50, 50, 50)
                                    .addComponent(txtnuevoprecio4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnuevonumerocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnuevocodpro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txtnuevoproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnuevoprecio4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTableCarrito.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableCarrito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableCarritoMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableCarrito);

        btnmodificarcarrito.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnmodificarcarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/order.png"))); // NOI18N
        btnmodificarcarrito.setText("MODIFICAR");
        btnmodificarcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarcarritoActionPerformed(evt);
            }
        });

        btneliminarcarrito.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btneliminarcarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delete.png"))); // NOI18N
        btneliminarcarrito.setText("ELIMINAR");
        btneliminarcarrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarcarritoActionPerformed(evt);
            }
        });

        btnrealizarcompra.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnrealizarcompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/delivered.png"))); // NOI18N
        btnrealizarcompra.setText("REALIZAR COMPRA");
        btnrealizarcompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrealizarcompraActionPerformed(evt);
            }
        });

        btnHistorial.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vista.png"))); // NOI18N
        btnHistorial.setText("VER EL HISTORIAL DE COMPRAS");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnvolveracompras.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        btnvolveracompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/regreso.png"))); // NOI18N
        btnvolveracompras.setText("VOLVER A LA INTERFAZ DE COMPRAS");
        btnvolveracompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolveracomprasActionPerformed(evt);
            }
        });

        Cambiar_valores_en_el_archivo.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        Cambiar_valores_en_el_archivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exchange.png"))); // NOI18N
        Cambiar_valores_en_el_archivo.setText("REALIZAR LOS CAMBIOS EN EL ARCHIVO");
        Cambiar_valores_en_el_archivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cambiar_valores_en_el_archivoActionPerformed(evt);
            }
        });

        btnmodificarhistorial.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        btnmodificarhistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/order.png"))); // NOI18N
        btnmodificarhistorial.setText("MODIFICAR");
        btnmodificarhistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodificarhistorialActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Seleccione el producto que desea comprar");

        jLabel4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("¿Cuantos desea llevar?");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/caja.png"))); // NOI18N
        jLabel2.setText("PRODUCTOS");

        txtnumerodeproductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnumerodeproductosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnumerodeproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnagregarcarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(btnvolveracompras)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnmodificarcarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btneliminarcarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(214, 214, 214)
                                    .addComponent(btnrealizarcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnmodificarhistorial, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Cambiar_valores_en_el_archivo))))
                            .addComponent(btnHistorial))
                        .addGap(0, 34, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnumerodeproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnagregarcarrito)
                        .addGap(43, 43, 43)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnrealizarcompra)
                            .addComponent(btnmodificarcarrito)
                            .addComponent(btneliminarcarrito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnmodificarhistorial)
                            .addComponent(Cambiar_valores_en_el_archivo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHistorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvolveracompras)))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Configurar Perfil👤");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnagregarcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarcarritoActionPerformed
        dtm.setRowCount(fila + 1);
        agregar_carrito();
    }//GEN-LAST:event_btnagregarcarritoActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        crear_nuevo_modelo();
        agregar_al_instorial();
        btnmodificarcarrito.setVisible(false);
        btneliminarcarrito.setVisible(false);
        btnrealizarcompra.setVisible(false);
        btnHistorial.setVisible(false);
        btnagregarcarrito.setVisible(false);
        btnmodificarhistorial.setVisible(true);
        btnvolveracompras.setVisible(true);
        jLabel5.setVisible(true);
        jLabel7.setVisible(true);
        txtnuevonumerocompra.setVisible(true);
        jLabel8.setVisible(true);
        txtnuevocodpro.setVisible(true);
        jLabel9.setVisible(true);
        txtnuevoproducto.setVisible(true);
        jLabel11.setVisible(true);
        txtnuevoprecio4.setVisible(true);
        jLabel12.setForeground(Color.red);
        jLabel12.setText("<html>Escoja de la lista el producto que desea modificar, luego seleccione el producto nuevo que quiera y escriba la cantidad. *SÓLO SE PUEDE MODIFICAR UN PRODUCTO A LA VEZ* :)<html>");
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked

        String[] botones = {"Editar perfil ", "Cerrar Sesión", "Cancelar"};
        int Mensaje = JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Configuración del perfil", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
        switch (Mensaje) {
            case 0:
                Modificar_cuenta mc = new Modificar_cuenta(jTableCarrito.getValueAt(0, 7).toString());
                mc.setVisible(true);
                this.dispose();
                break;
            case 1:
                Login lg = new Login();
                lg.setVisible(true);
                this.dispose();
                break;
            case 2:
            default:
                break;
        }

    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnrealizarcompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrealizarcompraActionPerformed
        realizar_compra();
        JOptionPane.showMessageDialog(this, "La compra se ha realizado con éxito, visite el historial para modificar");
        this.dispose();
        Interfaz_usuario ia = new Interfaz_usuario(usuario, id);
        ia.setVisible(true);
    }//GEN-LAST:event_btnrealizarcompraActionPerformed

    private void jTableCarritoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCarritoMouseReleased
        txtnumerodeproductos.setText(jTableCarrito.getValueAt(jTableCarrito.getSelectedRow(), 4).toString());
        jLabel12.setForeground(Color.red);
        jLabel12.setText("<html>En el campo superior modifique a su gusto el producto y presione MODIFICAR<html>");
    }//GEN-LAST:event_jTableCarritoMouseReleased

    private void btnmodificarcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarcarritoActionPerformed
        modificar_Carrito();
    }//GEN-LAST:event_btnmodificarcarritoActionPerformed

    private void btneliminarcarritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarcarritoActionPerformed
        eliminar();
    }//GEN-LAST:event_btneliminarcarritoActionPerformed

    private void btnvolveracomprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolveracomprasActionPerformed
        this.dispose();
        Interfaz_usuario ia = new Interfaz_usuario(usuario, id);
        ia.setVisible(true);
    }//GEN-LAST:event_btnvolveracomprasActionPerformed

    private void Cambiar_valores_en_el_archivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cambiar_valores_en_el_archivoActionPerformed
        actualizar_historial();
        jLabel12.setForeground(Color.red);
        jLabel12.setText("<html>Escoja de la lista el producto que desea modificar, luego seleccione el producto nuevo que quiera y escriba la cantidad. *SÓLO SE PUEDE MODIFICAR UN PRODUCTO A LA VEZ* :)<html>");
        txtnuevonumerocompra.setText(" ");
        txtnuevoproducto.setText(" ");
        txtnuevoprecio4.setText(" ");
        txtnuevocodpro.setText(" ");
        Cambiar_valores_en_el_archivo.setVisible(false);
    }//GEN-LAST:event_Cambiar_valores_en_el_archivoActionPerformed

    private void btnmodificarhistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodificarhistorialActionPerformed
        modificar_historial();
    }//GEN-LAST:event_btnmodificarhistorialActionPerformed

    private void txtnuevoproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnuevoproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnuevoproductoActionPerformed

    private void txtnumerodeproductosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumerodeproductosKeyTyped
        char validad = evt.getKeyChar();
        if (Character.isLetter(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "Sólo se adminten numeros mayores a 0");
        }
        if (Character.isSpaceChar(validad)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(this, "No se admiten espacios");
        }
    }//GEN-LAST:event_txtnumerodeproductosKeyTyped

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cambiar_valores_en_el_archivo;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnagregarcarrito;
    private javax.swing.JButton btneliminarcarrito;
    private javax.swing.JButton btnmodificarcarrito;
    private javax.swing.JButton btnmodificarhistorial;
    private javax.swing.JButton btnrealizarcompra;
    private javax.swing.JButton btnvolveracompras;
    private javax.swing.JComboBox<String> jComboproductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCarrito;
    private javax.swing.JTextField txtnuevocodpro;
    private javax.swing.JTextField txtnuevonumerocompra;
    private javax.swing.JTextField txtnuevoprecio4;
    private javax.swing.JTextField txtnuevoproducto;
    private javax.swing.JTextField txtnumerodeproductos;
    // End of variables declaration//GEN-END:variables
}
