package model;

public class Truck {
    private String idtruck;
    private String model;
    private int capacity;
    private TruckDriver driver;

    public Truck() {
    }

    public Truck(String idtruck, String model, int capacity, TruckDriver driver) {
        this.idtruck = idtruck;
        this.model = model;
        this.capacity = capacity;
        this.driver = driver;
    }

    public String getIdtruck() {
        return idtruck;
    }

    public void setIdtruck(String idtruck) {
        this.idtruck = idtruck;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public TruckDriver getDriver() {  return driver;}
    public void setDriver(TruckDriver driver) {this.driver = driver;}

    @Override
    public String toString() {
        return  idtruck + ", modelo " + model + ", tiene una capacidad de " + capacity + ", y el conductor " + driver.getDni();
    }
    
}
