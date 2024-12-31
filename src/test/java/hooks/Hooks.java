package hooks;

import io.cucumber.java.Before;
import commonMethods.Base;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        Base.report();
        Base.initializeDriver();
    }

    @After
    public void tearDown() {
        Base.close();
    }
}
