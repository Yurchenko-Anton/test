package csv;

import players.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    NameOfGameHandler nameOfGameHandler;

    public void setNameOfGame(NameOfGameHandler nameOfGameHandler) {
        this.nameOfGameHandler = nameOfGameHandler;
    }

    public List<Player> parse(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        lines.remove(0);
        List<Player> players = new ArrayList<>();
        for (String line : lines) {
            String[] fragments = line.split(";");
            players.add(nameOfGameHandler.getPlayerObject(fragments));
        }
        return players;
    }
}
