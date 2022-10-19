package checkCorrectFileFormat;

import checkCorrectFileFormat.exception.DirectoryIsEmpty;
import checkCorrectFileFormat.exception.WrongFormatException;

import java.io.File;

public class CheckCorrectFileFormat {

    public void CheckFileFormat(File[] listFiles) throws WrongFormatException, DirectoryIsEmpty {
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!file.getName().substring(file.getName().lastIndexOf('.')).equals(".csv")) {
                    throw new WrongFormatException("Sorry wrong format file");
                }
            }
        } else throw new DirectoryIsEmpty("Directory is Empty");
    }

}
