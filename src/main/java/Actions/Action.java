package Actions;

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
