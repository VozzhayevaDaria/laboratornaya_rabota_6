import CollectionFiles.CommandData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;

public class Sender {
    private static final Logger logger = (Logger) LogManager.getRootLogger();
    public void send(CommandData data, ArrayList messages, DatagramSocket soc) throws IOException{
        Logger logger = (Logger) LogManager.getRootLogger();
        ObjectMapper mapper = new YAMLMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String serialisedMessages = mapper.writeValueAsString(messages);
        logger.info(serialisedMessages);
        mapper.registerModule(new JavaTimeModule());
        ArrayList<String> packetsList = Sender.MakePocketsList(serialisedMessages);
        InetAddress adress = data.getClientAdress();
        int port = data.getClientPort();
        for (int i = 0; i < packetsList.size(); i++){
            DatagramPacket datagramPacket = new DatagramPacket(packetsList.get(i).getBytes(), packetsList.get(i).getBytes().length, adress, port);
            soc.send(datagramPacket);
        }
    }
    public static ArrayList MakePocketsList(String str){
        ArrayList list = new ArrayList<>();
        int end_index = 0;
        int start_index = 0;
        Integer left_num = 0;
        Integer right_num = 1;
        while(end_index <= str.length()){
            int current_len = 100 - (left_num.toString().length() + right_num.toString().length()) - 2;
            end_index = start_index + current_len + 1;
            if (end_index > str.length()){
                list.add(left_num.toString() + ":" + str.substring(start_index, str.length()) + ":0");
            } else {
                list.add(left_num.toString() + ":" + str.substring(start_index, end_index) + ":" + right_num);
            }
            start_index = end_index;
            left_num++;
            right_num++;
        }
        return list;
    }
}
