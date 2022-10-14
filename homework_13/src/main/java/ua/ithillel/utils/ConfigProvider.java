package ua.ithillel.utils;

import java.io.IOException;
import java.util.Properties;

public final class ConfigProvider {
    public static final String CONFIG_PATH = "config.properties";
    private static final Properties prop = initProperties();
    public static final String BROWSER = prop.getProperty("browser");
    public static final String BASE_URL = prop.getProperty("base.url");
    public static final int IMPLICITLY_WAIT = Integer.parseInt(prop.getProperty("implicitly.wait"));
    private ConfigProvider() {

    }

    private static Properties initProperties() {
        Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemResourceAsStream(CONFIG_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Could not load properties from" + CONFIG_PATH);

        }
        return properties;
    }
}
