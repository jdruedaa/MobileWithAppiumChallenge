package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IMDBSignInScreen extends BaseMobileScreen {

    private final By showHidePasswordButton = By.id("auth-show-password-checkbox");

    private final By passwordTextInput = By.id("ap_password");

    private final By emailTextInput = By.id("ap_email");

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
        explicitWait
                .until(ExpectedConditions.presenceOfElementLocated(emailTextInput)).sendKeys(userEmail);
        driver.findElement(passwordTextInput).sendKeys(password);
        driver.findElement(signInButton).click();
        return new YouScreen(driver);
    }
}
