package org.example.Files.Statistic.Simple;

public class DoubleSimpleStatistic {
    private static int countDoubles = 0;

    public void sendLineForStatistic(){
        countDoubles++;
    }

    public void doubleStatistic(){
        System.out.printf("Count doubles: %d \n", countDoubles);
    }
}
