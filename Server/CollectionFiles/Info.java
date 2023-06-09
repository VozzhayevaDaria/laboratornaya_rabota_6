package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'Info' command
 */
public class Info extends Command {
     @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        ArrayList messages = new ArrayList<>();
        messages.add("Collection type: LinkedList");
        messages.add("Objects type: MusicBand");
        messages.add("Items count: " + Integer.toString((int) list.stream().count()));
        return messages;
    }
}
