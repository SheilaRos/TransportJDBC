package model;

public class Package {
    private int idpackage;
    private String customer;
    private TruckDriver driver;
    private City city;

    public Package() {
    }

    public Package(int idpackage, String custom, TruckDriver driver, City city) {
        this.idpackage = idpackage;
        this.customer = custom;
        this.driver = driver;
        this.city = city;
    }

    public int getIdpackage() {
        return idpackage;
    }

    public void setIdpackage(int idpackage) {
        this.idpackage = idpackage;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public TruckDriver getDriver() {
        return driver;
    }

    public void setDriver(TruckDriver driver) {
        this.driver = driver;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return idpackage +", cliente: "+ customer + ", driver: " + driver.getDni() + ", ciudad: " + city.getPostalcode();
    }
    
    
}
