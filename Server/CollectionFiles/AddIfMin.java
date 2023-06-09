package CollectionFiles;

import java.util.*;
/**
 * The inheritor class of the {@link Command} that implements the 'add_if_min' command
 */
public class AddIfMin extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        ArrayList messages = new ArrayList();
        MusicBand element = data.getBand();
        LinkedList<MusicBand> collectionCopy = (LinkedList<MusicBand>) list.clone();
        Comparator<MusicBand> compareByAlphabet = Comparator.comparing(MusicBand::getName);
        collectionCopy.add(element);
        collectionCopy.sort(compareByAlphabet);
        if (collectionCopy.peekLast().equals(element)){
            System.out.println(collectionCopy.toString());
            list.add(element);
            messages.add("The element is smaller than the minimum element of the collection, so it was added");
        } else {
            messages.add("The element is larger than the minimum element of the collection, so it was not added");
        }
        return messages;
    }
}
