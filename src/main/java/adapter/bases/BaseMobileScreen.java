package adapter.bases;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BaseMobileScreen {

    protected AndroidDriver<AndroidElement> driver;

    public BaseMobileScreen(AndroidDriver<AndroidElement> driver)  {
        this.driver = driver;
    }

    //@AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.Button\").textContains(\"Ok\")")
    //public AndroidElement OkButton;

}


