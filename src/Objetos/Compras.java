/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.Serializable;

/**
 *
 * @author Diana
 */
public class Compras implements Serializable{
    private String No_pedido;
    private String Fecha_de_compra;
    private String Codigo_Producto;
    private String Producto;
    private String Cantidad_de_productos;
    private String Precio_Total;
    private String Cliente;
    private String Id_Cliente;

    public Compras(String No_pedido, String Fecha_de_compra, String Codigo_Producto, String Producto, String Cantidad_de_productos, String Precio_Total, String Cliente, String Id_Cliente) {
        this.No_pedido = No_pedido;
        this.Fecha_de_compra = Fecha_de_compra;
        this.Codigo_Producto = Codigo_Producto;
        this.Producto = Producto;
        this.Cantidad_de_productos = Cantidad_de_productos;
        this.Precio_Total = Precio_Total;
        this.Cliente = Cliente;
        this.Id_Cliente = Id_Cliente;
    }

    public Compras() {
    }

    public String getNo_pedido() {
        return No_pedido;
    }

    public void setNo_pedido(String No_pedido) {
        this.No_pedido = No_pedido;
    }

    public String getFecha_de_compra() {
        return Fecha_de_compra;
    }

    public void setFecha_de_compra(String Fecha_de_compra) {
        this.Fecha_de_compra = Fecha_de_compra;
    }

    public String getCodigo_Producto() {
        return Codigo_Producto;
    }

    public void setCodigo_Producto(String Codigo_Producto) {
        this.Codigo_Producto = Codigo_Producto;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getCantidad_de_productos() {
        return Cantidad_de_productos;
    }

    public void setCantidad_de_productos(String Cantidad_de_productos) {
        this.Cantidad_de_productos = Cantidad_de_productos;
    }

    public String getPrecio_Total() {
        return Precio_Total;
    }

    public void setPrecio_Total(String Precio_Total) {
        this.Precio_Total = Precio_Total;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }
    
}
