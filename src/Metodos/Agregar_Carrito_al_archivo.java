/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.Productos.ruta;
import Objetos.Compras;
import Objetos.Producto;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Camilo && Diana
 */
public class Agregar_Carrito_al_archivo {
    public static final String ruta = "./compras.bin";
    
    public static boolean guardar_compra(ArrayList<Compras>compras){
           try {
            FileOutputStream objeto = new FileOutputStream(ruta);
            ObjectOutputStream ob = new ObjectOutputStream(objeto);
            ob.writeObject(compras);
            ob.close();
            objeto.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static ArrayList<Compras> obtener_compras(){
           try {
            FileInputStream objeto = new FileInputStream(ruta);
            ObjectInputStream obin = new ObjectInputStream(objeto);

            ArrayList<Compras> cm = (ArrayList<Compras>)obin.readObject();

            obin.close();
            objeto.close();

            return cm;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
