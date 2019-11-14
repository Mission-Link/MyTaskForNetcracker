import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.omg.CORBA.UserException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class DerpyTester {
    private WebDriver browser;

    //constructors

    public DerpyTester() {
        WebDriverManager.chromedriver().setup();
        browser = new ChromeDriver();
    }

    public DerpyTester(String browserName) {
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                browser = new ChromeDriver();
                break;
            case "opera":
                WebDriverManager.operadriver().setup();
                browser = new OperaDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                browser = new ChromeDriver();
                break;
        }

    }//end of constructor with String param

    //methods

    void maximizeWindow(){
        browser.manage().window().maximize();
    }

    void exitBrowser() {
        browser.close();
        browser.quit();
    }

    WebDriver getBrowser() {
        return browser;
    }

    void openURL(String url) {
        browser.get(url);
    }

    void click(String xpath){
        WebElement webElement = browser.findElement(By.xpath(xpath));

        if (!webElement.isDisplayed()) {
            System.out.println("Web Element by path " + xpath + " is not displayable");
            return;
        }
        else {
            try {
                webElement.click();
//                webElement.sendKeys(Keys.RETURN); //press Enter key
            } catch (Exception e) {
                System.out.println("Exception!\n Impossible to click element by path: " + xpath);
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }//end of method click()

    void setValue(String xpath, String text) {
        browser.findElement(By.xpath(xpath)).sendKeys(text);
    }

    boolean checkElementVisible(String xpath) {
        return browser.findElement(By.xpath(xpath)).isDisplayed();
    }

    void takeScreenshot() {
        String uniqueScreenshotName = generateUniqueDT();

        File screenDir = new File("screenshots");
        if (!screenDir.exists()) {
            screenDir.mkdir();
        }
        File scrFile = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenDir.getPath() +
                    File.separator + "screenshot_" + uniqueScreenshotName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Helper method used to generate unique screenshot name
     */
    private static String generateUniqueDT() {
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HHmmss");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("ddMMYY");
        String f1 = formatter1.format(localTime);
        String f2 = formatter2.format(localDate);
        String merge = f1 + "_" + f2;
        return merge;
    }

}//end of class DerpyTester
