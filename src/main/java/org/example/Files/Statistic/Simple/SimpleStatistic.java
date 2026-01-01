package org.example.Files.Statistic.Simple;

public class SimpleStatistic {

    private final IntegerSimpleStatistic integerSimpleStatistic = new IntegerSimpleStatistic();

    private final DoubleSimpleStatistic doubleSimpleStatistic = new DoubleSimpleStatistic();

    private final StringSimpleStatistic stringSimpleStatistic = new StringSimpleStatistic();


    public void getSimpleStatistic() {
        integerSimpleStatistic.integerStatistic();
        doubleSimpleStatistic.doubleStatistic();
        stringSimpleStatistic.stringStatistic();
    }

    public <T> void countStatistic(T line) {
        if (line instanceof Integer) {
            integerSimpleStatistic.sendLineForStatistic();
        } else if (line instanceof Double) {
            doubleSimpleStatistic.sendLineForStatistic();
        } else {
            stringSimpleStatistic.sendLineForStatistic();
        }
    }
}
