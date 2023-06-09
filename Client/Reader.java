import CollectionFiles.*;

import java.util.HashMap;
import java.util.Scanner;

public class Reader {
    HashMap<String, Command> commandNames = new HashMap<>();
    public Reader(){
        commandNames.put("help", new Help());
        commandNames.put("info", new Info());
        commandNames.put("show", new Show());
        commandNames.put("add", new Add());
        commandNames.put("update_by_id", new UpdateById());
        commandNames.put("remove_by_id", new RemoveById());
        commandNames.put("clear", new Clear());
        commandNames.put("add_if_min", new AddIfMin());
        commandNames.put("remove_greater", new RemoveGreater());
        commandNames.put("sort", new Sort());
        commandNames.put("min_by_number_of_participants", new MinByNumberOfParticipants());
        commandNames.put("filter_less_than_best_album", new FilterLessThanBestAlbum());
        commandNames.put("print_ascending", new PrintAscending());
    }
    public CommandData read(Scanner sc){
        String[] line = sc.nextLine().split(" ");
        if (line[0].equals("exit")){
            Exit.Execute();
        } else if (commandNames.get(line[0])==null){
            System.out.println("Command wasn't found");
        }else if (commandNames.get(line[0]).checkArgs(line)){
             return commandNames.get(line[0]).buildData(line);
        }
        return null;
    }
}
