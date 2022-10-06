package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

public class HomeScreen extends BaseMobileScreen {

    private final By navigateToSearchButton = By.id("com.imdb.mobile:id/navigation_search_browse");

    public HomeScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public SearchScreen navigateToSearchScreen()
    {
        driver.findElement(navigateToSearchButton).click();
        return new SearchScreen(driver);
    }
}
