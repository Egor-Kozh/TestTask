package org.example.Files.Supportive;

import org.example.Files.FilePrinter;

public class FilePathResult {

    public static void pathResult(String path){
        FilePrinter.setFilePath(path + "/");
    }
}
