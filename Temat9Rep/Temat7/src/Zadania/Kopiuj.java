package Zadania;

import java.io.*;

public class Kopiuj {

    /*
    @param filename1 plik z którego będzie kopiowana zawartość
    @param filename2 plik do którego będzie kopiowana zawartość
     */
    static public void kopiujBuforem (String filename1, String filename2)throws IOException {


        FileReader fr = null;
        FileWriter fw = null;
        int ch;

        try
        {
            fr = new FileReader(filename1);
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        try{
            fw = new FileWriter(filename2,true);
        }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
        BufferedWriter outStream = new BufferedWriter(fw);
        BufferedReader inStream = new BufferedReader(fr);
        long startTime = System.nanoTime();
        //odczyt i zapis

            outStream.write(inStream.readLine());


        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        // close the file
        fw.close();
        fr.close();
        System.out.println("Zawartość została właśnie skopiowana  poprzez bufor w czasie: "+duration);

    }
    /*
    @param filename1 plik z którego będzie kopiowana zawartość
    @param filename2 plik do którego będzie kopiowana zawartość
     */
    static public void kopiujFile(String filename1, String filename2)throws IOException{
        FileReader fr = null;
        FileWriter fw = null;
        int ch;

        try
        {
            fr = new FileReader(filename1);
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        try{
            fw = new FileWriter(filename2,true);
            }
        catch (IOException e)
        {
            System.out.println("File not found");
        }
        long startTime = System.nanoTime();
        while ((ch=fr.read())!=-1)
        {
            //System.out.print((char) ch);
            fw.write((char)ch);

        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);

        // close the file
        fw.close();
        fr.close();
        System.out.println("Zawartość została właśnie skopiowana znak po znaku w czasie: "+duration);    }

}
