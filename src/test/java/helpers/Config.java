package helpers;
import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import helpers.LogMessage;

import static helpers.Constant.configPath;
public class Config {
    private String browser;
    private String Appurl;

/*    public Config(String browser, String Appurl){
        this.browser = browser;
        this.Appurl = Appurl;
    }*/

    public static String getPropValues(String val) throws IOException {
        InputStream input = null;
        Properties prop = new Properties();
//        String propFileName = "Config.properties";
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
//        InputStream inputStream = configPath;
        input = new FileInputStream(configPath);
        if (input != null) {
            prop.load(input);
        } else {
            throw new FileNotFoundException("property file '" + configPath + "' not found");
        }
         return prop.getProperty(val);
    }

    public String getBrowser(){
        try {
            browser= Config.getPropValues("BROWSER");
        } catch (IOException e) {
            LogMessage.error(e.getMessage());
        }
        return browser;
    }

/*    public void setBrowser(String browser){
        try {
            this.browser= Config.getPropValues("BROWSER");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    public String getAppurl(){
        try {
            Appurl= Config.getPropValues("APPURL");
        } catch (IOException e) {
            LogMessage.error(e.getMessage());
        }
        return Appurl;
    }

/*    public void setAppurl(String Appurl){
        try {
            this.Appurl= Config.getPropValues("APPURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


}

