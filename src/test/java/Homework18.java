import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong() {

        String email = "demo@class.com";
        String password = "te$t$tudent";

        enterCredentials(email, password);
        clickLogin();

        //play third song on Home
        WebElement thirdSong = driver.findElement(By.cssSelector("ol.top-song-list :nth-child(3) > article > span.cover"));
        WebElement songElement = wait.until(ExpectedConditions.elementToBeClickable(thirdSong));
        songElement.click();
        //verify soundbar while song is playing
        WebElement soundBar = driver.findElement(By.cssSelector("div.bars"));
        WebElement soundBarElement = wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBarElement.isDisplayed());
        //click play next song
        WebElement nextSongPlay = driver.findElement(By.cssSelector("div.side.player-controls > i.next.fa.fa-step-forward.control"));
        WebElement nextSongElement = wait.until(ExpectedConditions.elementToBeClickable(nextSongPlay));
        nextSongElement.click();
        //verify next song title is playing
        WebElement secondSong = driver.findElement(By.xpath(".//h3[text()='Mid-Air Machine - If It_s All I Do']"));
        WebElement secondSongElement = wait.until(ExpectedConditions.visibilityOf(secondSong));
        Assert.assertTrue(secondSongElement.isDisplayed());
        WebElement soundBarElement2 = wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertTrue(soundBarElement2.isDisplayed());
        //click pause
        WebElement pauseSong = driver.findElement(By.cssSelector("div.side.player-controls > span :nth-child(2) > i.fa.fa-pause"));
        WebElement pauseElement = wait.until(ExpectedConditions.elementToBeClickable(pauseSong));
        pauseElement.click();
        WebElement soundBarElement3 = wait.until(ExpectedConditions.visibilityOf(soundBar));
        Assert.assertFalse(soundBarElement3.isDisplayed());

    }
}