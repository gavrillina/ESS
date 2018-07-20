package buisness_object;

public class Site {

    public Site(String name, String URL) {
        this.name = name;
        this.URL = URL;
    }

    private String name;
    private String URL;

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

}
