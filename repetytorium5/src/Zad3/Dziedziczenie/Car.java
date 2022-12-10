package Zad3.Dziedziczenie;

public class Car extends Vehicle {
    String carBody;

    public Car(double price, String brand, String model,String carBody) {
        super(price, brand, model);
        this.carBody=carBody;
    }

    @Override
    public double calculateBargainPrice() {
        return super.calculateBargainPrice()*0.89473;
    }

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }
}
