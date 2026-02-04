package seleniumWebActions.webActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebActionsofAddingItemToCart {

    WebDriver driver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver has been initialized");
        driver.manage().window().maximize();
        System.out.println("Screen maximized.....");
    }
    public void OpenUrl(String url) {
        driver.get(url);
        System.out.println("Opening URL: " + url);
    }
    public void searchItem(WebElement elementShoes) throws InterruptedException {
        elementShoes.sendKeys("Shoes");
        Thread.sleep(3000);
        System.out.println("Shoes is searching.....");
    }
    public void countTotalItems(List<WebElement> eleCount) throws InterruptedException {
        eleCount.size();
        System.out.println("Total product count is "+eleCount.size());
        Thread.sleep(2000);
    }
    public void addItemToCart(WebElement ItemToCart) throws InterruptedException {

            ItemToCart.click();
            System.out.println("Adding item to cart....."+ItemToCart.getText());
            Thread.sleep(3000);
    }
    public void navigateToLogInPage(WebElement elementLogIn) throws InterruptedException {
        elementLogIn.click();
        Thread.sleep(4000);
        System.out.println("Navigating to log in page.....");
        Thread.sleep(2000);
    }

    public void enterUsernameToLogin(WebElement username) throws InterruptedException {
        username.sendKeys("swapna");
        Thread.sleep(2000);
        System.out.println("Entering username to login....."+username);
    }
    public void enterPasswordToLogin(WebElement password) throws InterruptedException {
        password.sendKeys("chintu@24");
        Thread.sleep(2000);
        System.out.println("Entering password to login...."+password);

    }
    public void logInAccount(WebElement logInToQKartBtn) throws InterruptedException {
        Thread.sleep(2000);
        logInToQKartBtn.click();

        Thread.sleep(2000);
        System.out.println("Entering credentials to login....");
    }
    public void refreshScreen() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        System.out.println("Screen refreshed....");
        Thread.sleep(2000);
    }
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed....");
    }
    public void run() throws InterruptedException {

        startBrowser();
        OpenUrl("https://crio-qkart-frontend-qa.vercel.app/");
        WebElement searchBox=driver.findElement(By.className("css-b52kj1"));
        searchItem(searchBox);

        List<WebElement> totalproductCount=driver.findElements(By.xpath("//div[contains(@class,'MuiGrid-root MuiGrid-container')]//child::img"));
        countTotalItems(totalproductCount);

        WebElement clickAdToCartButton=driver.findElement(By.className("css-54wre3"));
        addItemToCart(clickAdToCartButton);

        WebElement logInButton=driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
        navigateToLogInPage(logInButton);

        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.id("password"));
        WebElement logInToQKartBtn=driver.findElement(By.xpath("//*[text()='Login to QKart']"));

        //Do logIn account
        enterUsernameToLogin(username);
        enterPasswordToLogin(password);
        logInAccount(logInToQKartBtn);

        //Call refresh icon
        refreshScreen();

        //call closeBrowser
        closeBrowser();





    }
}
