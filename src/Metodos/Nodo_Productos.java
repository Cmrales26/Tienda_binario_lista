/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import Objetos.Producto;
import java.io.Serializable;

/**
 *
 * @author Camilo
 */
public class Nodo_Productos implements Serializable{
    Producto productos;
    Nodo_Productos siguiente;
}
