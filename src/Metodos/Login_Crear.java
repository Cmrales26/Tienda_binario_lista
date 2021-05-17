/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Frames.InterfazAdmin;
import Frames.Interfaz_usuario;
import Frames.Login;
import Frames.Modificar_cuenta;
import Objetos.Usuario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo && Diana
 */
public class Login_Crear {

    public static final String ruta = "./clientes.bin";
    private Nodo_persona raiz;
    FileOutputStream objeto = null;
    ObjectOutputStream ob = null;
    FileInputStream is = null;
    ObjectInputStream obin = null;
    String ID;
    String usuario;
    String tipo;
    String nombre;
    String apellido;
    String mail;
    String contraseña;
    String numero_de_telefono;

    public Login_Crear() {
        raiz = Obtener_nodo_usuario();
    }

    public boolean guardar_nodo_usuario(String usuario, String nombre, String apellido, String email, String contrasena, String telefono, String id) {
        Nodo_persona nodo;
        nodo = new Nodo_persona();
        Usuario cl = new Usuario(usuario, nombre, apellido, email, contrasena, telefono, id, "cliente");
        nodo.usuario = cl;
        try {
            if (!Validar_existencia(cl)) {
                if (raiz == null) {
                    nodo.siguiente = null;
                } else {
                    nodo.siguiente = raiz;
                }
                raiz = nodo;
                objeto = new FileOutputStream(ruta);
                ob = new ObjectOutputStream(objeto);
                ob.writeObject(nodo);
                ob.close();
                objeto.close();
                JOptionPane.showMessageDialog(null, "El usuario se guardo");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El usuario Ya existe");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public boolean Validar_existencia(Usuario cliente) {
        Nodo_persona nodo;
        nodo = raiz;
        while (nodo != null) {
            if (cliente.getUsuario().equalsIgnoreCase(nodo.usuario.getUsuario())
                    || cliente.getNumeroIdentificacion().equalsIgnoreCase(nodo.usuario.getNumeroIdentificacion())) {
                return true;
            }
            nodo = nodo.siguiente;
        }
        return false;
    }

    public Nodo_persona Obtener_nodo_usuario() {
        try {
            is = new FileInputStream(ruta);
            obin = new ObjectInputStream(is);
            Nodo_persona nodo = (Nodo_persona) obin.readObject();
            is.close();
            obin.close();
            return nodo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //INGRESAR 
    public boolean Validar_existencia_ingresar(Usuario cliente) {
        Nodo_persona nodo;
        boolean existe = false;
        nodo = raiz;
        while (nodo != null) {
            if (cliente.getUsuario().equalsIgnoreCase(nodo.usuario.getUsuario())
                    && cliente.getContrasena().equalsIgnoreCase(nodo.usuario.getContrasena())) {
                ID = nodo.usuario.getNumeroIdentificacion();
                tipo = nodo.usuario.getTipo_Usuario();
                usuario = cliente.getUsuario();
                existe = true;
            }
            nodo = nodo.siguiente;
        }
        if (existe == true && tipo.equalsIgnoreCase("cliente")) {

            Interfaz_usuario iu = new Interfaz_usuario(usuario, ID);
            iu.setVisible(true);
        } else if (existe == true && tipo.equalsIgnoreCase("admin")) {
            InterfazAdmin ia = new InterfazAdmin();
            ia.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario No se encuentra Registrado");
        }
        return false;
    }
//    MODIFICAR CUENTA

    public void Obtener_Modificar(Usuario cliente) {
        Nodo_persona nodo;
        boolean encontrado = false;
        nodo = raiz;
        while (nodo != null) {
            if (cliente.getNumeroIdentificacion().equalsIgnoreCase(nodo.usuario.getNumeroIdentificacion())) {
                usuario = nodo.usuario.getUsuario();
                nombre = nodo.usuario.getNombre();
                apellido = nodo.usuario.getApellido();
                mail = nodo.usuario.getEmail();
                contraseña = nodo.usuario.getContrasena();
                numero_de_telefono = nodo.usuario.getNumeroTelefonico();
                ID = nodo.usuario.getNumeroIdentificacion();
                encontrado = true;
            }
            nodo = nodo.siguiente;
        }
        if (encontrado == true) {
            Modificar_cuenta mc = new Modificar_cuenta(ID, usuario, nombre, apellido, mail, contraseña, numero_de_telefono);
            mc.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "UN ERROR HA OCURRIDO CON EXITO");
        }
    }
    
    public void modificar(){
        
    }
}
