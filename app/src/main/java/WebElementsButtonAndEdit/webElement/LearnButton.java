package WebElementsButtonAndEdit.webElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jspecify.annotations.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnButton {

    WebDriver driver;
    //Launch the test browser
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started....");

        driver.manage().window().maximize();
        System.out.println("Window maximized....");
    }
//    Open URL: https://web-locators-static-site-qa.vercel.app/Button
    public void OpenUrl(String url) {

        driver.get(url);
        System.out.println("Opening url: " + url);
    }
//    Check whether the “Click this button” button is displayed
    public boolean clickIsDisplayed(WebElement element) {

       boolean isDisplay=false;
       isDisplay=element.isDisplayed();
       return isDisplay;
    }
    //    Check whether the “Click this button” button is enabled
    public boolean clickIsEnabled( WebElement webElement) {
        boolean isEnabled=false ;
        isEnabled=webElement.isEnabled();

        return isEnabled;
    }
    //    Get and print the size of the button.
    public void getButtonSize(WebElement webElement) {

        int height=0;
        int width=0;
        Dimension size=webElement.getSize();

        System.out.println("Button size:"+size.height);
        System.out.println("Button size:"+size.width);
    }
    //    Get and print the position of the button.
    public void getButtonLocation(WebElement webElement) {
        int coordinateX=0;
        int coordinateY=0;

        coordinateY=webElement.getLocation().getX();
        coordinateX=webElement.getLocation().getY();

        System.out.println("coordinateX is :"+coordinateX);
        System.out.println("coordinateY is :"+coordinateY);
    }
    //    Read the label text “Click this button” from the button
    public void readLabelTextButton(WebElement webElement){
        String label=null;
        label=webElement.getText();
        System.out.println("label is :"+label);
    }
    //    Retrieve the button background color
    public String getColorOfElement(WebElement webElement){
        //getCssValue of background color
        String color=null;
        color= webElement.getCssValue("color");

        System.out.println("color is :"+color);
        return color;
    }
    //    Read the button’s “class” attribute value
    public String getAttribute(WebElement webElement){
        String attributeValue=null;
        attributeValue= webElement.getAttribute("class");
        return  attributeValue;
    }
    //    Perform click operation on “Click this button” button
    public void clickOnButton(WebElement webElement){
        webElement.click();
    }

    //    Close the browser
    public void closeBrowser(){
        driver.quit();
        System.out.println("Browser closed....");
    }
    public void run() {

        startBrowser();
        OpenUrl("https://web-locators-static-site-qa.vercel.app/Button");

        WebElement button= driver.findElement(By.className("buttonContent"));

        clickIsDisplayed(button);
        System.out.println("Button is displayed:"+clickIsDisplayed(button));
        clickIsEnabled(button);
        System.out.println("Button is enabled:"+clickIsEnabled(button));
        getButtonSize(button);
        getButtonLocation(button);
        readLabelTextButton(button);
        getAttribute(button);
        System.out.println("attribute is :"+getAttribute(button));
        clickOnButton(button);
        System.out.println("Button is clicked.......");

        WebElement resetButton= driver.findElement(By.className("buttonContent2"));
        getColorOfElement(resetButton);
        System.out.println("Button refresh color: "+getColorOfElement(resetButton));

        clickOnButton(resetButton);
        System.out.println("Button reset....");
        closeBrowser();
    }
}
