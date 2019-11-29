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
        browser = new Browser();
        String path = ".\\src\\main\\testfile\\test_scenario.xml";
        Parser parser = new Parser(path, browser);
        try {
            actionDeque = parser.parseXML();
        } catch (IOException | SAXException e) {
            System.out.println("Impossible to parse XML file");
            System.out.println(e.getMessage());
        }
    }//end of setUp method

    @Test
    private void performTest() {
        actionDeque.execute();
    }

    @AfterTest
    private void stopTest() {
        browser.getWebDriver().close();
        browser.getWebDriver().quit();
    }

}//end of class
