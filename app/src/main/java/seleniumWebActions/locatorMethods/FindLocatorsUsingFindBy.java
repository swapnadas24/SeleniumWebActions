package seleniumWebActions.locatorMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindLocatorsUsingFindBy {

    WebDriver driver;
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        System.out.println("Chrome driver started....");
    }
    public void openUrl(String url){
        driver.get(url);
        System.out.println("Browser opened...."+url);

        driver.manage().window().maximize();
        System.out.println("Screen maximized.....");
    }
    public void clickLoginButton(){
        WebElement loginBtn= driver.findElement(By.xpath("//*[text()='Login']"));
        loginBtn.click();
        System.out.println("Login button clicked...."+loginBtn);

    }
    public void LocateWebElements(){
        WebElement username=driver.findElement(By.id("username"));
        System.out.println("Username: "+username);

        WebElement password=driver.findElement(By.id("password"));
        System.out.println("Password: "+password);

        WebElement logInToQKartBtn=driver.findElement(By.xpath("//*[text()='Login to QKart']"));
        System.out.println("LogIn to QKart: "+logInToQKartBtn);
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser closed....");
    }
    public void run(){
        startBrowser();
        openUrl("https://crio-qkart-frontend-qa.vercel.app/");
        clickLoginButton();
        LocateWebElements();
        closeBrowser();

    }
}
