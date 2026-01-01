package org.example.Files.Enums;

public enum Options {
    INFO("-i", 0),
    FILE_PATH("-o", 1),
    FILE_NAME("-p", 1),
    FILE_ADDITIONS("-a", 0),
    FILE_SIMPLE_STATISTIC("-s", 0),
    FILE_FULL_STATISTIC("-f", 0);


    private final String optionsCommand;
    private boolean isUsed;
    private final Integer countArguments;

    Options(String optionsCommand, Integer countArguments) {
        this.optionsCommand = optionsCommand;
        this.isUsed = false;
        this.countArguments = countArguments;
    }

    public String getOptionsCommand() {
        return optionsCommand;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public Integer getCountArguments() {
        return countArguments;
    }
}
