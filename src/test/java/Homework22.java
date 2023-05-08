import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import pom.LoginPage;

public class Homework22 extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newPlaylistName = "TEST NEW PLAYLIST";
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.editNewPlaylistName(newPlaylistName);
        Assert.assertTrue(homePage.doesPlaylistExist(newPlaylistName));
    }
}