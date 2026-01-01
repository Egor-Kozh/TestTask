package org.example.Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FilesReader {

    private BufferedReader br = null;

    private final FileFilter fileFilter = new FileFilter();


    public void start(ArrayList<String> filesName) throws IOException {
        for (int i = 0; i < filesName.size(); i++) {
            try {
                br = new BufferedReader(new FileReader(filesName.get(i)));

                String line;
                while (true) {
                    line = br.readLine();
                    if (line == null) {
                        fileFilter.closePrint();
                        break;
                    }
                    fileFilter.filterLine(line);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                br.close();
            }
        }
    }
}
