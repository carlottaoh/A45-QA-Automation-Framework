import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {

        String email = "demo@class.com";
        String password = "te$t$tudent";

        enterCredentials(email, password);
        clickLogin();

        WebElement eighthSong = driver.findElement(By.xpath(".//nav[@class='side side-nav showing']//li[@class='playlist playlist'][8]"));
        WebElement songElement = wait.until(ExpectedConditions.elementToBeClickable(eighthSong));
        songElement.click();
        WebElement deletePlaylist = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        WebElement deleteElement = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylist));
        deleteElement.click();

        WebElement confirmationPopup = driver.findElement(By.xpath(".//div[@class='alertify'][1]//button[@class='ok']"));
        WebElement confirmElement = wait.until(ExpectedConditions.elementToBeClickable(confirmationPopup));
        confirmElement.click();
        WebElement successMsg = driver.findElement(By.cssSelector(".success.show"));
        WebElement successElement = wait.until(ExpectedConditions.visibilityOf(successMsg));
        Assert.assertTrue(successElement.isDisplayed());

    }
}