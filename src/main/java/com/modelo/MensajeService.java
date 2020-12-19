
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
        MensajeDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int id=sc.nextInt();
        MensajeDAO.borrarMensajeDB(id);
    }
    
    public static void editarMensaje(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Escribe tu nuevo mensaje");
        String mensaje =sc.nextLine();
        
        System.out.println("Indica el ID del mensaje a editar");
        int id=sc.nextInt();
        
        Mensajes actualizacion=new Mensajes();
        actualizacion.setId_mensaje(id);
        actualizacion.setMensaje(mensaje);
        MensajeDAO.actualizarMensajeDB(actualizacion);
    }
}
