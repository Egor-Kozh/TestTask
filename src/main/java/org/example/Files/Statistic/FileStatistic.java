package org.example.Files.Statistic;

import org.example.Files.Enums.DataStatistic;
import org.example.Files.Statistic.Full.FullStatistic;
import org.example.Files.Statistic.Simple.SimpleStatistic;

public class FileStatistic {

    private static FileStatistic instance;

    private DataStatistic dataStatistic = null;

    private final FullStatistic fullStatistic = new FullStatistic();

    private final SimpleStatistic simpleStatistic = new SimpleStatistic();

    private FileStatistic() {
    }

    public static FileStatistic getInstance() {
        if (instance == null) {
            instance = new FileStatistic();
        }
        return instance;
    }

    public DataStatistic getDataStatistic() {
        return dataStatistic;
    }

    public void setDataStatistic(DataStatistic dataStatistic) {
        this.dataStatistic = dataStatistic;
    }


    public void getStatistic() {
        printInfo();
        if (dataStatistic.equals(DataStatistic.FULL)) {
            fullStatistic.getFullStatistic();
        } else if (dataStatistic.equals(DataStatistic.SIMPLE)) {
            simpleStatistic.getSimpleStatistic();
        } else {
            throw new RuntimeException("Ошибка");
        }
    }

    public <T> boolean sendLineForStatistic(T line) {
        if(dataStatistic == null){
            return false;
        }
        if (dataStatistic.equals(DataStatistic.FULL)) {
            fullStatistic.countStatistic(line);
            return true;
        } else if (dataStatistic.equals(DataStatistic.SIMPLE)) {
            simpleStatistic.countStatistic(line);
            return true;
        } else {
            return false;
        }
    }

    private void printInfo() {
        System.out.println("==========STATISTIC==========");
    }
}
