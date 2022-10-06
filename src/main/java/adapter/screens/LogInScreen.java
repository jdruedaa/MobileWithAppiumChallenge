package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInScreen extends BaseMobileScreen {

    private final By navigateToSearchButton = By.id("com.imdb.mobile:id/navigation_search_browse");

    private final By imdbSignInButton = By.id("com.imdb.mobile:id/imdb_auth_portal");

    private final By googleSignInButton = By.id("com.imdb.mobile:id/google_oauth");

    public LogInScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public SearchScreen navigateToSearchScreen()
    {
        driver.findElement(navigateToSearchButton).click();
        return new SearchScreen(driver);
    }

    public IMDBSignInScreen navigateToIMDBSignInScreen()
    {
        driver.findElement(imdbSignInButton).click();
        return new IMDBSignInScreen(driver);
    }

    public HomeScreen performGoogleSignIn()
    {
        long timeOutInSeconds = 15;
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeOutInSeconds);
        AndroidElement navigateToSearchButtonAE = driver.findElement(navigateToSearchButton);
        driver.findElement(googleSignInButton).click();
        webDriverWait.until(ExpectedConditions.stalenessOf(navigateToSearchButtonAE));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(navigateToSearchButton));
        return new HomeScreen(driver);
    }
}
