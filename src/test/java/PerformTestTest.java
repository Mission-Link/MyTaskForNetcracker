//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class PerformTestTest {
    public void site_header_is_on_home_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://www.google.com");
//        Thread.sleep(2);
//        webDriver.get("https://samara.hh.ru/");
//        Thread.sleep(300);
        webDriver.get("https://www.google.com/");
        Thread.sleep(300);
        WebElement elem = null;
        try{
            elem = webDriver.findElement(By.id("gsr"));
            elem.sendKeys("cute pussy");
            Thread.sleep(3000);
            elem.click();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            Thread.sleep(3000);
        }
//        WebElement header = webDriver.findElement(By.id("site-header"));
//        System.out.println(header.getAttribute("site-header"));
//        header.click();
//        assertTrue((header.isDisplayed()));
        webDriver.close();
    }
}