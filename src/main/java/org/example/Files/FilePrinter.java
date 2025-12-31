package org.example.Files;

import org.example.Files.Enums.FileType;
import org.example.Files.Statistic.FileStatistic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinter {

    private PrintWriter pw = null;

    private File file = null;

    private boolean isSendStatistic = true;

    private boolean canWrite = false;

    private  FileCreator fileCreator = null;

    private final FileStatistic fileStatistic = FileStatistic.getInstance();


    public FilePrinter(FileType FILE_TYPE) {
        fileCreator = new FileCreator(FILE_TYPE);
    }

    private void createWriteStream() throws IOException {
        if(file == null){
            file = fileCreator.createFile();
        }
        pw = new PrintWriter(new FileWriter(file, fileCreator.isFileAdditions()));
        canWrite = true;
    }

    public <T> void printLine(T line) throws IOException {
        if (!canWrite) {
            createWriteStream();
        }
        try {
            pw.println(line);
            if(isSendStatistic){
                isSendStatistic = fileStatistic.sendLineForStatistic(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void closePrint() {
        if (pw != null) {
            pw.close();
            canWrite = false;
        }
        if (!fileCreator.isFileAdditions()) {
            FileCreator.setFileAdditions(true);
        }
    }
}
