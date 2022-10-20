package csv.handle;

import players.Player;

import java.util.List;

public abstract class PlayerValueHandler<T extends Player> implements ParsingValueHandler<T> {
    protected final List<T> resultList;

    protected PlayerValueHandler(List<T> resultList) {
        this.resultList = resultList;
    }

    @Override
    public List<T> getResult() {
        return resultList;
    }
}
