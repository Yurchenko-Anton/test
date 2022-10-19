package checkCorrectFileFormat_andMVP;

import player.Player;

import java.util.Comparator;
import java.util.HashMap;

public class MVP {
    public Player findMVP(HashMap<String, Player> players) {
        return players.entrySet().stream()
                .max(Comparator.comparing(stringPlayerEntry -> stringPlayerEntry.getValue().getScore()))
                .get().getValue();
    }
}
