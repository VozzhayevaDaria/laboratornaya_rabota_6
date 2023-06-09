package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'show' command
 */
public class Show extends Command {

    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        ArrayList messages = new ArrayList();
        list.stream().forEach(x -> messages.add(x.toString()));
        return messages;
    }
}
