package seleniumWebActions.locatorMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ProductCountUsingFindElements {

    WebDriver driver;
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started....");
    }
    public void openUrl(String url){
        driver.get(url);
        System.out.println("Browser opened....");

        driver.manage().window().maximize();
        System.out.println("Browser maximize window....");
    }

    public void totalNoOfProducts() {
        int totalProductCount=0;

        System.out.println("Before Total product count is "+totalProductCount);
        List<WebElement> totalProducts=driver.findElements(By.xpath("//div[contains(@Class,'MuiGrid-root MuiGrid-item')]//child::img"));
        totalProductCount =totalProducts.size();

        System.out.println("After Total product count: "+totalProductCount);

    }

    public void stopBrowser(){
        driver.quit();
        System.out.println("Browser stopped....");
    }
    public  void run(){
        startBrowser();
        openUrl("https://crio-qkart-frontend-qa.vercel.app/");
        totalNoOfProducts();
        stopBrowser();
    }
}
