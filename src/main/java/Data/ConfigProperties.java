package Data;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

    private static Properties properties;

    static {
        properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemResource("config.properties").openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
