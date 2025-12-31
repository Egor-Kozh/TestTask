package org.example;

import org.example.Files.FileApp;
import org.example.Files.Statistic.FileStatistic;

import java.io.IOException;

public class Main {
    private static final FileApp fileApp = new FileApp();

    public static void main(String[] args) throws IOException {
        fileApp.start(args);
    }
}