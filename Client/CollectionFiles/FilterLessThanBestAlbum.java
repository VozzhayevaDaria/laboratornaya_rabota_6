package CollectionFiles;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'FilterLessThanBestAlbum' command
 */
public class FilterLessThanBestAlbum extends Command{
    @Override
    public boolean checkArgs(String[] args) {
        if (args.length == 2){
            try {
                Float digit = Float.valueOf(args[1]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public CommandData buildData(String[] args) {
        Object[] argumentsData = new Object[1];
        argumentsData[0] = Float.valueOf(args[1]);
        CommandData data = new CommandData();
        return data.Name(args[0]).Args(argumentsData);
    }
}
