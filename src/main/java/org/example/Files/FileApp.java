package org.example.Files;

import org.example.Files.Enums.DataStatistic;
import org.example.Files.Statistic.FileStatistic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileApp {

    private final ArrayList<String> files = new ArrayList<>();

    private final FilesReader filesReader = new FilesReader();

    private final FileStatistic fileStatistic = FileStatistic.getInstance();


    public void start(String[] args) throws IOException {
        filesList(args);
        for (int i = 0; i < args.length - files.size(); i++) {
            switch (args[i]) {
                case "-i":
                    FileInfo.printInfo();
                    return;
                case "-o":
                    FileCreator.setFilePath(args[i + 1]);
                    i++;
                    break;
                case "-p":
                    FileCreator.setFilePrefix(args[i + 1]);
                    i++;
                    break;
                case "-a":
                        FileCreator.setFileAdditions(true);
                    break;
                case "-s":
                    if (fileStatistic.getDataStatistic() != null) {
                        System.out.println("ошибка!");
                    }
                    fileStatistic.setDataStatistic(DataStatistic.SIMPLE);
                    break;
                case "-f":
                    if (fileStatistic.getDataStatistic() != null) {
                        System.out.println("ошибка!");
                    }
                    fileStatistic.setDataStatistic(DataStatistic.FULL);
                    break;
            }
        }

        filesReader.start(files);
        if(fileStatistic.getDataStatistic() != null){
            fileStatistic.getStatistic();
        }

    }

    private void filesList(String[] args) {
        for (int i = args.length - 1; i >= 0; i--) {
            if (args[i].endsWith(".txt")) {
                files.add(args[i]);
            } else {
                break;
            }
        }

        Collections.reverse(files);
    }
}
