import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


public class Server extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf;

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


            buf = new byte[256];
            Arrays.fill(buf, (byte)0);
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);// zapisane do bufora , a packet nie ma znaczenia
                        //buf = packet.getData()
            } catch (IOException e) {
                e.printStackTrace();
            }
            InetAddress address = packet.getAddress();// wez adres z tego co przyszlo
            int port = packet.getPort(); // wez port z tego co przyszlo

            String data = "Witaj "+data(buf).toString();
            System.out.println(data);//witaj maciek
            Arrays.fill(buf, (byte)0);
            buf = data.getBytes(StandardCharsets.UTF_8);
            packet = new DatagramPacket(buf, buf.length, address, port); // przygotuj nowy pakiet
        try {
            socket.send(packet);// wyślij powitanie
        } catch (IOException e) {
            e.printStackTrace();
        }
        //buf = String.getBytes(); na bajty do wysłania
        data="";
        System.out.println("w petli");


        for (int i=0;i<3;i++)
        {   buf = new byte[256];
            Arrays.fill(buf, (byte)0);
            packet = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);// czekaj na dane
                                                    //buf = packet.getData()
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(new String(packet.getData(),0,packet.getLength()));
            data+=new String(packet.getData(),0,packet.getLength());


        }//odebrano dane i skonkatenowano


        buf = data.getBytes(StandardCharsets.UTF_8);
        packet = new DatagramPacket(buf, buf.length, address, port); // przygotuj nowy pakiet
        try {
            socket.send(packet);// skonkatenowana wiadomosc
            //System.out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }//wysłano dane


        System.out.println("zamykam polaczenie");
        socket.close();
    }
    public static void main(String[] args) throws SocketException {

        new Server().start();

    }
}