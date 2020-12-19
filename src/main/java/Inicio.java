
import com.modelo.Conexion;
import java.sql.Connection;
import java.util.Scanner;
import com.modelo.MensajeService;


public class Inicio {
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);

    	int op=0;

    	do{
    		System.out.println("___________________");
    		System.out.println("Aplicacion de mensajes");
    		System.out.println("1.Crear mensaje");
    		System.out.println("2.Listar mensajes");
    		System.out.println("3.Borrar mensaje");
    		System.out.println("4.Editar mensaje");
    		System.out.println("5.Salir");
    		//Leemos la opcion del usuuario

    		op=sc.nextInt();

    		switch(op){
    			case 1: 
    					MensajeService.crearMensaje();
    			break;
    			case 2: 
    					MensajeService.listarMensajes();
    			break;
    			case 3: 
    					MensajeService.borrarMensaje();
    			break;
    			case 4: 
    					MensajeService.editarMensaje();
    			break;
    			default: break;
    		}



    	}while(op!=5);




}
}
