package org.example.Files.Enums;

public enum Options {
    INFO("-i"),
    FILE_PATH("-o"),
    FILE_NAME("-p"),
    FILE_ADDITIOS("-a"),
    FILE_SIMPLE_STATISTIC("-s"),
    FILE_FULL_STATISTIC("-f");


    private final String optionsCommand;

    Options(String optionsCommand) {
        this.optionsCommand = optionsCommand;
    }

    public String getOptionsCommand() {
        return optionsCommand;
    }
}
