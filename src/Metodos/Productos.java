/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Objetos.Producto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Camilo && Diana
 */
public class Productos {

    public static final String ruta = "./productos.bin";

    public static boolean guardarProductos(ArrayList<Producto> producto) {
        try {
            FileOutputStream objeto = new FileOutputStream(ruta);
            ObjectOutputStream ob = new ObjectOutputStream(objeto);
            ob.writeObject(producto);
            ob.close();
            objeto.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Producto> obtener_productos() {
        try {
            FileInputStream objeto = new FileInputStream(ruta);
            ObjectInputStream obin = new ObjectInputStream(objeto);

            ArrayList<Producto> e = (ArrayList<Producto>)obin.readObject();

            obin.close();
            objeto.close();

            return e;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
