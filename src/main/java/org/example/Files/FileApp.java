package org.example.Files;

import org.example.Files.Enums.DataStatistic;
import org.example.Files.Enums.Options;
import org.example.Files.Statistic.FileStatistic;

import java.util.ArrayList;
import java.util.Collections;

public class FileApp {

    private final ArrayList<String> files = new ArrayList<>();

    private final FilesReader filesReader = new FilesReader();

    private final FileStatistic fileStatistic = FileStatistic.getInstance();


    public void start(String[] args) {
        try {
            if(args.length == 1 && args[0].equals(Options.INFO.getOptionsCommand())){
                FileInfo.printInfo();
                return;
            }
            filesList(args);
            for (int i = 0; i < args.length - files.size(); i++) {
                if (args[i].equals(Options.INFO.getOptionsCommand())){
                    FileInfo.printInfo();
                    break;
                } else if (args[i].equals(Options.FILE_PATH.getOptionsCommand())) {
                    CheckArguments.check(args, i, Options.FILE_PATH);
                    FileCreator.setFilePath(args[i + 1]);
                    i++;
                } else if (args[i].equals(Options.FILE_NAME.getOptionsCommand())) {
                    CheckArguments.check(args, i, Options.FILE_NAME);
                    FileCreator.setFilePrefix(args[i + 1]);
                    i++;
                } else if (args[i].equals(Options.FILE_ADDITIOS.getOptionsCommand())) {
                    FileCreator.setFileAdditions(true);
                } else if (args[i].equals(Options.FILE_SIMPLE_STATISTIC.getOptionsCommand())) {
                    if (fileStatistic.getDataStatistic() != null) {
                        throw new RuntimeException("Метод для статичтики должен быть 1!");
                    }
                    fileStatistic.setDataStatistic(DataStatistic.SIMPLE);
                }
                else if (args[i].equals(Options.FILE_FULL_STATISTIC.getOptionsCommand())) {
                    if (fileStatistic.getDataStatistic() != null) {
                        throw new RuntimeException("Метод для статичтики должен быть 1!");
                    }
                    fileStatistic.setDataStatistic(DataStatistic.FULL);
                }else {
                    throw new RuntimeException("Не существующая опция! Используйте -i для информации!");
                }
            }

            filesReader.start(files);
            if (fileStatistic.getDataStatistic() != null) {
                fileStatistic.getStatistic();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private void filesList(String[] args) throws RuntimeException {
        for (int i = args.length - 1; i >= 0; i--) {
            if (args[i].endsWith(".txt")) {
                files.add(args[i]);
            } else {
                break;
            }
        }

        if (files.isEmpty()) {
            throw new RuntimeException("Нету файлов для обработки!");
        }

        Collections.reverse(files);
    }
}
