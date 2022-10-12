package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class IMDBSignInScreen extends BaseMobileScreen {

    private final By navigateToSearchButton = By.id("com.imdb.mobile:id/navigation_search_browse");

    private final By showHidePasswordButton = By.id("auth-show-password-checkbox");

    private final By passwordTextInput = By.id("ap_password");

    private final By signInButton = By.id("signInSubmit");

    public IMDBSignInScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public YouScreen signIn(String userEmail, String password)
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(driver.getContextHandles());
        System.out.println(driver.getPageSource());
        long timeOutInSeconds = 15;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        /*
        AndroidElement showHidePasswordButtonAE = (AndroidElement) explicitWait
                .until(ExpectedConditions.visibilityOfElementLocated(showHidePasswordButton));
        if(showHidePasswordButtonAE.getAttribute("checked").equals("true"))
        {
            showHidePasswordButtonAE.click();
        }*/
        AndroidElement emailTextInput = driver.findElementByAndroidUIAutomator(
                "new UiSelector().resourceIdMatches(.*ap_email)") ;
        explicitWait
                .until(ExpectedConditions.visibilityOf(emailTextInput)).sendKeys(userEmail);
        System.out.println("Pasé");
        driver.findElement(passwordTextInput).sendKeys(password);
        driver.findElement(signInButton).click();
        return new YouScreen(driver);
    }

    public SearchScreen navigateToSearchScreen()
    {
        driver.findElement(navigateToSearchButton).click();
        return new SearchScreen(driver);
    }
}
