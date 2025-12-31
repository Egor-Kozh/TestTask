package org.example.Files.Statistic.Full;

public class IntegerFullStatistic {

    private int countIntegers = 0;
    private int maxIntegers = 0;
    private int minIntegers = 0;
    private int sumIntegers = 0;

    public void sendLineForStatistic(Integer num){
        countingInteger(num);
    }

    private void countingInteger(Integer num){
        countIntegers++;

        if(num > maxIntegers){
            maxIntegers = num;
        }

        if(num < minIntegers || minIntegers == 0){
            minIntegers = num;
        }

        sumIntegers = sumIntegers + num;
    }

    public void integerStatistic(){
        System.out.println("==========integer==========");
        System.out.printf("Count integers: %d \n", countIntegers);
        if(countIntegers == 0){
            return;
        }
        System.out.printf("Max integers: %d \n", maxIntegers);
        System.out.printf("Min integers: %d \n", minIntegers);
        System.out.printf("Sum integers: %d \n", sumIntegers);
        System.out.printf("Avg integers: %f \n", (double) sumIntegers/countIntegers);
    }
}
