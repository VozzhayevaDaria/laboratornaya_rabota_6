import CollectionFiles.CommandData;
import CollectionFiles.Exit;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int CLIENTPORT = 5003;
        final int SERVERPORT = 1211;
        DatagramSocket soc = Connector.startWork(CLIENTPORT, SERVERPORT);
        if (soc != null){
            int lostConectionsCount = 0;
            System.out.println("Connected!");
            Scanner sc = new Scanner(System.in);
            Reader reader = new Reader();
            Sender sender = new Sender();
            Reciever reciever = new Reciever();
            while (true){
                if (Exit.getStatus()){
                    break;
                } else if (soc.isConnected()){
                    lostConectionsCount = 0;
                    CommandData data = reader.read(sc);
                    if (data != null){
                        sender.send(soc, data, SERVERPORT);
                        String[] response = reciever.getData(soc);
                        Arrays.stream(response).forEach(x -> System.out.println(x));
                    }
                } else {
                    if (lostConectionsCount <= 5){
                        lostConectionsCount++;
                        System.out.println("Connection lost. Trying to fix...");
                        Thread.sleep(2000);
                    }else{
                        break;
                    }
                }
            }
            soc.disconnect();
            System.out.println("Disconnected");
        } else {
            System.out.println("Couldn't connect to server :(");
        }


        /*
        try {
            while (true) {
                DatagramSocket soc = new DatagramSocket();
                byte[] ReceivingData = new byte[1024];
                byte[] SendingData = new byte[1024];

                Scanner keyboard = new Scanner(System.in);
                System.out.println("Введите сообщение");
                String message = keyboard.next();
                SendingData = message.getBytes();
                InetAddress Address = InetAddress.getByName("localhost");
                DatagramPacket OutputPocket = new DatagramPacket(SendingData, SendingData.length, Address, 1205);
                soc.send(OutputPocket);
                System.out.println("Отправил сообщение -->" + new String(OutputPocket.getData()) + "<--");

                DatagramPacket InputPocket = new DatagramPacket(ReceivingData, ReceivingData.length);
                soc.receive(InputPocket);
                System.out.println("Получил сообщение -->" + new String(InputPocket.getData()) + "<--");
                soc.close();
            }
        } catch (IOException e){
            System.out.println("Клиент: ой...");
        }

         */
    }
}
