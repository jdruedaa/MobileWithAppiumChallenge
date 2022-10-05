package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovieScreen extends BaseMobileScreen {

    private final By movieOverview = By.id("com.imdb.mobile:id/plot_overview");

    public MovieScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public String getMovieOverview()
    {
        long timeOutInSeconds = 5;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(movieOverview)).getText();
    }
}
