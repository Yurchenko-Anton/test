package csv.handle;

import players.BasketballPlayer;

import java.util.List;

public class BasketballParsingValueHandler extends PlayerValueHandler<BasketballPlayer> {

    public BasketballParsingValueHandler(List<BasketballPlayer> resultList) {
        super(resultList);
    }

    @Override
    public void handle(String[] fragments) {
        int score = (Integer.parseInt(fragments[4]) * 2) + Integer.parseInt(fragments[5]) + Integer.parseInt(fragments[6]);
        resultList.add(new BasketballPlayer(fragments[0], fragments[1], fragments[3], Integer.parseInt(fragments[4]), score));
    }
}
