package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YouScreen extends BaseMobileScreen {

    private final By watchListSeeAllButton = By.id("com.imdb.mobile:id/see_all");

    private final By navigateToSearchButton = By.id("com.imdb.mobile:id/navigation_search_browse");

    public YouScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public WatchListScreen showFullWatchList()
    {
        long timeOutInSeconds = 15;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        explicitWait.until(ExpectedConditions.elementToBeClickable(watchListSeeAllButton)).click();
        return new WatchListScreen(driver);
    }

    public SearchScreen navigateToSearchScreen()
    {
        driver.findElement(navigateToSearchButton).click();
        return new SearchScreen(driver);
    }
}
