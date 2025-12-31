package org.example.Files.Statistic.Simple;

public class StringSimpleStatistic {

    private static int countStrings = 0;

    public void sendLineForStatistic(){
        countStrings++;
    }

    public void stringStatistic(){
        System.out.printf("Count strings: %d \n", countStrings);
    }
}
