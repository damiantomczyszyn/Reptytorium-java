package Zad2.Dziedziczenie;

public abstract class  Product {
    double price;

    public Product(double price) {
        this.price = price;
    }
    abstract double calculateBargainPrice();

}
