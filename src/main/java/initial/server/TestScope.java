package initial.server;

import javax.inject.Inject;

/**
 * User: patricio
 * Date: 15/1/21
 * Time: 20:53
 */
public class TestScope {

    @Inject
    private final String stuff;

    public TestScope(String someStuff) {
        this.stuff = someStuff;
    }

    public String getStuff() {
        return stuff;
    }
}
