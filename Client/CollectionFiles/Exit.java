package CollectionFiles;

/**
 * The inheritor class of the {@link Command} that implements the 'Exit' command
 */
public class Exit {
    public static boolean status = false;
    public static void Execute(){
        status = true;
    }
    public static boolean getStatus(){
        return status;
    }
}