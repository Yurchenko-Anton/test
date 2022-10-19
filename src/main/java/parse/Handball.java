package parse;

import player.HandballPlayer;

public class Handball implements NameOfGameHandler {

    @Override
    public HandballPlayer getPlayerObject(String[] fragments) {
        int score = Integer.parseInt(fragments[4]) * 2 > Integer.parseInt(fragments[5])
                ? Integer.parseInt(fragments[4]) * 2 - Integer.parseInt(fragments[5]) : 0;
        return new HandballPlayer(fragments[0], fragments[1], fragments[3], Integer.parseInt(fragments[4]), score);
    }

}
