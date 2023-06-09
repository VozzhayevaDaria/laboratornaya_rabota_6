package CollectionFiles;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * abstract class ancestor for all classes of commands
 */
public abstract class Command {
    public abstract boolean checkArgs(String[] args);
    public abstract CommandData buildData(String[] args);
    public static MusicBand createBand(){
        boolean creatingInProcess = true;
        System.out.println("Creating of new element is in process..." + "\n" +
                "Enter 'stop' to interrupt creating" + "\n" +
                "Enter 'exit' to exit the app");
        Scanner keyboard = new Scanner(System.in);
        String line;
        MusicBand element;
        element = new MusicBand("");
        //Ввод имени
        System.out.println("Enter bands name");
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            if (line == null || line == "") {
                System.out.println("Bands name cant be null or empty string, enter other name, please");
            } else {
                element.setName(line);
                break;
            }
        }
        //Ввод координат
        if (creatingInProcess) {
            System.out.println("Enter x and y coordinates, separating them with space" + "\n" +
                    "x must be lower than 241, y lower than -579, separating sign - dot");
        }
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            if (line == null || line == "") {
                System.out.println("Coordinates cant be null or empty string, enter other coordinates, please");
            } else {
                String[] coordinates = line.split(" ");
                try {
                    Double x = Double.valueOf(coordinates[0]);
                    float y = (float) Float.valueOf(coordinates[1]);
                    if (x > 241 || y > -579) {
                        System.out.println("The coordinates do not meet the required range, enter other coordinates, please");
                    } else {
                        element.setCoordinates(new Coordinates(x, y));
                        System.out.println(element.getCoordinates().toString());
                        break;
                    }
                } catch (RuntimeException e) {
                    System.out.println("The coordinates do not meet the required format, enter other coordinates, please");
                }
            }
        }
        //Ввод количества учатсников
        if (creatingInProcess) {
            System.out.println("Enter number of participants of band");
        }
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            try {
                if (line == null) {
                    element.setNumberOfParticipants(null);
                    break;
                }
                Long count = Long.valueOf(line);
                if (count > 0) {
                    element.setNumberOfParticipants(count);
                    break;
                } else {
                    System.out.println("Number of participants must be positive number, enter other number, please");
                }
            } catch (RuntimeException e) {
                System.out.println("The number of participants do not meet the required format, enter other coordinates, please");
            }
        }
        //Ввод количества синглов
        if (creatingInProcess) {
            System.out.println("Enter singles count");
        }
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            if (line == null || line == "") {
                System.out.println("Singles count cant be null or empty string, enter other name, please");
            } else {
                try {
                    long count = Long.valueOf(line);
                    if (count > 0) {
                        element.setSinglesCount(count);
                        break;
                    } else {
                        System.out.println("Singles count must be positive number, enter other number, please");
                    }
                } catch (RuntimeException e) {
                    System.out.println("Singles count do not meet the required format, enter other coordinates, please");
                }
            }
        }
        //Ввод количства альбомов
        if (creatingInProcess) {
            System.out.println("Enter albums count");
        }
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            try {
                if (line == null) {
                    element.setAlbumsCount(null);
                    break;
                }
                Long count = Long.valueOf(line);
                if (count > 0) {
                    element.setAlbumsCount(count);
                    break;
                } else {
                    System.out.println("Albums count must be positive number, enter other number, please");
                }
            } catch (RuntimeException e) {
                System.out.println("The entered quantity does not meet the required format, please enter a different value");
            }
        }
        //Ввод музыкального жанра
        if (creatingInProcess) {
            System.out.println("Enter one of the suggested musical genres: rock, progressive rock, post rock, punk rock, post punk, null");
        }
        HashSet<String> genres = new HashSet<>(List.of(new String[]{"rock", "progressive rock", "post rock", "punk rock", "post punk"}));
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            if (line == null) {
                element.setGenre(null);
                break;
            } else if (genres.contains(line)) {
                switch (line) {
                    case ("rock") -> element.setGenre(MusicGenre.ROCK);
                    case ("progressive rock") -> element.setGenre(MusicGenre.PROGRESSIVE_ROCK);
                    case ("post rock") -> element.setGenre(MusicGenre.POST_ROCK);
                    case ("punk rock") -> element.setGenre(MusicGenre.PUNK_ROCK);
                    case ("post punk") -> element.setGenre(MusicGenre.POST_PUNK);
                }
                break;
            } else {
                System.out.println("Entered genre not found");
            }
        }
        //Ввод любимого альбома
        if (creatingInProcess) {
            System.out.println("Enter best albums name");
        }
        String name = null;
        float sales = 0;
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            if (line == null || line == "") {
                System.out.println("Albums name cant be null or empty string, enter other name, please");
            } else {
                name = line;
                break;
            }
        }
        if (creatingInProcess) {
            System.out.println("Enter best albums sales count");
        }
        while (creatingInProcess) {
            line = keyboard.nextLine();
            if (line.equals("exit")) {
                Exit.Execute();
                creatingInProcess = false;
                break;
            }
            if (line.equals("stop")) {
                creatingInProcess = false;
                break;
            }
            try {
                float count = Float.valueOf(line);
                if (count > 0) {
                    sales = count;
                    break;
                } else {
                    System.out.println("Best albums sales count must be positive number, enter other number, please");
                }
            } catch (RuntimeException e) {
                System.out.println("The entered quantity does not meet the required format, please enter a different value");
            }
        }
        if (creatingInProcess) {
            element.setBestAlbum(new Album(name, sales));
            return element;
        }
        return null;
    }
}
