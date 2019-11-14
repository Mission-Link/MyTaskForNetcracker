import Actions.*;

public class ActionTranslator {
    private ActionDeque actionDeque;
    private DerpyTester derpyTester;

    public ActionTranslator(DerpyTester derpyTester, ActionDeque actionDeque) {
        this.actionDeque = actionDeque;
        this.derpyTester = derpyTester;
    }

    public void addAction(Action elem) {
        actionDeque.putAction(elem);
    }

    public void executeDeque() throws MyException {
        for (Action tmp : actionDeque.getActionDeque()) {
            System.out.println(tmp.getClass().toString());
            if (tmp.getClass().toString().endsWith("OpenURLAct")) {
                OpenURLAct action = (OpenURLAct) tmp;
                derpyTester.openURL(action.getUrl());
            } else if (tmp.getClass().toString().endsWith("ClickAct")) {
                ClickAct action = (ClickAct) tmp;
                derpyTester.click(action.getLocatorXpath());
            } else if (tmp.getClass().toString().endsWith("SetValueAct")) {
                SetValueAct action = (SetValueAct) tmp;
                derpyTester.setValue(action.getLocatorXpath(), action.getTextToSet());
            } else if (tmp.getClass().toString().endsWith("ScreenshotAct")) {
                ScreenshotAct action = (ScreenshotAct) tmp;
                derpyTester.takeScreenshot();
            } else {
//                throw new UnsupportedOperationException("Operation "+tmp.getActionName()+
//                        " not supported yet");
                System.out.println("Operation " + tmp.getActionName() +
                        " not supported yet");
            }
        }//end of for each loop
    }//end of method execDeque()

    public void printDeque() throws MyException {
        actionDeque.printDeque();
    }//end of method printDeque()

}
