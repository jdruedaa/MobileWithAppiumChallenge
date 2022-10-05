package adapter.bases;


import core.ConfigCapabilities;
import core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.*;


public class BaseMobileTest {

    protected AndroidDriver<AndroidElement> driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        driver = new MobileAppDriver().getMoviesAppDriver(new ConfigCapabilities().getCapabilities());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()
    {
        driver.quit();
    }
}



