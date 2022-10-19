package parse;

import player.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

public class ParseBasketball extends Parser {
    @Override
    public void parse(File file, HashMap<String, Player> players) throws IOException {
        HashMap<String, Integer> topPoint = new HashMap<>();
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] fragments = line.split(";");
            if (fragments.length != 7) {
                continue;
            }
            int score = (Integer.parseInt(fragments[4]) * 2) + Integer.parseInt(fragments[5]) + Integer.parseInt(fragments[6]);
            new ParseBasketball().addNewOrChangePlayer(players, fragments, score);
            topPoint.merge(fragments[3], Integer.parseInt(fragments[4]), Integer::sum);
        }
        new ParseBasketball().getPointToWinner(topPoint, players);
    }

}
