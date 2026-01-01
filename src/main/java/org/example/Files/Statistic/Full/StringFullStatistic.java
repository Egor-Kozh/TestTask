package org.example.Files.Statistic.Full;

public class StringFullStatistic {

    private int countStrings = 0;
    private int maxString = 0;
    private int minString = 0;


    public void sendLineForStatistic(String line) {
        countingString(line);
    }

    private void countingString(String str) {
        countStrings++;

        if (str.length() > maxString) {
            maxString = str.length();
        }

        if (str.length() < minString || minString == 0) {
            minString = str.length();
        }
    }

    public void stringStatistic() {
        System.out.println("==========string==========");
        System.out.printf("Count strings: %d \n", countStrings);
        if (countStrings == 0) {
            return;
        }
        System.out.printf("Max strings: %d \n", maxString);
        System.out.printf("Min strings: %d \n", minString);
    }
}
