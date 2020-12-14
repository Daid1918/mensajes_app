
package com.modelo;
import java.util.Scanner;
import com.modelo.MensajeService;

public class MensajeService {
 
    public static void crearMensaje(){
    	Scanner sc=new Scanner(System.in);

    	System.out.println("Escribe tu mensaje");
    	String mensaje=sc.nextLine();

    	System.out.println("Escribe tu nombre");
    	String nombre=sc.nextLine();

    	Mensajes r=new Mensajes();

    	r.setMensaje(mensaje);
    	r.setAutor_mensaje(nombre);

    	MensajeDAO.crearMensajeDB(r);


    }
    
    public static void listarMensajes(){
    }
    
    public static void borrarMensaje(){
    }
    
    public static void editarMensaje(){
    }
}
