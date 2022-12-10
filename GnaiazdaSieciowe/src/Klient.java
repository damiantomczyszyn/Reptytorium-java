import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Klient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    String ostatniaWiadomosc;

    public void startConnection(String ip, int port) throws IOException {
        StringBuilder responseString = new StringBuilder();

        PrintWriter writer = null;
        BufferedReader bufferedReader = null;


        clientSocket = new Socket(ip, port);
        clientSocket.setKeepAlive(true);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
       // String str;
       // bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
       // while ((str = bufferedReader.readLine()) != null)
       //     responseString.append(str);
     //   ostatniaWiadomosc=responseString.toString();

    }


    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String str;
        //while((str=in.readLine())!=null) {
            str = in.readLine();
            System.out.println(str);
        str = in.readLine();
        System.out.println(str);
        str = in.readLine();
        System.out.println(str);
        System.out.println();

       // out.println(NWD_2(Integer.parseInt(str.split(" ")[0]),Integer.parseInt(str.split(" ")[1])));//z1

///////////////////zad2 modyfikacja
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj NWD");
        out.println(scanner.nextInt());
///////////////////
        str = in.readLine();
        System.out.println(str);
        System.out.println();

        //}
        return str;
    }
    public static int NWD_2(int pierwsza, int druga)
    {
        if (druga == 0)
        {
            return pierwsza;
        }
        else // rekurencyjne wywołanie funkcji, gdzie kolejność parametrów
        {   // została zamieniona, dodatkowo drugi parametr to operacja modulo
            return NWD_2(druga, pierwsza%druga);  // dwóch liczb.
        }
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}