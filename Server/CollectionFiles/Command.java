package CollectionFiles;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * abstract class ancestor for all classes of commands
 */
public abstract class Command {
    public abstract ArrayList execute(CommandData data, LinkedList<MusicBand> list);
}
