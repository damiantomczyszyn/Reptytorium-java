import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class Client {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public Client() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    public void send(String msg,String conc1,String conc2, String conc3) throws IOException {
        buf = msg.getBytes();

        DatagramPacket packet  = new DatagramPacket(buf, buf.length, address, 4445);

        socket.send(packet);

        buf = new byte[256];
        Arrays.fill(buf,(byte)0);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Odebrano: "+ received);


        buf = conc1.getBytes();//1 string
        packet = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);

        buf = conc2.getBytes();//2string
        packet  = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);



        buf = conc3.getBytes();//3 string
        packet  = new DatagramPacket(buf, buf.length, address, 4445);
        socket.send(packet);


        buf = new byte[256];
        Arrays.fill(buf,(byte)0);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        received = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Odebrano: "+ received);


    }

    public void close() {
        socket.close();
    }
}