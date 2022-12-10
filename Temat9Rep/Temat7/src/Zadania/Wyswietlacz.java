package Zadania;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Wyswietlacz {

    /*
    @param przyjmuje pełną ścieżkę do pliku z rozszerzeniem
    @return Zwraca "" jeśli katalog(brak rozszrzenia) lub zwraca rozszerzenie pliku jeśli nie katalog (występuje w nazwie '.' )
     */
    public static String getFileExtension(String fullName) {
        //checkNotNull(fullName);
        String fileName="przyklad.txt";
        try{
        fileName = new File(fullName).getName();
        }
        catch (Exception e)
        {
            System.out.println("Jakiś wyjątek ale nwm jeszcze jaki");
        }
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }


    public static void wyswietl(String path) throws IOException {


        if(!getFileExtension(path).equals(""))
        {

            FileReader fr = null;
            int ch;

            try
            {
                fr = new FileReader(path);
            }
            catch (FileNotFoundException fe)
            {
                System.out.println("File not found");
            }
            System.out.println("Rozmiar pliku: "+Files.size(Path.of(path)));
            System.out.println("Data ostatniej modyfikacji pliku: "+Files.getLastModifiedTime(Path.of(path)));
            System.out.println("Wyświetlam zawartość pliku:");

            while ((ch=fr.read())!=-1)
            {
                System.out.print((char) ch);
            }
            fr.close();
        }
        else {
            System.out.println("Wyświetlam zawartość katalogu:");
            String[] pathnames;
            File f = new File(path);
            pathnames = f.list();

            for (String pathname : pathnames) {
                System.out.println(pathname);
            }
        }
    }
}
