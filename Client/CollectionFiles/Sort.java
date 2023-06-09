package CollectionFiles;


import java.util.Comparator;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'sort' command
 */
public class Sort extends Command{
    @Override
    public boolean checkArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public CommandData buildData(String[] args) {
        CommandData data = new CommandData();
        return data.Name(args[0]);
    }
}
