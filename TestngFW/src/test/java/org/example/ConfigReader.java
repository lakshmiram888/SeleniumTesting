package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Baseclass1 {
    Properties config = new Properties();
    FileInputStream td;

    public Baseclass1() throws IOException {
        td = new FileInputStream("src/test/Resources/Input.properties");
        config.load(td);
        td.close();
    }

    public String getProperty(String key) {
        return config.getProperty(key);

    }
}
