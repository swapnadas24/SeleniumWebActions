package seleniumWebActions.exceptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementException {

    ChromeDriver driver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser opened.....");
    }
    public void OpenUrl(String url) {
        System.out.println("Opening URL...."+url);
        driver.get(url);

        System.out.println("Browser Maximizing......");
        driver.manage().window().maximize();
    }
    public void locateLogInBtn() {
        System.out.println("Locating ogin button of WebElement class......");
        WebElement logInBtn=driver.findElement(By.xpath("//*[text()='Login']"));
        logInBtn.click();
        driver.navigate().refresh();
        System.out.println("Locator Value: "+logInBtn.toString());
    }
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed......");
    }
    public void run(){
        startBrowser();
        OpenUrl("https://crio-qkart-frontend-qa.vercel.app/");
        locateLogInBtn();
        closeBrowser();

    }
}
