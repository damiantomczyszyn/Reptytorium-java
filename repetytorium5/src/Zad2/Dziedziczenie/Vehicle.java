package Zad2.Dziedziczenie;

public abstract class Vehicle extends Product {
    String brand;
    String model;

    public Vehicle(double price,String brand, String model) {
        super(price);
        this.brand = brand;
        this.model = model;
    }

    @Override
    double calculateBargainPrice() {
        return super.price*0.95;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
