package Zadania;

import java.io.IOException;
import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Kopiuj.kopiujFile("test1.txt", "test2.txt");
        Kopiuj.kopiujBuforem("test1.txt","test2.txt");
        System.out.println("\nzad 2:");
        Wyswietlacz.wyswietl("test1.txt");
        Wyswietlacz.wyswietl("src");
        System.out.println("\nzadanie3:");
        Licznik.policz("Lorem.txt");
        System.out.println("\n zadanie4:");
        Licznik.szukane="id";
        Licznik.liczSlowo("Lorem.txt");
        System.out.println("Znaleziona liczba wystapnień: "+ Licznik.count);
        System.out.println("\nzadanie5:");


        System.out.println("\nzadanie6:");
        var listaOsob = new ArrayList<Osoba>(10);//dodajmy wstępnie 10 miejsc
        Osoba.wczytajOsoby("dataOsoby", listaOsob);// przerobione na serializacje
        while (true){
        Osoba.wczytajOsoby2("osoby.txt", listaOsob);//
             }


      // System.exit(0);
    }
}