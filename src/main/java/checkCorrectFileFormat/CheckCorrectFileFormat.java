package checkCorrectFileFormat;

import exception.DirectoryIsEmpty;
import exception.WrongFormatException;
import parse.ParseBasketball;
import parse.ParseHandball;
import parse.Parser;
import player.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CheckCorrectFileFormat {
    HashMap<String, Player> players = new HashMap<>();
    public void CheckFileFormat(String path) throws IOException, WrongFormatException, DirectoryIsEmpty {
        File folder = new File(path);
        File[] listFiles = folder.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.getName().substring(file.getName().lastIndexOf('.')).equals(".csv")) {
                    checkedFile(file);
                } else {
                    throw new WrongFormatException("Sorry wrong format file");
                }
            }
        } else throw new DirectoryIsEmpty(folder.getName());
    }

    private void checkedFile(File file) throws IOException {
        BufferedReader readFirstLine = new BufferedReader(new FileReader(file));
        String firstLine = readFirstLine.readLine().toLowerCase();
        switch (firstLine) {
            case "basketball":
                new ParseBasketball().parse(file,players);
            case "handball":
                 new ParseHandball().parse(file,players);
            default:
                System.out.println("Not Found This Game");
        }
    }
}
