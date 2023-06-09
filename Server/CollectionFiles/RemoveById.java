package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'remo_by_id' command
 */
public class RemoveById extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        Long id = (Long) data.getArgs()[0];
        MusicBand element = null;
        for (MusicBand band : list) {
            if (band.getId().equals(id)) {
                element = band;
            }
        }
        ArrayList messages = new ArrayList();
        if (element == null){
            messages.add("Item with id " + id.toString() + " not found");
        } else {
            list.remove(element);
            messages.add("Item with id " + id.toString() + " successfully removed");
        }
        return messages;
    }
}
