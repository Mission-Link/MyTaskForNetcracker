package actions.helpers;

import actions.*;
import strikepackage.Browser;

import java.util.ArrayList;

/**
 * This class uses by class parser.Parser to retrieve an IAction obj
 * from ArrayList<String> instance that stores action tags
 */
public class ActionFactory {

    private static final String OPEN_URL = "openurl";
    private static final String CLICK = "click";
    private static final String SET_VALUE = "setvalue";
    private static final String SCREENSHOT = "screenshot";

    private Browser browser;

    public ActionFactory(Browser browser) {
        this.browser = browser;
    }

    /**
     * Creates an instance of IAction subclass
     *
     * @param arrayList stores action parameters
     * @return IAction subclass object
     */
    public Action createAction(ArrayList<String> arrayList) {
//        Action action = null;
        String actionName = arrayList.get(0);

        System.out.println("Action factory received actionName: "+actionName);

        switch (actionName.toLowerCase()) {
            case OPEN_URL:
                String url = arrayList.get(1);
          return new OpenURLAct(url, browser);

            case CLICK:
                String xpath = arrayList.get(1);
                return new ClickAct(xpath, browser);
//                break;
            case SET_VALUE:
                String xpath2 = arrayList.get(1);
                String textToSet = arrayList.get(2);
                return new SetValueAct(xpath2, textToSet, browser);
//                break;
            case SCREENSHOT:
                return new ScreenshotAct(browser);
//                break;
            default:
                return new NotSupportedYetAct(actionName, browser);
//                break;
        }//end of switch

//        return action;
    }//end of method

}//end of class

