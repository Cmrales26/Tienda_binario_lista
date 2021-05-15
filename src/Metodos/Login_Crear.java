/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Metodos.Productos.ruta;
import Objetos.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Camilo && Diana
 */

public class Login_Crear {
    
   public static final String ruta = "./clientes.bin";
   
   public static boolean guardarUsuario(ArrayList<Usuario> usuario){
       try {
           FileOutputStream objeto = new FileOutputStream(ruta);
           ObjectOutputStream ob = new ObjectOutputStream(objeto);
           ob.writeObject(usuario);
           ob.close();
           objeto.close();
           return true;
       } catch (Exception e) {
           e.printStackTrace();
           return false;
       }
   }
   
   public static ArrayList<Usuario> obtener_cliente(){
       try {
            FileInputStream objeto = new FileInputStream(ruta);
            ObjectInputStream obin = new ObjectInputStream(objeto);
            
            ArrayList<Usuario> u = (ArrayList<Usuario>)obin.readObject();
            
            obin.close();
            objeto.close();
            
            return u;
            
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
   }
   
}
