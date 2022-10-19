import buildMap.BuildFinalMap;
import checkCorrectFileFormat.CheckCorrectFileFormat;
import checkCorrectFileFormat.exception.DirectoryIsEmpty;
import checkCorrectFileFormat.exception.WrongFormatException;
import count_score.Count;
import parse.ChooseParser;
import player.Player;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    static String path = "data";
    static HashMap<String, Player> players = new HashMap<>();

    public static void main(String[] args) throws IOException, DirectoryIsEmpty, WrongFormatException {
        File folder = new File(path);
        File[] listFiles = folder.listFiles();
        new CheckCorrectFileFormat().CheckFileFormat(listFiles);
        for (File file : listFiles) {
            new BuildFinalMap().build(new Count().count(new ChooseParser().choose(file)), players);
        }
        System.out.println(MVP());
    }

    static Player MVP() {
        return players.entrySet().stream()
                .max(Comparator.comparing(stringPlayerEntry -> stringPlayerEntry.getValue().getScore()))
                .get().getValue();
    }

}
