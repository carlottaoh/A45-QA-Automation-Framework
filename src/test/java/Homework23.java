import org.testng.Assert;
import org.testng.annotations.Test;
import pageRefactory.HomePage;
import pageRefactory.LoginPage;


public class Homework23 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newPlaylistName = "TEST SIXTH PLAYLIST";
        String email = "demo@class.com";
        String password = "te$t$tudent";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterCredentials(email, password).clickSubmit();
        Assert.assertTrue(homePage.avatarDisplayed());

        homePage.selectPlaylist().editNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getPlaylistName(), newPlaylistName);
    }
}