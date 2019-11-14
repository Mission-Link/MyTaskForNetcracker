package Actions;

public class SetValueAct extends Action{
    private String locatorXpath;
    private String textToSet;

    public SetValueAct(String locatorXpath, String textToSet) {
        super("setValue");
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
}
