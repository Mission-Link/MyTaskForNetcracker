package actions;

import org.openqa.selenium.By;
import strikepackage.Browser;

public class SetValueAct extends Action implements IAction{
    private String locatorXpath;
    private String textToSet;

    public SetValueAct(String locatorXpath, String textToSet, Browser browser) {
        super("setvalue", browser);
        this.locatorXpath = locatorXpath;
        this.textToSet = textToSet;
    }

    public String getLocatorXpath() {
        return locatorXpath;
    }

    public String getTextToSet() {
        return textToSet;
    }

    @Override
    public String toString() {
        return "SetValueAct{" +
                "locatorXpath='" + locatorXpath + '\'' +
                ", textToSet='" + textToSet + '\'' +
                '}';
    }

    @Override
    public void run() {
        browser.getWebDriver().findElement(By.xpath(locatorXpath)).sendKeys(textToSet);
    }

}//end of class
