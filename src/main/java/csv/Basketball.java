package csv;

import players.BasketballPlayer;

public class Basketball implements NameOfGameHandler {


    @Override
    public BasketballPlayer getPlayerObject(String[] fragments) {
        int score = (Integer.parseInt(fragments[4]) * 2) + Integer.parseInt(fragments[5]) + Integer.parseInt(fragments[6]);
        return new BasketballPlayer(fragments[0], fragments[1], fragments[3], Integer.parseInt(fragments[4]), score);
    }

}
