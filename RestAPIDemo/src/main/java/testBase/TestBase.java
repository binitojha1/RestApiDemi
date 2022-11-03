package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class TestBase {

    public Properties properties ;



    public TestBase(){
       
       try {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/config.properties");
        this.properties = new Properties();
        this.properties.load(inputStream);

    } catch (Exception e) {
        
        e.printStackTrace();
    }
    }

}
