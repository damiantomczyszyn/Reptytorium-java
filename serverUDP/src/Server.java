import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.*;
public class Server extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];

    public Server() throws SocketException {
        socket = new DatagramSocket(4445); // Java provides DatagramSocket to communicate over UDP
    }
    private StringBuilder data(byte[] a)
    {
        if (a == null)
            return null;
        StringBuilder ret = new StringBuilder();
        int i = 0;
        while (a[i] != 0)
        {
            ret.append((char) a[i]);
            i++;
        }
        return ret;
    }


    public void run() {
        running = true;
        var count = 0;

        while (running) {
            byte[] buf = new byte[256];
            count++;
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);// zapisane do bufora , a packet nie ma znaczenia
                        //buf = packet.getData()
            } catch (IOException e) {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();// wez adres z tego co przyszlo
            int port = packet.getPort(); // wez port z tego co przyszlo

            packet = new DatagramPacket(buf, buf.length, address, port);
            System.out.println(packet.getData());
            String received = new String(packet.getData(), 0, packet.getLength());// czym jest offset
            StringBuilder received2 = data(packet.getData());// czym jest offset
            System.out.print(received);
            System.out.print(".");
            System.out.println();
            System.out.print(received2.toString());System.out.println(".");


            if (received.equals("end") || received.equals("") || count == 3){
                running = false;
                System.out.println("warunek");
                continue;
            //buf = String.getBytes(); na bajty do wysłania
            }
            try {
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("zamykam polaczenie");
        socket.close();
    }
    public static void main(String[] args) throws SocketException {

        new Server().start();

    }
}