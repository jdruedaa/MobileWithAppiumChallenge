package adapter.bases;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseMobileScreen {

    protected AndroidDriver<AndroidElement> driver;

    public BaseMobileScreen(AndroidDriver<AndroidElement> driver)  {
        this.driver = driver;
    }

}


