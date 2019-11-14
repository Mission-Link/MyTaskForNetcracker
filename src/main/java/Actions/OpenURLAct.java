package Actions;

public class OpenURLAct extends Action{
    private String url;

    public OpenURLAct(String url) {
        super("openURL");
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "OpenURLAct{" +
                "url='" + url + '\'' +
                '}';
    }
}
