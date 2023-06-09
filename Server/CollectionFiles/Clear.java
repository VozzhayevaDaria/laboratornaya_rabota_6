package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * The inheritor class of the {@link Command} that implements the 'Clear' command
 */
public class Clear extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        list.removeAll(list);
        ArrayList messages = new ArrayList();
        messages.add("The collection has been cleared");
        return messages;
    }
}
