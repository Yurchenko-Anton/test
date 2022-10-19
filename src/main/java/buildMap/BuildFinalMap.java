package buildMap;

import player.Player;

import java.util.HashMap;
import java.util.List;

public class BuildFinalMap {
    public void build(List<Player> playersList, HashMap<String, Player> playersMap) {
        for (Player player : playersList) {
            if (playersMap.get(player.getNick()) == null) {
                playersMap.put(player.getNick(), player);
            } else {
                player.setScore(player.getScore() + playersMap.get(player.getNick()).getScore());
                playersMap.put(player.getNick(), player);
            }
        }
    }
}
