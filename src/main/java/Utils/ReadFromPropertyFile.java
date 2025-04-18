package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFromPropertyFile {
    public static String GetDataFromPropFile(String Key) throws IOException {
        Properties properties = new Properties();
        String path = System.getProperty("user.dir")+"./src/main/resources/get.properties";
        FileInputStream fileInputStream = new FileInputStream(path);
        properties.load(fileInputStream);
      return properties.getProperty(Key);
    }
}
