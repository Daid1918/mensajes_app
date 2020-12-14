
import com.modelo.Conexion;
import java.sql.Connection;


public class Inicio {
    public static void main(String[] args) {

        Conexion conexion = new Conexion();
try(Connection cnx = conexion.getConexion()){

    }catch (Exception e) {
        System.out.println("Tienes un error-->"+e);
    }
    }
}
