package org.inwork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.copy;

public class Program {
    public static void main(String[] args) throws IOException {
        /**
         * write to file 9 values (from 0 to 3) using 3 bytes
         */

        ThreeBytes threeBytes = new ThreeBytes();
        threeBytes.writeThreeBytesFile("threeBytes.txt");

        /**
         * copy files from folder to backup folder
         */

        copyBackUpFiles(".");

    }

    private static void copyBackUpFiles(String p) throws IOException {
        List<String> list = new ArrayList<>();
        String k = ".";
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
//        File dest = new File("./backupT");
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isFile()) {
                for (int j = 0; j < dir.length; j++) {
                    try {
                        Files.copy(dir[i].toPath(), Path.of("./backupT"));
                    } catch (IOException ex) {
                        ex.getMessage();
                    }
                }

            }
        }

    }
}