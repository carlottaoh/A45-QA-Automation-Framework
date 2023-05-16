import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageRefactory.HomePage;
import pageRefactory.LoginPage;


public class Homework23 extends BaseTest {
    @Test (enabled = true, priority = 0, description = "Rename a playlist")
    public void renamePlaylist() {
        String newPlaylistName = "Your playlist";
        String email = "demo@class.com";
        String password = "te$t$tudent";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.enterCredentials(email, password).clickSubmit();
        Assert.assertTrue(homePage.avatarDisplayed());
        homePage.selectPlaylist().editNewPlaylistName(newPlaylistName);
        WebElement findPlaylist = getDriver().findElement(By.xpath(".//a[text()='" + newPlaylistName + "']"));
        WebElement foundPlaylist = wait.until(ExpectedConditions.visibilityOf(findPlaylist));
        Assert.assertTrue(foundPlaylist.isDisplayed());

    }
}