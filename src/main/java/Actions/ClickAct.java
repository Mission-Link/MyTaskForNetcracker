package Actions;

public class ClickAct extends Action {
    private String locatorXpath;

    public ClickAct(String locatorXpath) {
        super("Click");
        this.locatorXpath = locatorXpath;
    }

    public String getLocatorXpath() {
        return locatorXpath;
    }

    @Override
    public String toString() {
        return "ClickAct{" +
                "locatorXpath='" + locatorXpath + '\'' +
                '}';
    }
}
