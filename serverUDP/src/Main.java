import java.io.IOException;
import java.net.SocketException;
//https://www.baeldung.com/udp-in-java
//https://www.geeksforgeeks.org/working-udp-datagramsockets-java/
//https://www.codejava.net/java-se/networking/java-udp-client-server-program-example
public class Main {
    public static void main(String[] args) throws IOException {

        Client client = new Client();

        client.send("maciek","biegam"," bardzo ", "szybko");



        client.close();

        }

}