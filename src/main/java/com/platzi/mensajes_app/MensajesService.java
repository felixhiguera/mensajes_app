/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author felix
 */
public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("tu nombre");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajeDB(registro);
        
    }
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    public static void borrarMensajes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensajesDB(id_mensaje);
    }
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
         System.out.println("Indica el mensaje a actualizar");
            String mensaje = sc.nextLine();
          
           System.out.println("Indica el ID del mensaje a actualizar");
            int id_mensaje = sc.nextInt();
            
            Mensajes actualizacion = new Mensajes();
            actualizacion.setId_mensaje(id_mensaje);
            actualizacion.setMensaje(mensaje);
            MensajesDAO.actualizarMensajeDB(actualizacion);
          
    }
    
}
