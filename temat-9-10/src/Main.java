import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
//https://stackoverflow.com/questions/35616291/i-need-to-count-the-number-of-times-a-substring-occurs-in-a-file-using-scanner-a
//https://stackoverflow.com/questions/58364911/how-to-return-a-list-of-strings-in-java
public class Main {
    public static void main(String[] args) throws IOException
    {
        FileWriter fw= new FileWriter("output.txt");
        fw.write("test");
        fw.close();

        //
        int ch;

        // check if File exists or not
        FileReader fr=null;
        try
        {
            fr = new FileReader("output.txt");
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        // read from FileReader till the end of file
        while ((ch=fr.read())!=-1)
            System.out.print((char)ch);

        // close the file
        fr.close();
    }
}