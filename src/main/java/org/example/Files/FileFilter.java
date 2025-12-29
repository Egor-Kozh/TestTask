package org.example.Files;

import org.example.Files.Enums.FileType;

import java.io.IOException;

public class FileFilter {

    private final FilePrinter filePrinterString = new FilePrinter(FileType.STRING);

    private final FilePrinter filePrinterInteger = new FilePrinter(FileType.INT);

    private final FilePrinter filePrinterDouble = new FilePrinter(FileType.DOUBLE);

    private Integer lineInt = null;

    private Double lineDouble = null;

    public void filterLine(String line) throws IOException {
        if (line == null) {
            filePrinterString.closePrint();
            filePrinterInteger.closePrint();
            filePrinterDouble.closePrint();
            return;
        }

        FileType fileType = searchType(line);

        switch (fileType) {
            case FileType.INT:
                filePrinterInteger.printLine(lineInt);
                break;
            case FileType.DOUBLE:
                filePrinterDouble.printLine(lineDouble);
                break;
            case FileType.STRING:
                filePrinterString.printLine(line);
                break;
        }
    }

    private FileType searchType(String line) {
        try {
            lineInt = Integer.parseInt(line);
            return FileType.INT;
        } catch (NumberFormatException e) {
        }
        try {
            lineDouble = Double.parseDouble(line);
            return FileType.DOUBLE;
        } catch (NumberFormatException e) {
        }
        return FileType.STRING;
    }
}
