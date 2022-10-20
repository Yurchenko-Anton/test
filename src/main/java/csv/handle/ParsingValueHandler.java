package csv.handle;

import java.util.List;

public interface ParsingValueHandler<T> {

    void handle(String[] fragments);

    List<T> getResult();
}
