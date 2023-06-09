package CollectionFiles;

import java.net.InetAddress;

public class CommandData {
    public String CommandName;
    public Object[] CommandArgs;
    public MusicBand Band;
    public InetAddress ClientAdress;
    public int ClientPort;

    public static CommandData createData() {
        return new CommandData();
    }

    public CommandData Name(String name) {
        this.CommandName = name;
        return this;
    }

    public CommandData Args(Object[] args) {
        this.CommandArgs = args;
        return this;
    }

    public CommandData Band(MusicBand band) {
        this.Band = band;
        return this;
    }
    public void SetClientInform(InetAddress adress, int port){
        this.ClientAdress = adress;
        this.ClientPort = port;
    }
    public String getCommandName(){
        return CommandName;
    }
    public MusicBand getBand(){
        return Band;
    }
    public Object[] getArgs(){
        return CommandArgs;
    }
    public InetAddress getClientAdress(){
        return ClientAdress;
    }
    public int getClientPort(){
        return ClientPort;
    }
}
