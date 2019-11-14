package Actions;

/*
An abstract class to store a parsed from XML file action that
needs to be tested
 */
public abstract class Action {
    private String actionName;

    public Action(){}

    public Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }


}
