package org.example.Files.Statistic.Simple;

public class IntegerSimpleStatistic {

    private static int countIntegers = 0;

    public void sendLineForStatistic(){
        countIntegers++;
    }

    public void integerStatistic(){
        System.out.printf("Count integers: %d \n", countIntegers);
    }
}
