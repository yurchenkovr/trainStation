package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class Configs {

    public ArrayList<String> getProperties() {
        FileInputStream fs;
        Properties property = new Properties();
        String url = null;
        String login = null;
        String password = null;
        String driver = null;

        try {
            fs = new FileInputStream("C:\\Users\\vital\\IdeaProjects\\trainStation\\src\\main\\resources\\config.properties");
            property.load(fs);

            url = property.getProperty("url");
            login = property.getProperty("login");
            password = property.getProperty("password");
            driver = property.getProperty("driver");

        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> properties = new ArrayList<>();
        properties.add(url);
        properties.add(login);
        properties.add(password);
        properties.add(driver);
        return properties;
    }
}
