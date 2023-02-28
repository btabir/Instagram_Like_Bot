import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    WebDriver driver;
    String BASE_URL = "https://www.instagram.com/";
    By usernameLocator = By.cssSelector("input[name='username']");
    By passwordLocator = By.cssSelector("input[name='password']");
    By cookiesLocator = By.cssSelector("button[class='_a9-- _a9_0']");
    By submitLocator = By.cssSelector("button[type='submit']");
    By postLocator = By.className("_aagw");
    By nameSurnameLocator = By.cssSelector("span[class='_aacl _aaco _aacw _aacx _aad7 _aade']");
    By likeButtonLocator = By.cssSelector("span._aamw");
    By postCounterLocator = By.cssSelector("span._ac2a");
    By htmlTag = By.tagName("html");



    public App(){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    public void clickCookies(){
        driver.findElement(cookiesLocator).click();
    }

    public void loginOp(String username,String password){
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(submitLocator).click();
    }

    public void navigateToProfile(String profileURL){
        driver.navigate().to(BASE_URL.concat(profileURL));
    }

    public void clickFirstPost(){
        waitFor(nameSurnameLocator);
        driver.findElements(postLocator).get(0).click();
    }

    public void likeAllPost(){
        int count = getPostCount();
        while (count>0){
            waitFor(likeButtonLocator);
            driver.findElement(likeButtonLocator).click();
            driver.findElement(htmlTag).sendKeys(Keys.ARROW_RIGHT); //sag ok tusu ile postlari gecmeyi saglar
            count--;
        }
    }

    private int getPostCount(){
        String count = driver.findElement(postCounterLocator).getText();
        return Integer.parseInt(count);
    }

    private void waitFor(By locator){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
