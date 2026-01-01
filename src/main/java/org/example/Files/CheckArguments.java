package org.example.Files;

import org.example.Files.Enums.Options;
import org.example.Files.Statistic.FileStatistic;

public class CheckArguments {

    private static final FileStatistic fileStatistic = FileStatistic.getInstance();

    public static void check(String[] options, int i, Options argName) throws RuntimeException {
        if(argName.getCountArguments() == 0){
            checkNoArg(options, i, argName);
        } else if (argName.getCountArguments() == 1) {
            checkOneArg(options, i, argName);
        }

        checkReply(argName);

        if (argName.equals(Options.FILE_FULL_STATISTIC) || argName.equals(Options.FILE_SIMPLE_STATISTIC)) {
            if(fileStatistic.getDataStatistic() != null){
                throw new RuntimeException("Метод для статиcтики должен быть 1!");
            }
        }
    }

    private static void checkReply(Options argName) throws RuntimeException{
        if(argName.isUsed()){
            throw new RuntimeException(String.format("Опция %s уже используется!", argName));
        }else{
            argName.setUsed(true);
        }
    }

    private static void checkOneArg(String[] options, int i, Options argName) throws RuntimeException{
        if(i + 1 < options.length){
            if (options[i + 1].startsWith("-")) {
                throw new RuntimeException(String.format("Нет аргумента для %s!", argName));
            }
        }else{
            throw new RuntimeException(String.format("Нет аргумента для %s!", argName));
        }

        if(i + 2 < options.length){
            if (!options[i + 2].startsWith("-")) {
                throw new RuntimeException(String.format("Аргумента для %s! должен быть 1!", argName));
            }
        }
    }

    private static  void checkNoArg(String[] options, int i, Options argName) throws RuntimeException {
        if (i + 1 < options.length) {
            if (!options[i + 1].startsWith("-")) {
                throw new RuntimeException(String.format("Для опции %s нет должно быть аргумента!", argName));
            }
        }
    }
}
