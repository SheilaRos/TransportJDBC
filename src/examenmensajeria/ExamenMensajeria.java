package examenmensajeria;

import java.sql.SQLException;
import java.util.List;
import model.City;
import model.TruckDriver;
import model.Package;
import model.RankingEnvios;
import model.Truck;
import persistence.TransportJDBC;

public class ExamenMensajeria {
    public static void main(String[] args) {
       TransportJDBC gestor = new TransportJDBC(); 
       try{
           System.out.println("iniciando conexión con la BBDD...");
            gestor.conectar();
           System.out.println("conexión iniciada");
           System.out.println("");
           System.out.println("Insertando paquete...");
            TruckDriver d = new TruckDriver("45875215E", "Leopoldo", "666999666", 1000.0);
            City c = new City ("08033", "Barcelona");
            Package p = new Package(4, "Amancio", d, c);
            gestor.insertPackage(p);
           System.out.println("Paquete insertado.");
           System.out.println("");
           System.out.println("Modificando sueldo del camionero Leopoldo....");
            gestor.updateSalaryTruckDriver(1800.0, "45875215E");
           System.out.println("Sueldo modificado correctamente.");
           System.out.println("");
           System.out.println("Devolver la lista de camiones que conduce Leopoldo:");
            List<Truck> trucks = gestor.returnListTruckFromOneTruckDriver(d);
            for(Truck t : trucks){
                System.out.println(t);
            }
           System.out.println("");
           System.out.println("Devolver los paquetes que se han enviado a Barcelona:");
            List<Package> packages = gestor.returnListPackagesToCity(c);
            for(Package pg: packages){
                System.out.println(pg);
            }
           System.out.println("");
           System.out.println("Devolver un ranking de envios por ciudad:");
            List<RankingEnvios> cities = gestor.returnListCity();
            for(RankingEnvios re: cities){
                System.out.println(re);
            }
           
       }catch(SQLException ex){
            System.out.println("Error con la BBDD: "+ex.getMessage());
        }finally{
            try{
                System.out.println("");
                System.out.println("cerrando conexión con la BBDD...");
                    gestor.desconectar();
                System.out.println("Conexión cerrada.");
            }catch (SQLException ex){
                System.out.println("Error al desconectar"+ex.getMessage());
            }
        }
    }
    
}
