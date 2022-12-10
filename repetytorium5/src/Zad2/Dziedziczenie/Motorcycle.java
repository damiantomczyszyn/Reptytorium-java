package Zad2.Dziedziczenie;

public class Motorcycle extends Vehicle {
    public Motorcycle(double price, String brand, String model,String typeOfDrive) {
        super(price, brand, model);
        this.typeOfDrive=typeOfDrive;
    }
    String typeOfDrive;

    @Override
    double calculateBargainPrice() {
        return super.calculateBargainPrice()*1.058823;
    }

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }
}
