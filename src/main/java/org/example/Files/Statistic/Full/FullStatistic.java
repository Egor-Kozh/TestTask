package org.example.Files.Statistic.Full;

public class FullStatistic {

    private final IntegerFullStatistic integerFullStatistic = new IntegerFullStatistic();

    private final DoubleFullStatistic doubleFullStatistic = new DoubleFullStatistic();

    private final StringFullStatistic stringFullStatistic = new StringFullStatistic();

    public void getFullStatistic(){
        integerFullStatistic.integerStatistic();
        doubleFullStatistic.doubleStatistic();
        stringFullStatistic.stringStatistic();
    }

    public <T> void countStatistic(T line){
        if(line instanceof Integer){
            integerFullStatistic.sendLineForStatistic((Integer) line);
        } else if (line instanceof  Double) {
            doubleFullStatistic.sendLineForStatistic((Double) line);
        }else{
            stringFullStatistic.sendLineForStatistic((String) line);
        }
    }
}
