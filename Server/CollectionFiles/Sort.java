package CollectionFiles;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'sort' command
 */
public class Sort extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        list.sort(Comparator.comparing(MusicBand::getName));
        ArrayList messages = new ArrayList();
        messages.add("The collection is sorted alphabetically");
        return messages;
    }
}
