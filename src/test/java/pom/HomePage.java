package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver passedDriver) {super(passedDriver);}
    By aPlaylist = By.cssSelector("#sidebar > #playlists :nth-child(5)");
    By editPlaylistName = By.cssSelector("input[name='name']");
    public void doubleClickPlaylist () {
        doubleClick(aPlaylist);
    }
    public void editNewPlaylistName (String playlistName) {
        findElement(editPlaylistName).sendKeys(playlistName);
        findElement(editPlaylistName).sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        findElement(editPlaylistName).sendKeys(playlistName);
        findElement(editPlaylistName).sendKeys(Keys.ENTER);
    }
    public boolean doesPlaylistExist(String playlistName) {
        By newPlaylistName = By.xpath("//a[text()='" + playlistName + "']");
        return findElement(newPlaylistName).isDisplayed();
    }
}