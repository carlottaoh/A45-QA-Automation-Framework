import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
//import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver = null;
    public ThreadLocal<WebDriver> threadDriver = null;
    public static WebDriverWait wait = null;
    public static String baseURL = "";
    public static Actions actions = null;

    @BeforeSuite
    static void setupClass() {
//        WebDriverManager.chromedriver().setup();
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
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        actions = new Actions(getDriver());
        baseURL = BaseURL;
        openBaseURL();
    }

    private static WebDriver pickBrowser(String browser) throws MalformedURLException {
//        DesiredCapabilities caps = new DesiredCapabilities();
//        String gridURL = "http://192.168.1.160:4444";
        switch(browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "lambda":
                return lambdaTest();
//            case "safari":
//                WebDriverManager.safaridriver().setup();
//                return driver = new SafariDriver();
//            case "grid-firefox":
//                caps.setCapability("browserName", "firefox");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
//            case "grid-safari":
//                caps.setCapability("browserName", "safari");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
//            case "grid-chrome":
//                caps.setCapability("browserName", "chrome");
//                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
public static WebDriver lambdaTest() throws MalformedURLException {
     String username = "carlotta.oh";
     String accessToken = "723W2iSjz2l4ftwnb7ehvDBa5OCs65PlwGfh2ZUH80KY2lEFBJ";
     String hubURL = "https://hub.lambdatest.com/wd/hub";

    FirefoxOptions browserOptions = new FirefoxOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("112.0");
    HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    ltOptions.put("username", username);
    ltOptions.put("accessKey", accessToken);
    ltOptions.put("project", "Untitled");
    ltOptions.put("w3c", true);
    ltOptions.put("plugin", "java-testNG");
    browserOptions.setCapability("LT:Options", ltOptions);
    return new RemoteWebDriver(new URL(hubURL), browserOptions);
}
    @AfterMethod
    public void quitBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }
    public WebDriver getDriver() {
        return threadDriver.get();
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