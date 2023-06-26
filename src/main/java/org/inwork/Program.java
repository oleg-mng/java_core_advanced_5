package org.inwork;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.copy;

public class Program {
    public static void main(String[] args) throws IOException {

        ThreeBytes threeBytes = new ThreeBytes();
        threeBytes.writeThreeBytesFile("threeBytes.txt");

//        copyBackUpFiles(".");

    }

    private static void copyBackUpFiles(String p) throws IOException {
        List<String> list = new ArrayList<>();
        File path = new File(new File(".").getCanonicalPath());
        File[] dir = path.listFiles();
        File dest = new File("./backup");
        for (int i = 0; i < dir.length; i++) {
            if (dir[i].isFile()) {
                for (int j = 0; j < dir.length; j++) {
                    Files.copy(dir[i].toPath(), dest.toPath());
                }

            }
        }
    }
}