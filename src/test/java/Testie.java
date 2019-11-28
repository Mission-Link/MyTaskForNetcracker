import actions.helpers.ActionDeque;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;
import parser.Parser;
import strikepackage.Browser;

import java.io.IOException;

public class Testie {
    private Browser browser;
    private ActionDeque actionDeque;

    @BeforeTest
    private void setUp() {

//        String url = "https://google.com";
//        String click = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";
//        String setV1 = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";
//        String setV2 = "geeks for geeks";
//        String clickSearchButtn = "//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"; //
//        //*[@id="tsf"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]
//        String firstResult = "//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3";
//        String firstResult2 = "//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/div/cite";

        browser = new Browser();
        String path = ".\\src\\main\\testfile\\test_scenario.xml";
        Parser parser = new Parser(path, browser);
        try {
            actionDeque = parser.parseXML();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

//        Action openURLAct = new OpenURLAct(url, browser);
//        actionDeque.putAction(openURLAct);
//        Action clickAct = new ClickAct(click, browser);
//        actionDeque.putAction(clickAct);
//        Action setValueAct = new SetValueAct(setV1, setV2, browser);
//        actionDeque.putAction(setValueAct);
//        Action clickAct2 = new ClickAct(clickSearchButtn, browser);
//        actionDeque.putAction(clickAct2);
//        Action clickAct3 = new ClickAct(firstResult2, browser);
//        actionDeque.putAction(clickAct3);
//        Action screenshotAct = new ScreenshotAct(browser);
//        actionDeque.putAction(screenshotAct);
    }

    @Test
    private void performTest() {
        actionDeque.execute();
    }

    @AfterTest
    private void stopTest() {
        browser.getWebDriver().close();
        browser.getWebDriver().quit();
    }

}
