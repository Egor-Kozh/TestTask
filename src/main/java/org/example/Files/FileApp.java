package org.example.Files;

import org.example.Files.Enums.DataStatistic;
import org.example.Files.Enums.Options;
import org.example.Files.Statistic.FileStatistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileApp {

    private final ArrayList<String> files = new ArrayList<>();

    private final FilesReader filesReader = new FilesReader();

    private final FileStatistic fileStatistic = FileStatistic.getInstance();


    public void start(String[] args) {
        try {
            if (args.length == 1 && args[0].equals(Options.INFO.getOptionsCommand())) {
                FileInfo.printInfo();
                return;
            }

            String[] options = filesList(args);
            for (int i = 0; i < options.length; i++) {
                if (args[i].equals(Options.INFO.getOptionsCommand())) {
                    FileInfo.printInfo();
                    break;
                } else if (args[i].equals(Options.FILE_PATH.getOptionsCommand())) {
                    CheckArguments.check(options, i, Options.FILE_PATH);
                    FileCreator.setFilePath(args[i + 1]);
                    i++;
                } else if (args[i].equals(Options.FILE_NAME.getOptionsCommand())) {
                    CheckArguments.check(options, i, Options.FILE_NAME);
                    FileCreator.setFilePrefix(args[i + 1]);
                    i++;
                } else if (args[i].equals(Options.FILE_ADDITIONS.getOptionsCommand())) {
                    CheckArguments.check(options, i, Options.FILE_ADDITIONS);
                    FileCreator.setFileAdditions(true);
                } else if (args[i].equals(Options.FILE_SIMPLE_STATISTIC.getOptionsCommand())) {
                    CheckArguments.check(options, i, Options.FILE_SIMPLE_STATISTIC);
                    fileStatistic.setDataStatistic(DataStatistic.SIMPLE);
                } else if (args[i].equals(Options.FILE_FULL_STATISTIC.getOptionsCommand())) {
                    CheckArguments.check(options, i, Options.FILE_FULL_STATISTIC);
                    fileStatistic.setDataStatistic(DataStatistic.FULL);
                } else {
                    throw new RuntimeException(String.format("Не существующая опция %s! Используйте -i для информации!", options[i]));
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

    private String[] filesList(String[] args) throws RuntimeException {
        List<String> options = new ArrayList<>(Arrays.asList(args.clone()));

        for (int i = args.length - 1; i >= 0; i--) {
            if (args[i].endsWith(".txt")) {
                files.add(args[i]);
                options.removeLast();
            } else {
                break;
            }
        }

        if (files.isEmpty()) {
            throw new RuntimeException("Нету файлов для обработки!");
        }

        Collections.reverse(files);

        return options.toArray(new String[0]);
    }
}
