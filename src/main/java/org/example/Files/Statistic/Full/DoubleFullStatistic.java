package org.example.Files.Statistic.Full;

public class DoubleFullStatistic {

    private int countDoubles = 0;
    private double maxDoubles = 0;
    private double minDoubles = 0;
    private double sumDoubles = 0;


    public void sendLineForStatistic(Double num) {
        countingDouble(num);
    }

    private void countingDouble(Double num){
        countDoubles++;

        if(num > maxDoubles){
            maxDoubles = num;
        }

        if(num < minDoubles || minDoubles == 0){
            minDoubles = num;
        }

        sumDoubles = sumDoubles + num;
    }

    public void doubleStatistic(){
        System.out.println("==========double==========");
        System.out.printf("Count doubles: %d \n", countDoubles);
        if(countDoubles == 0){
            return;
        }
        System.out.printf("Max doubles: %f \n", maxDoubles);
        System.out.printf("Min doubles: %f \n", minDoubles);
        System.out.printf("Sum doubles: %f \n", sumDoubles);
        System.out.printf("Avg doubles: %f \n", sumDoubles/countDoubles);
    }
}
