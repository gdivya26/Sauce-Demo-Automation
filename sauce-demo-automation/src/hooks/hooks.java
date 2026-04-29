package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import utils.DriverFactory;
import utils.ConfigReader;

public class Hooks {

    ConfigReader config = new ConfigReader();

    @Before
    public void setup() {
        DriverFactory.initDriver(config.getBrowser());
        DriverFactory.getDriver().get(config.getURL());
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}