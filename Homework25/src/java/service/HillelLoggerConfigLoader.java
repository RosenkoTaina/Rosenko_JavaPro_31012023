package service;
import java.io.IOException;
import java.util.Properties;

public class HillelLoggerConfigLoader {

    private final static String CONFIG = "logger.properties";
    private final Properties properties;

    public HillelLoggerConfigLoader() throws IOException {
        PropertyReader propertyReader = new PropertyReader();
        this.properties = propertyReader.getProperties(CONFIG);
    }

    public Properties getProperties() {
        return properties;
    }
}
