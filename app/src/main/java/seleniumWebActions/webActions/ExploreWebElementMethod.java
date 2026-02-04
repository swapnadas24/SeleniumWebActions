package seleniumWebActions.webActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExploreWebElementMethod {

    /*Open chrome browser
Visit URL: https://crio-qkart-frontend-qa.vercel.app/login
Locate text box for
1. Username
2. Password
Locate button “LOGIN TO QKART”
*/
    WebDriver driver;

    //Start browser
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
    }
    //openUrl
    public void openUrl(String browserUrl){
        //Open URL
        driver.navigate().to(browserUrl);
    }
    //Locate text box for Username
    public void getTextUsername(){

        WebElement username= driver.findElement(By.id("username"));
        System.out.println("Print Username: "+username);
    }
    //Locate text box for Password
    public void getTextPassword(){

        WebElement password= driver.findElement(By.id("password"));
        System.out.println("Print Password: "+password);
    }
    //Close Browser
    public void closeBrowser(){
        driver.quit();
    }
    public void run(){
        startBrowser();
        openUrl("https://crio-qkart-frontend-qa.vercel.app/login");
        getTextUsername();
        getTextPassword();
        closeBrowser();
    }
}
