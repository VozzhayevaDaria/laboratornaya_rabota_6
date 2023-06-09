import CollectionFiles.CommandData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.DatagramSocket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        final int SERVERPORT = 1211;
        Logger logger = LogManager.getRootLogger();
        DatagramSocket soc = Connector.startWork(SERVERPORT);
        if (soc != null) {
            Receiver receiver = new Receiver();
            Executor executor = new Executor();
            Sender sender = new Sender();
            logger.info("Server started work!");
            while (true) {
                CommandData data = receiver.getData(soc);
                ArrayList messagesForClient = executor.execute(data);
                sender.send(data, messagesForClient, soc);
            }
        } else {
            logger.info("Server hasn't started work :(");
        }
    }
}
