package tests;

import adapter.bases.BaseMobileTest;
import adapter.screens.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WatchListTests extends BaseMobileTest {

    @Test
    @Parameters("movieName")
    public void AddMovieToWatchListTest(String movieName)
    {
        LogInScreen logInScreen = new LogInScreen(driver);
        HomeScreen homeScreen = logInScreen.performGoogleSignIn();
        SearchScreen searchScreen = homeScreen.navigateToSearchScreen();
        MovieScreen movieScreen = searchScreen.searchMovie(movieName);
        movieScreen.addMovieToWatchList();
        YouScreen youScreen = movieScreen.navigateToYouSection();
        WatchListScreen watchListScreen = youScreen.showFullWatchList();
        assertThat(watchListScreen.isMovieInWatchList(movieName), is(true));
    }

    @Test
    //@Parameters("movieName")
    public void AddMovieToWatchListTest2()
    {
        String movieName = "Fight Club";
        LogInScreen logInScreen = new LogInScreen(driver);
        HomeScreen homeScreen = logInScreen.performGoogleSignIn();
        SearchScreen searchScreen = homeScreen.navigateToSearchScreen();
        MovieScreen movieScreen = searchScreen.searchMovie(movieName);
        movieScreen.addMovieToWatchList();
        YouScreen youScreen = movieScreen.navigateToYouSection();
        WatchListScreen watchListScreen = youScreen.showFullWatchList();
        assertThat(watchListScreen.isMovieInWatchList(movieName), is(true));
    }
}
