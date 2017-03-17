package step_definitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import helpers.Config;
//import helpers.Log;
import helpers.LogMessage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static helpers.Config.getPropValues;
import static helpers.Constant.*;
public class Hooks{
    public static WebDriver driver;
    private Config config;

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() throws MalformedURLException, Throwable {
        config = new Config();
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver(); }
        else if (config.getBrowser().equals("firefox")){
            driver = new FirefoxDriver(); }
        else if (config.getBrowser().equals("IE")){
            driver = new InternetExplorerDriver(); }
        else {
           LogMessage.error("Please check browser name");
        }
            driver.manage().timeouts().pageLoadTimeout(MIN_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(MED_WAIT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(MED_WAIT, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
    }

    @After
    /*
     * Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
        try {
        	 scenario.write("Current Page URL is " + driver.getCurrentUrl());
//            byte[] screenshot = getScreenshotAs(OutputType.BYTES);
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException somePlatformsDontSupportScreenshots) {
            LogMessage.error(somePlatformsDontSupportScreenshots.getMessage());
        }
        
        }
        driver.quit();
        
    }

}