package checkCorrectFileFormat;

import checkCorrectFileFormat.exception.DirectoryIsEmpty;
import checkCorrectFileFormat.exception.WrongFormatException;
import player.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CheckCorrectFileFormat {
    private final HashMap<String, Player> players = new HashMap<>();

    public void CheckFileFormat(File[] listFiles) throws IOException, WrongFormatException, DirectoryIsEmpty {
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.getName().substring(file.getName().lastIndexOf('.')).equals(".csv")) {
                    throw new WrongFormatException("Sorry wrong format file");
                }
            }
        } else throw new DirectoryIsEmpty("Directory is Empty");
    }

}
