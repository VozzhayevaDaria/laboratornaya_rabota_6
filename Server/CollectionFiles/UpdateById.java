package CollectionFiles;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The inheritor class of the {@link Command} that implements the 'update_by_id' command
 */
public class UpdateById extends Command{
  @Override
  public ArrayList execute(CommandData data, LinkedList<MusicBand> list) {
      MusicBand oldElement = null;
      for (MusicBand band : list) {
          if (band.getId() == data.getArgs()[0]) {
              oldElement = band;
              break;
          }
      }
      ArrayList messages = new ArrayList();
      if (oldElement != null) {
          MusicBand newElement = data.getBand();
          oldElement.setName(newElement.getName());
          oldElement.setCoordinates(newElement.getCoordinates());
          oldElement.setNumberOfParticipants(newElement.getNumberOfParticipants());
          oldElement.setSinglesCount(newElement.getSinglesCount());
          oldElement.setAlbumsCount(newElement.getAlbumsCount());
          oldElement.setGenre(newElement.getGenre());
          oldElement.setBestAlbum(newElement.getBestAlbum());
          messages.add("The item has been successfully updated");
      } else {
          messages.add("Element wasn't found");
      }
      return messages;
  }
  }
