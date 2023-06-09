package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'add' command
 */
public class Add extends Command {
    @Override
    public boolean checkArgs(String[] args) {
        return args.length == 1;
    }

    @Override
    public CommandData buildData(String[] args) {
        MusicBand element = Command.createBand();
        CommandData data = new CommandData();
        return  data.Name(args[0]).Band(element);
    }
}

