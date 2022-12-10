import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.*;
public class Server extends Thread {

    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
    String name = null;
    String concat = "";

    public Server() throws SocketException {
        socket = new DatagramSocket(4445);
        concat = "";
    }

    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);


            String received = new String(packet.getData(), 0, packet.getLength());
            if (name == null)
                name=received;
            else concat+=received;

            if (received.equals("end")) {
                running = false;
                continue;
            }
            buf = concat.getBytes();
            packet = new DatagramPacket(buf, buf.length , address, port);
            try {
                socket.send(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        socket.close();
    }
    public static void main(String[] args) throws SocketException {

        new Server().start();

    }
}