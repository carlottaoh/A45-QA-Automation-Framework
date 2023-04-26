import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static String baseURL = "https://bbb.testpro.io";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void quitBrowser() {
        driver.quit();
    }

    public static void openBaseURL() {
        driver.get(baseURL);
    }

    public static void enterCredentials(String email, String password) throws InterruptedException{
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }

    public static void clickLogin() throws InterruptedException{
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        Thread.sleep(2000);
    }

    public static void searchSong(String song) throws InterruptedException{
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.sendKeys(song);
        Thread.sleep(2000);
    }

    public static void viewAllSongs() throws InterruptedException{
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
        Thread.sleep(2000);
    }

    public static void addSongNewList(String playlistName) throws InterruptedException {
        WebElement createPlaylist = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//button[@class='btn-add-to']"));
        createPlaylist.click();
        WebElement playlistNameField = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//input[@data-test='new-playlist-name']"));
        playlistNameField.sendKeys(playlistName);
        WebElement enterButton = driver.findElement(By.xpath(".//section[@id='songResultsWrapper']//button[@type='submit']"));
        enterButton.click();
        Thread.sleep(2000);
    }

}