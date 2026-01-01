package org.example.Files;

import org.example.Files.Enums.FileType;

import java.io.File;

public class FileCreator {

    private final FileType FILE_TYPE;

    private static String filePath = "";

    private static String filePrefix = "";

    private static boolean fileAdditions = false;

    public FileCreator(FileType FILE_TYPE) {
        this.FILE_TYPE = FILE_TYPE;
    }

    public static void setFilePath(String filePath) {
        FileCreator.filePath = filePath + "/";
    }

    public static void setFilePrefix(String filePrefix) {
        FileCreator.filePrefix = filePrefix;
    }

    public static void setFileAdditions(boolean fileAdditions) {
        FileCreator.fileAdditions = fileAdditions;
    }

    public boolean isFileAdditions() {
        return fileAdditions;
    }


    public File createFile() {
        try {
            File file = new File(filePath + filePrefix + FILE_TYPE.getFileName() + ".txt");

            if (filePath != "") {
                File parentDir = file.getParentFile();
                parentDir.mkdirs();
            }

            return file;
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
