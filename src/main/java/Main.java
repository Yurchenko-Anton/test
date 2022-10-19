import checkCorrectFileFormat_andMVP.CheckCorrectFileFormat;
import exception.DirectoryIsEmpty;
import exception.WrongFormatException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, DirectoryIsEmpty, WrongFormatException {
        System.out.println(new CheckCorrectFileFormat().CheckFileFormat("data"));
    }
}
