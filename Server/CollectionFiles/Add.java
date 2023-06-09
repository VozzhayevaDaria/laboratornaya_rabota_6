package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'add' command
 */
public class Add extends Command {

    public ArrayList execute(CommandData data, LinkedList<MusicBand> list){
        MusicBand element = data.getBand();
        list.add(element);
        ArrayList messages = new ArrayList();
        messages.add("The item has been added to the collection. To see what the collection looks like, write 'show'");
        return messages;
    }
}

