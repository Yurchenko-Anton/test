package parse;

import player.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChooseParser {
    public List<Player> choose(File file) throws IOException {
        Parser parser = new Parser();
        BufferedReader readFirstLine = new BufferedReader(new FileReader(file));
        String firstLine = readFirstLine.readLine().toLowerCase();
            switch (firstLine) {
                case "basketball": {
                    parser.setNameOfGame(new Basketball());
                    return new ArrayList<>(parser.executeParse(file));
                }
                case "handball": {
                    parser.setNameOfGame(new Handball());
                    return new ArrayList<>(parser.executeParse(file));
                }
                default: {
                    System.out.println("Not Found This Game");
                    return null;
                }
            }
        }
    }
