/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felix
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        
        try (Connection conexion = db_connect.get_connection()){ 
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO mensajes ( mensaje, autor_mensje) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                //store from getmessage to the VALUE 1
                ps.setString(1,mensaje.getMensaje());
                //store from getauthor_message to the VALUE 2
                ps.setString(2, mensaje.getAutor_mensaje());
                //Insertar datos
                ps.executeUpdate();
                System.out.println("mensaje creado");
                  
            }catch(SQLException ex){
                System.out.println(ex);
                
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    public static void leerMensajesDB(){
         
         Conexion db_connect = new Conexion();
         PreparedStatement ps = null;
         ResultSet rs=null;
         try (Connection conexion = db_connect.get_connection()){
             String query="SELECT * FROM mensajes";
             ps=conexion.prepareStatement(query);
             //pedir datos
             rs=ps.executeQuery();
             //while has data it will print
             while(rs.next()){
                 System.out.println("ID: "+ rs.getInt("id_mensaje"));
                 System.out.println("Mensaje: " + rs.getString("Mensaje"));
                 System.out.println("Autor: "+ rs.getString("autor_mensaje"));
                 System.out.println("Fecha: "+ rs.getString("fecha_mensaje"));
                 System.out.println();
             }
    
          }catch(SQLException e){
              System.out.println("no se pudieron recuperar los mensajes");
            System.out.println(e);
        }
    }
    public static void borrarMensajesDB(int id_mensaje){
         Conexion db_connect = new Conexion();
         
         try(Connection conexion = db_connect.get_connection()){
                      PreparedStatement ps = null;
                      
                      try{
                          String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                          ps=conexion.prepareStatement(query);
                          ps.setInt(1,id_mensaje);
                          ps.executeUpdate();
                          System.out.println("El mensaje ha sido borrado");
                      }catch(SQLException e){
                          System.out.println(e);
                          System.out.println("no se pudo borrar el mensaje");

         } }catch(SQLException e){
             System.out.println(e);
        }
    }
    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
                      PreparedStatement ps = null;
                      
                      try{
                          String query=("UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?;");
                          ps=conexion.prepareStatement(query);
                          ps.setString(1, mensaje.getMensaje());
                          ps.setInt(2, mensaje.getId_mensaje());
                          ps.executeUpdate();
                          System.out.println("El mensaje se actualizo correctamente");
                      }catch(SQLException ex){
                          System.out.println(ex);
                          System.out.println("no se actualizo el mensaje");

         } }catch(SQLException e){
             System.out.println(e);
        }
    }
    
}
