package checkCorrectFileFormat;

import checkCorrectFileFormat.exception.FileFormatException;

import java.io.File;
import java.io.FileNotFoundException;

public class CheckCorrectFileFormat {

    public void CheckFileFormat(File[] listFiles) throws FileFormatException, FileNotFoundException {
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.getName().substring(file.getName().lastIndexOf('.')).equals(".csv")) {
                    throw new FileFormatException("Sorry wrong format file");
                }
            }
        } else throw new FileNotFoundException();
    }

}
