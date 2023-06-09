package CollectionFiles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
/**
 * The inheritor class of the {@link Command} that implements the 'PrintAscending' command
 */
public class PrintAscending extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        LinkedList<MusicBand> collectionCopy = (LinkedList<MusicBand>) list.clone();
        ArrayList messages = new ArrayList();
        collectionCopy.stream().sorted(Comparator.comparing(MusicBand::getName)).forEach(x -> messages.add(x.toString()));
        return messages;
    }
}
