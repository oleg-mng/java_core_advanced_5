package org.inwork;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeBytes {
    private byte option1 = 0;
    private byte option2 = 1;
    private byte option3 = 2;

    private enum en {
        option1, option2, option3
    };

    private byte[][] ar = new byte[][]{
            {option1, option1, option1},
            {option2, option2, option2},
            {option3, option3, option3},
    };

    public ThreeBytes() {

    }

    public void writeThreeBytesFile(String filename) {
        byte b;
        List<Byte> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            b = (byte) (ar[i][2] << 2);
            b = (byte) (b | ar[i][1]);
            b = (byte) (b << 2);
            b = (byte) (b | ar[i][0]);
            list.add(b);
        }
        System.out.println(Arrays.toString(list.toArray()));

            for (byte c : list) {
                System.out.println(Integer.toBinaryString(c & 255 | 256).substring(1));
            }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
            fileOutputStream.write(list.toString().getBytes());
            for (byte c : list) {
                fileOutputStream.write(Integer.toBinaryString(c & 255 | 256).substring(1).getBytes());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


