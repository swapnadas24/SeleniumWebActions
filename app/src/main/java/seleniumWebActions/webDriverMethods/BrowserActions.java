package seleniumWebActions.webDriverMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActions {

    WebDriver driver;
    public void startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public void openUrl(String browserUrl) throws InterruptedException {
        System.out.println("Browser opening...."+browserUrl);
        driver.get(browserUrl);
        Thread.sleep(2000);

        System.out.println("Screen maximizing....");
        driver.manage().window().maximize();
    }
    public void getCurrentUrl() throws InterruptedException {
        driver.getCurrentUrl();
        System.out.println("Current Url: "+driver.getCurrentUrl());
        Thread.sleep(2000);
    }
    public void getPageTitle(){
        driver.getTitle();
        System.out.println("Title: "+driver.getTitle());
    }
    public void getPageSource(){
        String pageSource = null;
        pageSource = driver.getPageSource();
        if(pageSource.contains("You need to enable JavaScript to run this app.")){
            System.out.println("Javascript page warning found in page source");
        }else{
            System.out.println("No Javascript page warning found in page source");
        }
    }
    public void closeBrowser(){
        if(driver != null){
            driver.quit();
            System.out.println("Browser closed......");
        }
    }
    public void run() throws InterruptedException {
        startBrowser();
        openUrl("https://crio-qkart-frontend-qa.vercel.app/");
        getCurrentUrl();
        getPageTitle();
        getPageSource();
        closeBrowser();
    }
}
