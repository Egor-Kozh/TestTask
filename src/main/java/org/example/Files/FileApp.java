package org.example.Files;

import org.example.Files.Enums.DataStatistic;
import org.example.Files.Supportive.FileInfo;
import org.example.Files.Supportive.FileAdditions;
import org.example.Files.Supportive.FilePathResult;
import org.example.Files.Supportive.FilePrefix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileApp {
    private final ArrayList<String> files = new ArrayList<>();

    private DataStatistic dataStatistic = null;

    private final FilesReader filesReader = new FilesReader();

    public DataStatistic getDataStatistic() {
        return dataStatistic;
    }

    public void setDataStatistic(DataStatistic dataStatistic) {
        this.dataStatistic = dataStatistic;
    }

    public void start(String[] args) throws IOException {
        filesList(args);
        for(String file : files){
            System.out.println(file);
        }
        for(int i = 0; i < args.length - files.size(); i++){
            switch (args[i]){
                case "-i":
                    FileInfo.printInfo();
                    return;
                case "-o":
                    FilePathResult.pathResult(args[i+1]);
                    i++;
                    break;
                case "-p":
                    FilePrefix.filePrefix(args[i+1]);
                    i++;
                    break;
                case "-a":
                    FileAdditions.fileAdditions();
                    break;
                case "-s":
                    if(getDataStatistic() != null){
                        System.out.println("ошибка!");
                    }
                    setDataStatistic(DataStatistic.SIMPLE);
                    break;
                case "-f":
                    if(getDataStatistic() != null){
                        System.out.println("ошибка!");
                    }
                    setDataStatistic(DataStatistic.FULL);
                    break;
            }
        }

        filesReader.start(files);
    }

    private void filesList(String[] args){
        for(int i = args.length - 1; i >= 0; i--){
            if(args[i].endsWith(".txt")){
                files.add(args[i]);
            }else{
                break;
            }
        }

        Collections.reverse(files);
    }
}
