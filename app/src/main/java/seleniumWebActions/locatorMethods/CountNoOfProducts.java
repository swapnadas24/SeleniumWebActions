package seleniumWebActions.locatorMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountNoOfProducts {

    WebDriver driver;
    public void startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver has been initialized......");
    }
    public void OpenUrl(String url){

        System.out.println("Opening url: " + url);
        driver.get(url);

        System.out.println("Browser maximizing......");
        driver.manage().window().maximize();
    }
    public void totalNoOfProducts(){
        int count = 0;
        // TODO: Locate all the links available on web page and print the count
        List<WebElement> allLinks=driver.findElements(By.tagName("a"));
        count=allLinks.size();

        System.out.println("Total number of products is "+count);
    }
    public void closeBrowser(){

        System.out.println("Closing Browser......");
        driver.quit();
    }
    public void run(){
        startBrowser();
        OpenUrl("https://crio-qkart-frontend-qa.vercel.app/");
        totalNoOfProducts();
        closeBrowser();
    }
}
