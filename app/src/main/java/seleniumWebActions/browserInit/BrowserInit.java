package seleniumWebActions.browserInit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInit {

    WebDriver driver;
    //start browser
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public void openURL(String browserUrl){
        System.out.println("Browser started...."+browserUrl);
        driver.get(browserUrl);

        System.out.println("Browser maximized...");
        driver.manage().window().maximize();
    }
    public void stopBrowser(){
        driver.quit();
    }
    public void run(){
        this.startBrowser();
        openURL("https://crio-qkart-frontend-qa.vercel.app/");
        this.stopBrowser();
    }
}
