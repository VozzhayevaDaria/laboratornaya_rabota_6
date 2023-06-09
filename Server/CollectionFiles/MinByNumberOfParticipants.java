package CollectionFiles;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'MinByNumberOfParticipants' command
 */
public class MinByNumberOfParticipants extends Command{

    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        MusicBand minElement = list.stream().min((x,y)->Long.compare(x.getNumberOfParticipants(),y.getNumberOfParticipants())).get();
        ArrayList messages = new ArrayList();
        messages.add("Item with minimal number of participants:");
        messages.add(minElement.toString());
        return messages;
    }
}
