import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Adres alternatywy4 = new Adres("Warszawa", "Alternatywy", "4", "9");
        Osoba kotek = new Osoba("Kotek", "Zygmunt", alternatywy4);
        System.out.println(kotek);

        String nazwaPliku = "lista.ser";

        ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(nazwaPliku)));
        out.writeObject("Lista-lokatorów");
        out.writeObject(kotek);//zapis obiektu
        out.close();

        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(nazwaPliku)));// odczytanie obiektu
        String nagłówek = (String) in.readObject();
        kotek = (Osoba) in.readObject();
        in.close();

        System.out.println(kotek);
    }
}


