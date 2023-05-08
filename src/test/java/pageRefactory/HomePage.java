package pageRefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    WebElement avatarIcon;
    @FindBy(css = "#sidebar > #playlists :nth-child(6)")
    WebElement aPlaylist;
    @FindBy(css = "input[name='name']")
    WebElement editPlaylistName;
    public HomePage(WebDriver passedDriver) {super(passedDriver);}
    public HomePage selectPlaylist() {
        doubleClick(aPlaylist);
        return this;
    }
    public HomePage editNewPlaylistName(String newPlaylistName) {
        findElement(editPlaylistName).sendKeys(newPlaylistName);
        findElement(editPlaylistName).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        findElement(editPlaylistName).sendKeys(newPlaylistName);
        findElement(editPlaylistName).sendKeys(Keys.ENTER);
        return this;
    }
    public String getPlaylistName() {
        return findElement(aPlaylist).getText();
    }
    public boolean avatarDisplayed() {
        return avatarIcon.isDisplayed();
    }

}
