package actions;

import strikepackage.Browser;

import java.util.ArrayList;

public class NotSupportedYetAct extends Action implements IAction{
//    private String message;
    private ArrayList<String> parameters;

    public NotSupportedYetAct(ArrayList<String> parameters, Browser browser) {
        super(parameters.get(0), browser);
        this.parameters = parameters;
    }

    @Override
    public void run() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "NotSupportedYetAct{" +
                "name='" + name + '\'' +
                ", parameters=" + parameters +
                "\n, browser=" + browser.getWebDriver().toString() +
                '}';
    }
}//end of class
