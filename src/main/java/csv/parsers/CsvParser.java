package csv.parsers;

import csv.handle.ParsingValueHandler;

import java.io.BufferedReader;
import java.io.IOException;

public class CsvParser {
    ParsingValueHandler<?> parsingValueHandler;
    private final char splitIterator;

    public CsvParser(ParsingValueHandler<?> parsingValueHandler, char splitIterator) {
        this.parsingValueHandler = parsingValueHandler;
        this.splitIterator = splitIterator;
    }

    public void parse(BufferedReader reader) throws IOException {
        String line;
        String[] fragments;
        while ((line = reader.readLine()) != null) {
            fragments = line.split(String.valueOf(splitIterator));
            parsingValueHandler.handle(fragments);
        }
    }
}
