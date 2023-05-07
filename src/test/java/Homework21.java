import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {

        String email = "demo@class.com";
        String password = "te$t$tudent";

        enterCredentials(email, password);
        clickLogin();

        editPlaylistName();
        WebElement oldName = driver.findElement(By.xpath(".//a[contains(text(),\"CC's old playlist\")]"));
        Assert.assertTrue(oldName.isDisplayed());
        WebElement successMsg = driver.findElement(By.cssSelector(".success.show"));
        WebElement successMsgVisible = wait.until(ExpectedConditions.visibilityOf(successMsg));
        Assert.assertTrue(successMsgVisible.isDisplayed());

        editPlaylistBack();
        WebElement newName = driver.findElement(By.xpath(".//a[contains(text(),\"CC's new playlist\")]"));
        Assert.assertTrue(newName.isDisplayed());
        WebElement successMsg2 = driver.findElement(By.cssSelector(".success.show"));
        WebElement successMsgVisible2 = wait.until(ExpectedConditions.visibilityOf(successMsg2));
        Assert.assertTrue(successMsgVisible2.isDisplayed());

    }
}