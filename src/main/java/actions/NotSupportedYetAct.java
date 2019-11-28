package actions;

import strikepackage.Browser;

public class NotSupportedYetAct extends Action{
    private String message;

    public NotSupportedYetAct(String name, Browser browser) {
        super(name, browser);
        message = "Action: \""+name+"\" not supported yet";
    }

    @Override
    public void run() {
        System.out.println(message);
    }
}
