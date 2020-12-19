
package com.modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        //crear el mensaje...
    	Conexion db_connect= new Conexion();
    	PreparedStatement ps=null;
        ResultSet st=null;
    	try(Connection conexion=db_connect.getConexion()){
            String query="SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            st=ps.executeQuery();
            while(st.next()){
                System.out.println("------------------------");
                System.out.println("ID: "+st.getInt("id_mensaje"));
                System.out.println("Mensaje: "+st.getString("mensaje"));
                System.out.println("Autor: "+st.getString("autor_mensaje"));
                System.out.println("Fecha: "+st.getString("fecha_mensaje"));
                System.out.println("");
            }

    		
                    
        }catch(SQLException e){
            System.out.println("Error-->"+e);	
        }
    }
    
    public static void borrarMensajeDB(int id_mensaje){
            	Conexion db_connect= new Conexion();

    	try(Connection conexion=db_connect.getConexion()){

    		PreparedStatement ps=null;
    		try{
    			String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
    			ps=conexion.prepareStatement(query);
                        ps.setInt(1, id_mensaje);
                        int idCount= ps.executeUpdate();
                        
                        if(idCount!=0){
                        
                        System.out.println("El mensaje ha sido eliminado");
                        }else{
                            System.out.println("El mensaje no ha sido eliminado");
                        }

    		}
    		catch(SQLException ex){
    			System.out.println("Error-->"+ex);	
    		}

    	}catch(SQLException e){

    		System.out.println("Error-->"+e);
    	}
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
         Conexion db_connect= new Conexion();

    	try(Connection conexion=db_connect.getConexion()){
            PreparedStatement ps=null;
            
            try{
            String query="update mensajes set mensaje =? where id_mensaje=?";
            ps=conexion.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setInt(2, mensaje.getId_mensaje());
            int re=ps.executeUpdate();
            if(re!=0){
                System.out.println("Mensaje actualizado correctamente");
            }else{System.out.println("No se actualizo el mensaje");}
            }
            catch(SQLException ex){
                System.out.println("Error--> "+ex);
            }
            
        
    }catch(SQLException e){
            System.out.println("Error--> "+e);
    }
}

}