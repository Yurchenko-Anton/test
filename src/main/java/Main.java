import validations.CheckCorrectFileFormat;
import validations.exceptions.FileFormatException;
import players.Player;
import service.PlayersService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    private static final String path = "data";

    //Static only to be placed in main()
    private static final PlayersService playersService = new PlayersService();

    public static void main(String[] args) throws IOException, FileFormatException {
        HashMap<String, Player> players = new HashMap<>();
        File[] listFiles = new File(path).listFiles();

        new CheckCorrectFileFormat().CheckFileFormat(listFiles);
        // Can't be null
        for (File file : listFiles) {
            playersService.addPlayersToMap(playersService.countScore(playersService.getFromCsv(file)), players);
        }

        System.out.println(playersService.getMvp(players));
    }
}
