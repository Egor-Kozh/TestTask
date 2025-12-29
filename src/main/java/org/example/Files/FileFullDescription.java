package org.example.Files;

public class FileFullDescription {
    private static int countIntegers = 0;
    private static int maxIntegers = 0;
    private static int minIntegers = 0;
    private static int sumIntegers = 0;

    private static int countDoubles = 0;
    private static double maxDoubles = 0;
    private static double minDoubles = 0;
    private static double sumDoubles = 0;

    private static int countStrings = 0;
    private static int maxString = 0;
    private static int minString = 0;

    public static <T> void sendLineForStatistic(T line){
        if (line instanceof Integer num){
            countingInteger(num);
        }
        else if (line instanceof Double num){
            countingDouble(num);
        }
        else{
            String str = (String) line;
            countingString(str);
        }
    }

    private static void countingInteger(Integer num){
        countIntegers++;

        if(num > maxIntegers){
            maxIntegers = num;
        }

        if(num < minIntegers || minIntegers == 0){
            minIntegers = num;
        }

        sumIntegers = sumIntegers + num;
    }

    private static void countingDouble(Double num){
        countDoubles++;

        if(num > maxDoubles){
            maxDoubles = num;
        }

        if(num < minDoubles || minDoubles == 0){
            minDoubles = num;
        }

        sumDoubles = sumDoubles + num;
    }

    private static void countingString(String str){
        countStrings++;

        if(str.length() > maxString){
            maxString = str.length();
        }

        if(str.length() < minString || minString == 0){
            minString = str.length();
        }
    }

    public static void printInfo(){
        System.out.println("==========STATISTIC==========");
        integerStatistic();
        doubleStatistic();
        stringStatistic();
    }

    private static void integerStatistic(){
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

    private static void doubleStatistic(){
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

    private static void stringStatistic(){
        System.out.println("==========string==========");
        System.out.printf("Count strings: %d \n", countStrings);
        if(countStrings == 0){
            return;
        }
        System.out.printf("Max strings: %d \n", maxString);
        System.out.printf("Min strings: %d \n", minString);
    }
}
