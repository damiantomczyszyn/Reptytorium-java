import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    private static ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        ServerSocket server = null;
        server = new ServerSocket(port);
        server.setReuseAddress(true);
        while (true){
            Socket client = server.accept();
            ClientHandler clientSock = new ClientHandler(client);
            new Thread(clientSock).start();
        }




    }
    public static int NWD_2(int pierwsza, int druga) throws IOException {
        if (druga == 0) {
            return pierwsza;
        } else // rekurencyjne wywołanie funkcji, gdzie kolejność parametrów
        {   // została zamieniona, dodatkowo drugi parametr to operacja modulo
            return NWD_2(druga, pierwsza % druga);  // dwóch liczb.
        }
    }
    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    public static void main(String[] args) throws IOException {
        Server server=new Server();

        server.start(6666);
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        // Constructor
        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            PrintWriter out = null;
            BufferedReader in = null;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            String inLine = null;
            try {
                inLine = in.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            if(inLine.equals("s00001"))
            {
                out.println("Twoj nr To: s00001");
                out.println("Policz nwd liczb:");
                Random random = new Random();

                int pierwsza,druga;//101-1001, druga, 1-100.
                pierwsza=random.nextInt(1001-101)+101;
                druga=random.nextInt(100-1)+1;
                out.println(String.valueOf(pierwsza)+" "+String.valueOf(druga));
                try {
                    inLine = in.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    if(inLine.equals(String.valueOf(NWD_2(pierwsza,druga))))
                        out.println("GOOD");
                    else out.println("BAD");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
            else out.println("WRONG ID");





            }
        }
    }

