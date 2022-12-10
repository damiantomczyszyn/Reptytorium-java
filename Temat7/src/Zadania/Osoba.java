package Zadania;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Osoba {
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    private String imie,nazwisko;
    public String toString() {
        return getImie()+" : "+getNazwisko();
    }


    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public Osoba(String imieINazwisko) {
 // podziele ten string na imie i nazwisko samemu i je przypisze. metoda ktora dzieli na separator" : "
        String[] result = imieINazwisko.split(" : ");
        this.imie=result[0];
        this.nazwisko=result[1];//sprawdz czy nie ma tutaj znaku konca lini, jak jest to usuń

    }


/*
@param path - ścieżka do pliku z listą osob
@listaOsob - pusta lista do której mają być wczytane osoby z pliku
 */


    static public int wczytajOsoby(String path, ArrayList<Osoba> listaOsob) throws FileNotFoundException {

        File file = new File(path);
        System.out.println(file.getName());//temp
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                Osoba temp = new Osoba(line);//stworzenie osoby z lini pliku
                listaOsob.add(temp);//dodanie osoby do listy
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Wczytano wszystkie osoby z pliku do listy");


        for (Osoba person : listaOsob) {
            System.out.println(person.getImie() + "\t" + person.getNazwisko());
        }
        return 0;
    }




    static public int wczytajOsoby2(String path, ArrayList<Osoba> listaOsob) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("podaj 1 jesli chcesz dodac osobe");
        System.out.println("podaj 2 jesli chcesz wyczyscic tablice osob");
        System.out.println("podaj 3 jesli chcesz usunac element tablicy");
        System.out.println("podaj 4 jesli  zapisac tablice do pliku");
        int wybor = sc.nextInt();
        switch (wybor){
            case 1:{

                sc.nextLine();//naprawa bufora
                System.out.println("podaj imie osoby");
                String imie=sc.nextLine();
                System.out.println("podaj nawzisko osoby");
                String nazwisko=sc.nextLine();
                listaOsob.add(new Osoba(imie,nazwisko));
                break;
            }
            case 2:{
                System.out.println("Podano 2");
                listaOsob.clear();
                break;
            }
            case 3:{
                System.out.println("Podano 3");
                System.out.println("Podaj numer indeksu osoby ktora chcesz usunac");
                wybor = sc.nextInt();
                if (listaOsob.contains(wybor))
                listaOsob.remove(wybor);
                else System.out.println("Niepoprawny indeks");
                break;
            }
            case 4:{
                System.out.println("Podano 4");
                System.out.println("Podaj nazwe pliku do ktorego chcesz zapisac tablice");
                sc.nextLine();
                String str=sc.nextLine();

                PrintWriter out = new PrintWriter(str);
                for (Osoba x :listaOsob){
                    System.out.println(x.toString());
                    out.println(x.toString());
                }
                out.close();
                break;
            }
            default:{
                System.out.println("niewłaściwy wybór");
            }
        }

        return 0;
    }
}
