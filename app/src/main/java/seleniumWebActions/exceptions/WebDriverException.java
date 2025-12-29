package seleniumWebActions.exceptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverException {

    WebDriver driver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started......");
    }
    public void openUrl(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Browser opened: "+url);
    }
    public void LocateloginBtn(){
        System.out.println("Locating of login button of WebDriver class......");
        WebElement loginBtn= driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
        System.out.println("Locator value:"+loginBtn.toString());
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser closed......");
    }
    public void run(){
    startBrowser();
    openUrl("https://crio-qkart-frontend-qa.vercel.app/");
    LocateloginBtn();
    closeBrowser();
    }
}
