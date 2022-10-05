package adapter.screens;

import adapter.bases.BaseMobileScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchScreen extends BaseMobileScreen {

    private final By searchBar = By.id("com.imdb.mobile:id/search_src_text");
    private final By searchSuggestions = By.id("com.imdb.mobile:id/recycler_search_suggestions");

    private final Logger log = LoggerFactory.getLogger(SearchScreen.class);

    public SearchScreen(AndroidDriver<AndroidElement> driver)
    {
        super(driver);
    }

    public MovieScreen searchMovie(String movieName)
    {
        AndroidElement searchBarAE = driver.findElement(searchBar);
        searchBarAE.click();
        searchBarAE.sendKeys(movieName);
        List<MobileElement> suggestedMovies = getSearchSuggestionMovies();
        AndroidElement currentMovie;
        AndroidElement targetMovie = null;
        String currentMovieName;
        for(MobileElement movieME : suggestedMovies)
        {
            currentMovie = (AndroidElement) movieME;
            //TODO Ask for UISelector
            //currentMovieName = currentMovie.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.imdb.mobile:id/suggestion\"").getText();
            currentMovieName = currentMovie.findElement(By.id("com.imdb.mobile:id/suggestion")).getText();
            if(movieName.equalsIgnoreCase(currentMovieName))
            {
                targetMovie = currentMovie;
                break;
            }
        }
        if(targetMovie != null)
        {
            targetMovie.click();
        }
        else
        {
            log.error("Movie {} not found", movieName);
        }
        return new MovieScreen(driver);
    }

    public List<MobileElement> getSearchSuggestionMovies()
    {
        List<MobileElement> suggestedMovies;
        AndroidElement searchSuggestionAE = driver.findElement(searchSuggestions);
        suggestedMovies = searchSuggestionAE.findElementsByClassName("android.widget.LinearLayout");
        return suggestedMovies;
    }

}
