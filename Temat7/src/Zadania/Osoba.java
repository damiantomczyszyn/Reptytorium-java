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
    static StringBuffer buffer = new StringBuffer();


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


    static public int wczytajOsoby(String path, ArrayList<Osoba> listaOsob) throws IOException {


        var input= new FileInputStream(path);
        var dinput= new DataInputStream(input);

        while(dinput.available()>0) {

            // reads characters encoded with modified UTF-8
            String k = dinput.readUTF();
            System.out.print(k+" ");
            Osoba temp = new Osoba(k);//stworzenie osoby z lini pliku
            listaOsob.add(temp);//dodanie osoby do listy

        }

        System.out.println("Wczytano wszystkie osoby z pliku do listy");


        for (Osoba person : listaOsob) {
            System.out.println(person.getImie() + "\t" + person.getNazwisko());
        }
        return 0;
    }



    static public int wczytajOsoby2(String path, ArrayList<Osoba> listaOsob) throws IOException {
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
            case 4: {
                System.out.println("Podano 4");
                System.out.println("Podaj nazwe pliku do ktorego chcesz zapisac tablice");
                sc.nextLine();
                String str = sc.nextLine();
                var output= new FileOutputStream(str);
                var doutput= new DataOutputStream(output);
                for (Osoba x :listaOsob){
                    doutput.writeUTF(x.toString()+"\n");
                }

                doutput.flush();
            }
            default:{
                System.out.println("niewłaściwy wybór");
            }
        }

        return 0;
    }
}
