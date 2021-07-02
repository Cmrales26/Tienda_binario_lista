/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Frames.InterfazAdmin;
import Objetos.Producto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo && Diana
 */
public class Productos {

    public static final String ruta = "./productos.bin";
    private Nodo_Productos raiz;
    FileOutputStream objeto = null;
    ObjectOutputStream ob = null;
    FileInputStream is = null;
    ObjectInputStream obin = null;
    String nombre;
    String precio;
    String codigo;

    public Productos() {
        raiz = null;
    }

    public boolean guardar_nodo_producto(String nombre, String precio, String codigo) {
        Nodo_Productos nodo;
        nodo = new Nodo_Productos();
        Producto pr = new Producto(nombre, precio, codigo);
        nodo.productos = pr;
        try {
            if (!validar_existencia(pr)) {
                if (raiz == null) {
                    nodo.siguiente = null;
                } else {
                    nodo.siguiente = raiz;
                }
                raiz = nodo;
                raiz = nodo;
                objeto = new FileOutputStream(ruta);
                ob = new ObjectOutputStream(objeto);
                ob.writeObject(nodo);
                ob.close();
                objeto.close();
                JOptionPane.showMessageDialog(null, "Se ha guardado el producto");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El producto ya se encuentra registrado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean validar_existencia(Producto productos) {
        Nodo_Productos nodo;
        nodo = raiz;
        while (nodo != null) {
            if (productos.getCodigo().equals(nodo.productos.getCodigo())) {
                return true;
            }
            nodo = nodo.siguiente;
        }
        return false;
    }
    public Nodo_Productos obtener_nodo_productos(){
        try {
            is = new FileInputStream(ruta);
            obin = new ObjectInputStream(is);
            Nodo_Productos nodo = (Nodo_Productos) obin.readObject();
            is.close();
            obin.close();
            return nodo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void obtener_productos(){
        Nodo_Productos nodo;
        boolean encontrado =false;
        nodo = raiz;
        while(nodo != null){
            nombre = nodo.productos.getProducto();
            precio = nodo.productos.getPrecio();
            codigo = nodo.productos.getCodigo();
            encontrado = true;
            nodo = nodo.siguiente;
        }
        if (encontrado == true) {
            InterfazAdmin ia = new InterfazAdmin(nombre, precio, codigo);
        }else{
            JOptionPane.showMessageDialog(null, "error");
        }
        
    }
}
