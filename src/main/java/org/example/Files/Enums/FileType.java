package org.example.Files.Enums;

public enum FileType {

    STRING("strings"), INT("integers"), DOUBLE("doubles");

    private String fileName;

    FileType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
