package service;

import checkCorrectFileFormat.exception.FileFormatException;
import csv.handle.BasketballParsingValueHandler;
import csv.handle.HandballParsingValueHandler;
import csv.handle.PlayerValueHandler;
import csv.parsers.CsvParser;
import players.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PlayersService implements Service {
    private static final char SPLITITERATOR = ';';

    @Override
    public List<Player> getFromCsv(File file) throws IOException, FileFormatException {
        try (BufferedReader readFirstLine = new BufferedReader(new FileReader(file))) {
            CsvParser csvParser;
            PlayerValueHandler<?> valueHandler;

            String playerType = readFirstLine.readLine().toLowerCase();

            valueHandler = chooseValueHandler(playerType);

            csvParser = new CsvParser(valueHandler, SPLITITERATOR);
            csvParser.parse(readFirstLine);

            return new ArrayList<>(valueHandler.getResult());

        }
    }

    @Override
    public List<Player> countScore(List<Player> players) {
        Map<String, Integer> topPoint = new HashMap<>();
        for (Player player : players) {
            topPoint.merge(player.getTeamName(), player.getGoals(), Integer::sum);
        }
        String team = topPoint.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        players.stream().filter(player -> player.getTeamName().equals(team)).forEach(player -> player.setScore(player.getScore() + 10));
        return players;
    }

    @Override
    public void addPlayersToMap(List<Player> playersList, HashMap<String, Player> playersMap) {
        for (Player player : playersList) {
            if (playersMap.get(player.getNick()) == null) {
                playersMap.put(player.getNick(), player);
            } else {
                player.setScore(player.getScore() + playersMap.get(player.getNick()).getScore());
                playersMap.put(player.getNick(), player);
            }
        }
    }

    @Override
    public Player getMvp(HashMap<String, Player> players) {
        return players.entrySet().stream().max(Comparator.comparing(stringPlayerEntry -> stringPlayerEntry.getValue().getScore())).get().getValue();
    }

    private PlayerValueHandler<?> chooseValueHandler(String playerType) throws FileFormatException {
        switch (playerType) {
            case "basketball": {
                return new BasketballParsingValueHandler(new ArrayList<>());
            }
            case "handball": {
                return new HandballParsingValueHandler(new ArrayList<>());
            }
            default: {
                throw new FileFormatException("Player type " + playerType + " not supported");
            }
        }
    }
}
