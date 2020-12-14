
package com.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
//import com.modelo.Conexion;

public class MensajeDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
    	//crear el mensaje...
    	Conexion db_connect= new Conexion();

    	try(Connection conexion=db_connect.getConexion()){

    		PreparedStatement ps=null;
    		try{
    			String query="INSERT INTO mensajes (mensaje,autor_mensaje) VALUES (?,?)";
    			ps=conexion.prepareStatement(query);
                                
    			ps.setString(1,mensaje.getMensaje());
    			ps.setString(2,mensaje.getAutor_mensaje());
    			ps.executeUpdate();
    			System.out.println("Mensaje creado");

    		}
    		catch(SQLException ex){
    			System.out.println("Error-->"+ex);	
    		}

    	}catch(SQLException e){

    		System.out.println("Error-->"+e);
    	}

    }
    
    public static void leerMensajesDB(){
    }
    
    public static void borrarMensajeDB(int id_mensaje){
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
    }
}
