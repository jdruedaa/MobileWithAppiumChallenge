package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovieScreen extends BaseMobileScreen {

    private final By movieOverview = By.id("com.imdb.mobile:id/plot_overview");

    private final By addToWatchListButton = By.id("com.imdb.mobile:id/watchlist_button_view");

    private final By navigateToYouSectionButton = By.id("com.imdb.mobile:id/navigation_you");

    public MovieScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public String getMovieOverview()
    {
        long timeOutInSeconds = 15;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(movieOverview)).getText();
    }

    public void addMovieToWatchList()
    {
        long timeOutInSeconds = 15;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textContains(\"Cast\").instance(0))")));
        explicitWait.until(ExpectedConditions.elementToBeClickable(addToWatchListButton)).click();
    }

    public YouScreen navigateToYouSection()
    {
        long timeOutInSeconds = 15;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        explicitWait.until(ExpectedConditions.elementToBeClickable(navigateToYouSectionButton)).click();
        return new YouScreen(driver);
    }
}
