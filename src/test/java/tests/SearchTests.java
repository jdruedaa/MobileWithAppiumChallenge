package tests;

import adapter.bases.BaseMobileTest;
import adapter.screens.LogInScreen;
import adapter.screens.MovieScreen;
import adapter.screens.SearchScreen;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTests extends BaseMobileTest {

    @Test
    @Parameters({"movieName", "movieOverview"})
    public void SearchMovieTest(String movieName, String movieOverview)
    {
        LogInScreen logInScreen = new LogInScreen(driver);
        SearchScreen searchScreen = logInScreen.navigateToSearchScreen();
        MovieScreen movieScreen = searchScreen.searchMovie(movieName);
        String receivedOverview = movieScreen.getMovieOverview();
        assertThat(movieOverview,is(equalToIgnoringCase(receivedOverview)));
    }
}
