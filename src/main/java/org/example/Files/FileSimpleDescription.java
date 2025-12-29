package org.example.Files;

public class FileSimpleDescription {

    private static int countIntegers = 0;
    private static int countDoubles = 0;
    private static int countStrings = 0;

    public static <T> void sendLineForStatistic(T line){
        if (line instanceof Integer){
            countIntegers++;
        }
        else if (line instanceof Double){
            countDoubles++;
        }
        else{
            countStrings++;
        }
    }

    public static void printInfo(){
        System.out.println("==========STATISTIC==========");
        System.out.printf("Count integers: %d \n", countIntegers);
        System.out.printf("Count doubles: %d \n", countDoubles);
        System.out.printf("Count strings: %d \n", countStrings);
    }
}
