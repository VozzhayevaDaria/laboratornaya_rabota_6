package CollectionFiles;


import java.util.*;
/**
 * The inheritor class of the {@link Command} that implements the 'remove_greater' command
 */
public class RemoveGreater extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        MusicBand element = data.getBand();
        LinkedList<MusicBand> collectionCopy = (LinkedList<MusicBand>) list.clone();
        collectionCopy.add(element);
        ArrayList messages = new ArrayList();
        messages.add("Removed elements with IP:");
        for (MusicBand greaterBand : collectionCopy) {
            if (greaterBand.equals(element)) {
                break;
            }
            list.remove(greaterBand);
            messages.add(greaterBand.getId().toString());
        }
        if (messages.size() == 1){
            messages = new ArrayList();
            messages.add("There are any greater elements");
        }
        return messages;
    }
}
