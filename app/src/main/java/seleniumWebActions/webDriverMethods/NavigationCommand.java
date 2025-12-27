package seleniumWebActions.webDriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommand {

    WebDriver driver;
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public void openUrl(String url){
        driver.navigate().to(url);
        System.out.println("Navigated to Current URL: " +url);
    }
    public void navigateRegisterUrl(String RegisterUrl){
        driver.navigate().to(RegisterUrl);
        System.out.println("Navigated to URL: " +RegisterUrl);
    }
    public void navigateBack(){
        driver.navigate().back();
        System.out.println("Navigate to Back: " +driver.getCurrentUrl());
    }
    public void navigateForward(){
        driver.navigate().forward();
        System.out.println("Navigate to Forward: " +driver.getCurrentUrl());
    }
    public void navigateToRefresh( ){
        driver.navigate().refresh();
        System.out.println("Navigate to Refresh: " +driver.getCurrentUrl());
    }

    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser closed.....");
    }
    public void run(){
        startBrowser();
        openUrl("https://crio-qkart-frontend-qa.vercel.app/");
        navigateRegisterUrl("https://crio-qkart-frontend-qa.vercel.app/register");
        navigateBack();
        navigateForward();
        navigateToRefresh();
        closeBrowser();
    }
}
