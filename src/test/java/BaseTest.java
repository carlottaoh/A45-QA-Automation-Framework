import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static String baseURL = "";
    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @DataProvider(name="getDataLoginData")
    public static Object[][] getDataLoginData() {
        return new Object[][] {
                {"invalid@mail.com", "invalid"},
                {"demo@class.com", ""},
                {"", ""}
        };
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        actions = new Actions(driver);
        baseURL = BaseURL;
        openBaseURL();
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    public static void openBaseURL() {
        driver.get(baseURL);
    }

    public void enterCredentials(String email, String password) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement emailElement = wait.until(ExpectedConditions.elementToBeClickable(emailField));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        emailElement.clear();
        emailElement.sendKeys(email);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement loginElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginElement.click();
        WebElement avatar = driver.findElement(By.cssSelector("img.avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        WebElement searchElement = wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchElement.sendKeys(song);
    }

    public void viewAllSongs() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        WebElement viewElement = wait.until(ExpectedConditions.elementToBeClickable(viewAllButton));
        viewElement.click();
    }

    public void addSongNewList(String playlistName) {
        WebElement createPlaylist = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//button[@class='btn-add-to']"));
        WebElement createElement = wait.until(ExpectedConditions.elementToBeClickable(createPlaylist));
        createElement.click();
        WebElement playlistNameField = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//input[@data-test='new-playlist-name']"));
        WebElement playlistNameElement = wait.until(ExpectedConditions.elementToBeClickable(playlistNameField));
        playlistNameElement.sendKeys(playlistName);
        WebElement enterButton = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//button[@type='submit']"));
        WebElement enterElement = wait.until(ExpectedConditions.elementToBeClickable(enterButton));
        enterElement.click();
    }

    public void editPlaylistName() {

        WebElement findExisting = driver.findElement(By.xpath(".//a[contains(text(),\"CC's new playlist\")]"));
        WebElement existingElement = wait.until(ExpectedConditions.elementToBeClickable(findExisting));
        actions.doubleClick(existingElement).perform();
        WebElement editExisting = driver.findElement(By.xpath(".//input[@data-testid='inline-playlist-name-input']"));
        WebElement editExistingElement = wait.until(ExpectedConditions.visibilityOf(editExisting));
        editExistingElement.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        editExistingElement.sendKeys("CC's old playlist");
        editExistingElement.sendKeys(Keys.ENTER);

    }

    public void editPlaylistBack() {
        WebElement findExisting = driver.findElement(By.xpath(".//a[contains(text(),\"CC's old playlist\")]"));
        WebElement existingElement = wait.until(ExpectedConditions.elementToBeClickable(findExisting));
        actions.doubleClick(existingElement).perform();
        WebElement editExisting = driver.findElement(By.xpath(".//input[@data-testid='inline-playlist-name-input']"));
        WebElement editExistingElement = wait.until(ExpectedConditions.visibilityOf(editExisting));
        editExistingElement.sendKeys(Keys.chord(Keys.COMMAND, "a", Keys.BACK_SPACE));
        editExistingElement.sendKeys("CC's new playlist");
        editExistingElement.sendKeys(Keys.ENTER);
    }

}