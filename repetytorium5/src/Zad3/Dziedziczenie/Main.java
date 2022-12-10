package Zad3.Dziedziczenie;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Car car = new Car(100,"brand","model","bodycar");
        System.out.println(car.calculateBargainPrice());

        ArrayList<Product> products= new ArrayList<>();
        ProductInterface x = new Vehicle(3050,"brand2","model2");
        products.add((Product) x);
         x = new Vehicle(3050,"brand2","model2");
        products.add((Product) x);
        x = new Vehicle(3050,"brand2","model2");
        products.add((Product) x);
         x = new Car(3000,"brand1","model1","body1");
        products.add((Product) x);
        x = new Car(3000,"brand1","model1","body1");
        products.add((Product) x);
        x =new Motorcycle(3000,"brand1","model1","fast");
        products.add((Product) x);
        x = new Motorcycle(3000,"brand1","model1","fast");
        products.add((Product) x);

        for (Zad3.Dziedziczenie.Product z:products) {
            var y=(Zad3.Dziedziczenie.Vehicle)z;
            System.out.println(y.getBrand());
            System.out.println(y.getModel());
            System.out.println(y.calculateBargainPrice());
            System.out.println();
        }
    }
}
