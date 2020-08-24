package com.gmail.kpisid;

import java.io.IOException;
import java.io.FileWriter;

@SaveTo(path = "D:\\ProgKiev\\JavaPro\\DZ\\JP_3_02_Annotations2\\1.txt")

public class TextContainer {
    public String s = "Hello world!";

    public TextContainer() {
    }

    @Saver
    public void save(String path) throws IOException {
        FileWriter w = new FileWriter(path);
        try {
            w.write(s);
        } finally {
            w.close();
        }
    }
}
