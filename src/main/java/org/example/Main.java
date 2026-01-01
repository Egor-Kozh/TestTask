package org.example;

import org.example.Files.FileApp;

public class Main {
    private static final FileApp fileApp = new FileApp();

    public static void main(String[] args) {
        fileApp.start(args);
    }
}