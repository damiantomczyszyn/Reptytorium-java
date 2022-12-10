package Zadania;

import javax.swing.*;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Licznik {
    public static void policz(String path) throws IOException {
        File file = new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        int wordCount = 0;
        int characterCount = 0;
        int sentenceCount = 0;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                //paraCount += 1;
            }
            else {
                characterCount += line.length();
                String[] words = line.split("\\s+");
                wordCount += words.length;
                //whiteSpaceCount += wordCount - 1;
                String[] sentence = line.split("[!?.:]+");
                sentenceCount += sentence.length;
            }
        }
        if (sentenceCount >= 1) {
           // paraCount++;
        }
        System.out.println("Liczba słów = "+ wordCount);
        System.out.println("Liczba linii "+ sentenceCount);
        System.out.println("TLiczba znaków = "+ characterCount);

    }

    private static List<String> listaWKatalogu(String path){
        String[] pathnames;
        File f = new File(path);
        List<String> stringArray = new ArrayList<>(List.of(f.list()));
        return stringArray;
        }
        public static String szukane="";
        public static int count=0;

    public static void liczSlowo(String path)throws IOException {

    if(!Wyswietlacz.getFileExtension(path).equals(""))
    {
        //JFileChooser chooser = new JFileChooser();
        //chooser.showOpenDialog(null);
        //File file = chooser.getSelectedFile();
        File file = new File(path);
        try (Scanner in = new Scanner(new FileInputStream(file), "UTF-8")) {
            while (in.hasNext()) {
                String token = in.next();
                if (token.equals(szukane))
                {
                    count++;
                }
            }
        }
        return;
    }

    else{
        for (String x:listaWKatalogu(path)) {
            liczSlowo(path+"/"+x);
        }
        return;
        }

    }
    /*
    1. jeśli katalog to wyświetl wszystkie pliki
    2. sprawdzaj pliki w pętli
    3. jeśli plik to przeszukaj
    4. jeśli nie ma więcej plików to wróć
     */

}






