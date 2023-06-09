import CollectionFiles.CommandData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Receiver {
    public CommandData getData(DatagramSocket soc) throws IOException {
        Logger logger = (Logger) LogManager.getRootLogger();
        byte[] buffer = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
        soc.receive(datagramPacket);
        InetAddress clientAddress = datagramPacket.getAddress();
        int clientPort = datagramPacket.getPort();
        String SerialisedData = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        CommandData deserialisedData = this.deserialiseData(SerialisedData);
        deserialisedData.SetClientInform(clientAddress, clientPort);
        logger.info("Got command: " + deserialisedData.CommandName);
        return deserialisedData;
    }

    public CommandData deserialiseData(String data) throws JsonProcessingException {
        ObjectMapper mapper = new YAMLMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule());
        CommandData deserialisedData = mapper.readValue(data, CommandData.class);
        return deserialisedData;
    }
}
