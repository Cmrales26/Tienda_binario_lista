/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 *
 * @author Camilo && Diana
 */
public class Agregar_productos_al_carrito {

    static String Fecha;
    static int Consecutivo;
    static int Consecutivo_final;

    public static String agregar_fecha() { // METODO ENCARGADO DE AGREGAR A LA TABLA LA FECHA ACUTUAL
        Calendar c = Calendar.getInstance();
        String dia = Integer.toString(c.get(Calendar.DATE));
        int mesint = c.MONTH + 1;
        String año = Integer.toString(c.get(Calendar.YEAR));
        String mes = Integer.toString(mesint);
        return Fecha = (dia + " / " + mes + " / " + año);

    }
}
