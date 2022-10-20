package csv.handle;

import players.HandballPlayer;

import java.util.List;

public class HandballParsingValueHandler extends PlayerValueHandler<HandballPlayer> {

    public HandballParsingValueHandler(List<HandballPlayer> resultList) {
        super(resultList);
    }

    @Override
    public void handle(String[] fragments) {
        int score = Integer.parseInt(fragments[4]) * 2 > Integer.parseInt(fragments[5])
                ? Integer.parseInt(fragments[4]) * 2 - Integer.parseInt(fragments[5]) : 0;
        resultList.add(new HandballPlayer(fragments[0], fragments[1], fragments[3], Integer.parseInt(fragments[4]), score));
    }
}
