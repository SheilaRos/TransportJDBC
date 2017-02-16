package model;

public class TruckDriver {
   private String dni;
   private String name;
   private String phone;
   private Double salary;

    public TruckDriver() {
    }

    public TruckDriver(String dni, String name, String phone, Double salary) {
        this.dni = dni;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return dni + ", con nombre " + name + ", telefono " + phone + ",y salario" + salary;
    }
   
    
}
