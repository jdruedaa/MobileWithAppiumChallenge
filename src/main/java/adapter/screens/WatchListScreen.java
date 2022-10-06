package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class WatchListScreen extends BaseMobileScreen {

    private final By watchList = By.id("com.imdb.mobile:id/list");

    private final Logger log = LoggerFactory.getLogger(WatchListScreen.class);

    public WatchListScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public boolean isMovieInWatchList(String movieName)
    {
        List<MobileElement> watchListMovies = getWatchListMovies();
        AndroidElement currentMovie;
        boolean movieIsInWatchList = false;
        String currentMovieName;
        for(MobileElement movieME : watchListMovies)
        {
            currentMovie = (AndroidElement) movieME;
            currentMovieName = currentMovie.findElement(By.id("com.imdb.mobile:id/primaryText")).getText();
            if(movieName.equalsIgnoreCase(currentMovieName))
            {
                movieIsInWatchList = true;
                break;
            }
        }
        if(!movieIsInWatchList)
        {
            log.error("Movie {} not found", movieName);
        }
        return movieIsInWatchList;
    }

    public List<MobileElement> getWatchListMovies()
    {
        long timeOutInSeconds = 15;
        List<MobileElement> watchListMovies;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        AndroidElement watchListAE = (AndroidElement) explicitWait.
                until(ExpectedConditions.visibilityOf(driver.findElement(watchList)));
        watchListMovies = watchListAE.findElementsById("com.imdb.mobile:id/primary_view");
        return watchListMovies;
    }
}
