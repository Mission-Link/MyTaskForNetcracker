package actions;

import strikepackage.Browser;

public class MaximizeWindowAct extends Action implements IAction{
    public MaximizeWindowAct(Browser browser) {
        super("maximizewindow", browser);
    }

    @Override
    public void run() {
        browser.getWebDriver().manage().window().maximize();
    }
}
