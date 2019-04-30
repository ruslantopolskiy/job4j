package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values;

    public Config() {
        this.values = new Properties();
        this.init();
    }

    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("app.properties")) {
            values.load(in);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}