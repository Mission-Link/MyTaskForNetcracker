import Actions.ClickAct;
import Actions.OpenURLAct;
import Actions.ScreenshotAct;
import Actions.SetValueAct;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.Queue;

public class Launcher {
    private DerpyTester derpyTester = null;
    private ActionTranslator actionTranslator = null;
    private Parser parser = null;

    @BeforeTest
    private void setUpTester(){
        parser = new Parser();
        derpyTester = new DerpyTester();
        String path = ".\\src\\main\\testfile\\test_scenario.xml";
        try {
            actionTranslator = new ActionTranslator(derpyTester, parser.parseXML(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

//        actionTranslator.addAction(new OpenURLAct("https://google.com"));
//        actionTranslator.addAction(new ClickAct("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input"));
//        actionTranslator.addAction(new SetValueAct("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input",
//                "geeks for geeks"));
//        actionTranslator.addAction(new ClickAct("//*[@id=\"tsf\"]/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));
//        actionTranslator.addAction(new ClickAct("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a[1]/h3"));
//        actionTranslator.addAction(new ScreenshotAct());

    }

    @Test
    private void testIt(){
        try {
            actionTranslator.executeDeque();
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
//        derpyTester.openURL(url);
//        derpyTester.maximizeWindow();
//        derpyTester.click(click);
//        derpyTester.setValue(setV1, setV2);
//        derpyTester.click(clickSearchButtn);
//        derpyTester.click(firstResult2);
//        derpyTester.takeScreenshot();
    }

    @AfterTest
    private void stopTester(){
        derpyTester.exitBrowser();
    }

}
