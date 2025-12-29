package org.example.Files;

import org.example.Files.Enums.FileType;

import java.io.IOException;

public class FileFilter {

    private final FilePrinter filePrinterString = new FilePrinter(FileType.STRING);

    private final FilePrinter filePrinterInteger = new FilePrinter(FileType.INT);

    private final FilePrinter filePrinterDouble = new FilePrinter(FileType.DOUBLE);


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
                filePrinterInteger.printLine(line);
                break;
            case FileType.DOUBLE:
                filePrinterDouble.printLine(line);
                break;
            case FileType.STRING:
                filePrinterString.printLine(line);
                break;
        }
    }

    private FileType searchType(String line) {
        try {
            Integer.parseInt(line);
            return FileType.INT;
        } catch (NumberFormatException e) {
        }
        try {
            Double.parseDouble(line);
            return FileType.DOUBLE;
        } catch (NumberFormatException e) {
        }
        return FileType.STRING;
    }
}
