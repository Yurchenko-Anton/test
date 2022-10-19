package service;

import csv.Basketball;
import csv.Handball;
import csv.Parser;
import players.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PlayersService implements Service {

    @Override
    public List<Player> getFromCsv(File file) throws IOException {
        try (BufferedReader readFirstLine = new BufferedReader(new FileReader(file))) {
            Parser parser = new Parser();
            String firstLine = readFirstLine.readLine().toLowerCase();
            switch (firstLine) {
                case "basketball": {
                    parser.setNameOfGame(new Basketball());
                    return new ArrayList<>(parser.parse(file));
                }
                case "handball": {
                    parser.setNameOfGame(new Handball());
                    return new ArrayList<>(parser.parse(file));
                }
                default: {
                    System.out.println("Not Found This Game");
                    return null;
                }
            }
        } catch (IOException ioException) {
            throw new IOException();
        }
    }

    @Override
    public List<Player> countScore(List<Player> players) {
        Map<String, Integer> topPoint = new HashMap<>();
        for (Player player : players) {
            topPoint.merge(player.getTeamName(), player.getGoals(), Integer::sum);
        }
        String team = topPoint.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
        players.stream().filter(player -> player.getTeamName().equals(team))
                .forEach(player -> player.setScore(player.getScore() + 10));
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
    public Player getMvp(HashMap<String,Player> players) {
        return players.entrySet().stream()
                .max(Comparator.comparing(stringPlayerEntry -> stringPlayerEntry.getValue().getScore()))
                .get().getValue();
    }
}
