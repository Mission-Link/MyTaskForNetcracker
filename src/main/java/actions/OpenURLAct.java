package actions;

import strikepackage.Browser;

public class OpenURLAct extends Action {
    private String url;

    public OpenURLAct(String url, Browser browser) {
        super("openurl", browser);
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

    public void run() {
        browser.getWebDriver().get(url);
    }

}
