package pageRefactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    private WebElement avatarIcon;
    @FindBy(css = "#sidebar > #playlists :nth-child(3)")
    private WebElement aPlaylist;
    @FindBy(css = "input[name='name']")
    private WebElement editPlaylistName;
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
        String text = findElement(aPlaylist).getText();
        return text;
    }
    public boolean avatarDisplayed() {
        return avatarIcon.isDisplayed();
    }

}
