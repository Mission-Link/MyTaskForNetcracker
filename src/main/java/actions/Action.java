package actions;

import strikepackage.Browser;

public abstract class Action implements IAction{
    protected String name;
    protected Browser browser;

    public Action(String name, Browser browser) {
        this.name = name;
        this.browser = browser;
    }

    @Override
    public void run() {
    }
}
