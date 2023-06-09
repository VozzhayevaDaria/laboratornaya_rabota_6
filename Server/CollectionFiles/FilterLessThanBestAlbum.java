package CollectionFiles;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'FilterLessThanBestAlbum' command
 */
public class FilterLessThanBestAlbum extends Command{
    @Override
    public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
        float sales = (float) data.getArgs()[0];
        ArrayList messages = new ArrayList();
        messages.add("Bands whose best album sales are less than " + Float.toString(sales));
        list.stream().filter(x -> x.getBestAlbum().getSales() < sales).forEach(x -> messages.add(x.toString()));
        return messages;
    }
}
