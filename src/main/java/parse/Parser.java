package parse;

import player.Player;
import player.SomePlayer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Parser {
   public abstract void parse(File file, HashMap<String, Player> players) throws IOException;

    public void getPointToWinner(HashMap<String, Integer> topPoint, HashMap<String, Player> players){
        String team = topPoint.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        players.values().stream().filter(player -> player.getTeamName().equals(team))
                .forEach(player -> player.setScore(player.getScore() + 10));
    }
    public void addNewOrChangePlayer(HashMap<String,Player> players, String[] fragments, int score){
        if (players.get(fragments[1]) == null) {
            players.put(fragments[1], new SomePlayer(fragments[0], fragments[1], fragments[3], score));
        } else {
            SomePlayer somePlayer = (SomePlayer) players.get(fragments[1]);
            somePlayer.setTeamName(fragments[3]);
            somePlayer.setScore(somePlayer.getScore() + score);
            players.put(somePlayer.getNick(),somePlayer);
        }
    }

}
