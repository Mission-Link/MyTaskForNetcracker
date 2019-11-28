package strikepackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    private WebDriver webDriver;

    //constructors

    public Browser() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
//        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    /**
     * Constructor with String param
     *
     * @param browserName specified WebDriver name
     *                    that has to be created
     */
    public Browser(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                webDriver = new OperaDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }//end of constructor with String param

    public WebDriver getWebDriver() {
        return webDriver;
    }
}//end of class Browser
