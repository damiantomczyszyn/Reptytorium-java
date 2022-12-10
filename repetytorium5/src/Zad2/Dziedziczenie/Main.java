package Zad2.Dziedziczenie;

import Dziedziczenie.Vehicle;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	Car car = new Car(100,"brand","model","bodycar");


        ArrayList<Product> products= new ArrayList<>();
        //products.add(new Vehicle(3000,"brand1","model1"));
        //products.add(new Vehicle(3050,"brand2","model2"));
        products.add(new Car(3000,"brand1","model1","body1"));
        products.add(new Car(4000,"brand1","model1","body2"));
        products.add(new Motorcycle(3000,"brand1","model1","fast"));
        products.add(new Motorcycle(3000,"brand1","model1","slow"));
        for (Zad2.Dziedziczenie.Product x:products) {
            var y=(Zad2.Dziedziczenie.Vehicle)x;
            System.out.println(y.getBrand());
            System.out.println(y.getModel());
            System.out.println(y.calculateBargainPrice());
            System.out.println();
        }
    }
}
