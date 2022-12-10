package Zad3.Dziedziczenie;

public class Product implements  ProductInterface{
    double price;

    public Product(double price) {
        this.price = price;
    }
    public double calculateBargainPrice()
    {
        return price;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void setPrice(double price) {

    }

}
