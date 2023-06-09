package CollectionFiles;


import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'update_by_id' command
 */
public class UpdateById extends Command {
    @Override
    public boolean checkArgs(String[] args) {
        if (args.length == 2){
            try {
                Long digit = Long.valueOf(args[1]);
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
        argumentsData[0] = Long.valueOf(args[1]);
        CommandData data = new CommandData();
        return data.Name(args[0]).Args(argumentsData).Band(Command.createBand());
    }
}