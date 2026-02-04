package seleniumWebActions.locatorMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLocators {

    WebDriver driver;
    public void startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        System.out.println("Driver started....");
    }
    public void openUrl(String Url){
        driver.navigate().to(Url);
        System.out.println("Browser opened....");

        driver.manage().window().maximize();
        System.out.println("Screen maximized....");
    }
    public void clickLoginButton(){
        WebElement logInBtn= driver.findElement(By.xpath("//*[text()='Login']"));
        logInBtn.click();
        System.out.println("Login button clicked....");
    }
    public void locateWebElements(){
        WebElement username=driver.findElement(By.id("username"));
        System.out.println("UserName: "+username);

        WebElement password=driver.findElement(By.id("password"));
        System.out.println("Password: "+password);

        WebElement logInToKartBtn=driver.findElement(By.xpath("//*[text()='Login to QKart']"));
        System.out.println("LoginButton: "+logInToKartBtn);
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser closed....");
    }
    public void run(){
        startBrowser();
        openUrl("https://crio-qkart-frontend-qa.vercel.app/");
        clickLoginButton();
        locateWebElements();
        closeBrowser();

    }
}
