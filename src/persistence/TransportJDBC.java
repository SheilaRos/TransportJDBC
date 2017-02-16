package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.City;
import model.Package;
import model.RankingEnvios;
import model.Truck;
import model.TruckDriver;

public class TransportJDBC {
    private Connection connection;
    public void conectar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/transport";
        String usr = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, usr, pass);
    }
    public void desconectar() throws SQLException{
        if(connection != null){
            connection.close();
        }
    }
    public void insertPackage(Package p) throws SQLException{
        String insert = "insert into package values (null, ?, ?, ?);";
        PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, p.getCustomer());
            ps.setString(2, p.getDriver().getDni());
            ps.setString(3, p.getCity().getPostalcode());
        ps.executeUpdate();
        ps.close();
    }
    
      public void updateSalaryTruckDriver(double salary, String dni) throws SQLException{
        String update = "update truckdriver set salary=? where dni = '" + dni+"';";
        PreparedStatement ps = connection.prepareStatement(update);
            ps.setDouble(1, salary);
        ps.executeUpdate();
        ps.close();
    }
    
    public List<Truck> returnListTruckFromOneTruckDriver(TruckDriver td) throws SQLException{
        List<Truck> trucks = new ArrayList<>();
        String query = "select * from truck where driver='"+td.getDni()+"';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            Truck t = new Truck();
            TruckDriver tdv = new TruckDriver();
            t.setIdtruck(rs.getString("idtruck"));
            t.setModel(rs.getString("model"));
            t.setCapacity(rs.getInt("capacity"));
            tdv.setDni(rs.getString("driver"));
            t.setDriver(tdv);
            trucks.add(t);
        }
        rs.close();
        st.close();
        return trucks;
    }
    
    public List<Package> returnListPackagesToCity(City c) throws SQLException{
        List<Package> packages = new ArrayList<>();
        String query = "select * from package where city='"+c.getPostalcode()+"';";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            Package p = new Package();
            City ct = new City();
            TruckDriver td = new TruckDriver();
            p.setIdpackage(rs.getInt("idpackage"));
            p.setCustomer(rs.getString("customer"));
            td.setDni(rs.getString("driver"));
            ct.setPostalcode(rs.getString("city"));
            p.setDriver(td);
            p.setCity(ct);
            packages.add(p);
        }
        rs.close();
        st.close();
        return packages;
    }
    
    public List<RankingEnvios> returnListCity() throws SQLException{
        List<RankingEnvios> cities = new ArrayList<>();
        String query = "select name, count(idpackage) as 'envios' from city, package where city=postalcode group by postalcode order by envios desc;";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            RankingEnvios re = new RankingEnvios();
            re.setNameCity(rs.getString("name"));
            re.setEnvios(rs.getInt("envios"));
            cities.add(re);
        }
        rs.close();
        st.close();
        return cities;
    }
 
}
