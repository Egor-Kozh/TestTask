package org.example.Files;

import org.example.Files.Enums.DataStatistic;
import org.example.Files.Enums.FileType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilePrinter {

    private PrintWriter pw = null;

    private File file = null;

    private boolean canWrite = false;

    private final FileType FILE_TYPE;

    private static String filePath = "";

    private static String filePrefix = "";

    private static boolean fileAdditions = false;

    public FilePrinter(FileType FILE_TYPE) {
        this.FILE_TYPE = FILE_TYPE;
    }

    public static void setFilePath(String filePath) {
        FilePrinter.filePath = filePath;
    }

    public static void setFilePrefix(String filePrefix) {
        FilePrinter.filePrefix = filePrefix;
    }

    public static void setFileAdditions(boolean fileAdditions) {
        FilePrinter.fileAdditions = fileAdditions;
    }

    private void createFile() throws IOException {
        try {
            file = new File(filePath + filePrefix + FILE_TYPE.getFileName() + ".txt");

            if (filePath != "") {
                File parentDir = file.getParentFile();
                parentDir.mkdirs();
            }

            createWriteStream();
            canWrite = true;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    private void createWriteStream() throws IOException {
        pw = new PrintWriter(new FileWriter(file, fileAdditions));
        canWrite = true;
    }

    public <T> void printLine(T line) throws IOException {
        if (file == null) {
            createFile();
        }
        if (!canWrite) {
            createWriteStream();
        }
        try {
            pw.println(line);
            if(FileApp.getDataStatistic() == DataStatistic.SIMPLE){
                FileSimpleDescription.sendLineForStatistic(line);
            }
            else{
                FileFullDescription.sendLineForStatistic(line);
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
        if (!fileAdditions) {
            fileAdditions = true;
        }
    }
}
