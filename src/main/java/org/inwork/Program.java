package org.inwork;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Program {
    public static void main(String[] args) throws IOException {
        /**
         * write to file 9 values (from 0 to 3) using 3 bytes.
         */

        ThreeBytes threeBytes = new ThreeBytes();
        threeBytes.writeThreeBytesFile("threeBytes.txt");

        /**
         * copy files from folder to backup folder.
         */

        try {
            BackUpFolder backUpFolder = new BackUpFolder();
            String location = "/Users/olegmonogarov/IdeaProjects/java_core_advanced_5/src/main/java";
            String target = "./backup";
            File locFile = new File(location);
            File tarFile = new File(target);
            backUpFolder.copyDirectory(locFile, tarFile);
        } catch (IOException ex) {
            Logger.getLogger(BackUpFolder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

