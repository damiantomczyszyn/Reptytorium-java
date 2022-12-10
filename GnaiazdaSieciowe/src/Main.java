import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        //zad1
Klient klient = new Klient();
klient.startConnection("51.83.185.240", 8189);
String response = klient.sendMessage("s00001");
Klient klient2 = new Klient();

//zad2
klient2.startConnection("127.0.0.1",6666);
String response2 = klient2.sendMessage("s00001");

    }
}
//2gie zadanie mozna bez watkow ale wtedy obslugujemy tylko 1 klienta
//dla kazdego polaczenia trzeba zrobic nowy watek i ma dzialac w nieskonczonej petli.
//mozna dac czas oczekiwania

//3 zadania do zrobienia