package HyperLinkAndImages.HyperLink;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnImage {

    WebDriver driver;
    public void startBrowser(){

        //Launch the Chrome browser.
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        System.out.println("Browser started....");
        driver.manage().window().maximize();
        System.out.println("Window maximized....");
    }
    //Open URL: https://web-locators-static-site-qa.vercel.app/Image
    public void OpenUrl(String url){
        driver.get(url);
        System.out.println("Open url...."+url);
    }

    //Check whether the “two eyes” image is displayed
    public boolean IsDisplayed(WebElement element) {
        boolean displayed = false;
        displayed = element.isDisplayed();
        return displayed;
    }
//Retrieve and print the below attribute values for both of these images - “two eyes”, ”broken image”
//“src”
//“alt”
    public String getAttribute(WebElement webElement,String attributeName){
        String attributeValue=null;
        attributeValue=webElement.getAttribute(attributeName);

        return  attributeValue;
    }

    //Close the browser
    public void closeBrowser(){
        driver.quit();
    }
    public void run(){

        startBrowser();
        OpenUrl("https://web-locators-static-site-qa.vercel.app/Image");

        WebElement TwoEyeImage= driver.findElement(By.className("Image_image1"));
        IsDisplayed(TwoEyeImage);
        System.out.println("Two eyes image is displayed...."+TwoEyeImage.isDisplayed());

        //Retrieve and print the below attribute value - “two eyes”,
        //“src” and “alt”
        String twoEyeSrc=getAttribute(TwoEyeImage,"src");
        String twoEyeAlt=getAttribute(TwoEyeImage,"alt");

        System.out.println("Two eyes image src is displayed...."+twoEyeSrc);
        System.out.println("Two eyes image alt is displayed...."+twoEyeAlt);

        //Retrieve and print the below attribute value- ”broken image”,
        //“src” and “alt”
        WebElement brokenImage=driver.findElement(By.className("Image_image2"));

        String brokenImageSrc=getAttribute(brokenImage,"src");
        String brokenImageAlt=getAttribute(brokenImage,"alt");

        System.out.println("Two eyes image src is displayed...."+brokenImageSrc);
        System.out.println("Two eyes image alt is displayed...."+brokenImageAlt);

        closeBrowser();
    }

}
