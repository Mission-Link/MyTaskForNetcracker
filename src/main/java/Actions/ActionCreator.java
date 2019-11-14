package Actions;

import java.util.ArrayList;

public class ActionCreator {

    private static final String OPEN_URL = "openurl";
    private static final String CLICK = "click";
    private static final String SET_VALUE = "setvalue";
    private static final String SCREENSHOT = "screenshot";

    private Action action;

    public Action createAction(ArrayList<String> arrayList) {
        String actionName = arrayList.get(0);

        switch (actionName.toLowerCase()) {
            case OPEN_URL:
                String url = arrayList.get(1);
                action = new OpenURLAct(url);
                break;
            case CLICK:
                String xpath = arrayList.get(1);
                action = new ClickAct(xpath);
                break;
            case SET_VALUE:
                String xpath2 = arrayList.get(1);
                String textToSet = arrayList.get(2);
                action = new SetValueAct(xpath2, textToSet);
                break;
            case SCREENSHOT:
                action = new ScreenshotAct();
                break;
            default:
                break;

        }//end of switch

        return action;
    }//end of method

}//end of class

