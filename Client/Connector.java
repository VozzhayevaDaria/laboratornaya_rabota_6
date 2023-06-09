import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Connector {
    public static DatagramSocket startWork(int clientPort, int serverPort){
        DatagramSocket soc;
        try {
            soc = new DatagramSocket(clientPort);
            soc.connect(InetAddress.getByName("localhost"), serverPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return soc;
    };
}
