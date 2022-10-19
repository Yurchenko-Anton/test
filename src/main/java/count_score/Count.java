package count_score;

import player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count {
    public List<Player> count(List<Player> players){
        Map<String, Integer> topPoint = new HashMap<>();
        for (Player player : players) {
            topPoint.merge(player.getTeamName(), player.getGoals(), Integer::sum);
        }
        String team = topPoint.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        players.stream().filter(player -> player.getTeamName().equals(team))
                .forEach(player -> player.setScore(player.getScore() + 10));
        return players;
    }
}
