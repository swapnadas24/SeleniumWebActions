package seleniumWebActions.webActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementAction {

    WebDriver driver;
    //start browser
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    //open URL
    public void openURL(String browserUrl){
        System.out.println("Browser started...."+browserUrl);
        driver.get(browserUrl);

        System.out.println("Browser maximized...");
        driver.manage().window().maximize();
    }
    //get Login button text
    public String logInBtnTxt(){
        String text=null;

        WebElement loginBtn= driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
        text=loginBtn.getText();
        System.out.println("Login button text printing..."+text);
        return text;
    }
    //click login button
    public void clickLoginButton() throws InterruptedException {
      WebElement loginBtn=driver.findElement(By.xpath("//*[contains(text(),'Login')]"));
      loginBtn.click();
      Thread.sleep(2000);
      System.out.println("Login button clicked");
    }
    //Enter userName "admin"
    public void enterUserName(String uName) throws InterruptedException {
       WebElement username=driver.findElement(By.id("username"));
       username.sendKeys(uName);

       Thread.sleep(2000);
       System.out.println("Enter user name: "+uName);
    }
    //Enter passWord "admin"
    public void enterPassword(String pwd) throws InterruptedException {
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys(pwd);

        Thread.sleep(2000);
        System.out.println("Enter password: "+pwd);
    }
    //click on LoginQKart button
    public void clickLoginQKart() throws InterruptedException {
        WebElement loginQKartBtn=driver.findElement(By.xpath("//*[contains(text(),'Login to QKart')]"));
        loginQKartBtn.click();
    }
    //close browser
    public void stopBrowser(){
        driver.quit();
        System.out.println("Browser stopped....");
    }
    //call the methods
    public void run() throws InterruptedException {
        startBrowser();
        openURL("https://crio-qkart-frontend-qa.vercel.app/");
        logInBtnTxt();
        clickLoginButton();
        enterUserName("admin");
        enterPassword("admin");
        clickLoginQKart();
        stopBrowser();
    }
}
