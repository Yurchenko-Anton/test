package service;

import checkCorrectFileFormat.exception.FileFormatException;
import players.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface Service {
    List<Player> getFromCsv(File file) throws IOException, FileFormatException;

    List<Player> countScore(List<Player> players);

    void addPlayersToMap(List<Player> playersList, HashMap<String, Player> playersMap);

    Player getMvp(HashMap<String, Player> players);
}
