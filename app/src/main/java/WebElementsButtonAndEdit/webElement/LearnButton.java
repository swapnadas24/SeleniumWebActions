package WebElementsButtonAndEdit.webElement;

import io.github.bonigarcia.wdm.WebDriverManager;
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
    }
//    Open URL: https://web-locators-static-site-qa.vercel.app/Button
    public void OpenUrl(String url){
        driver.get(url);
    }
//    Check whether the “Click this button” button is displayed
    public boolean clickIsDisplayed(WebElement element){

       Boolean isDisplay=null;
       isDisplay=element.isDisplayed();
        System.out.println("Button is displayed:"+isDisplay);
       return isDisplay;
    }
//    Check whether the “Click this button” button is enabled
    public boolean clickIsEnabled( WebElement element){
        Boolean isEnabled=null;
        isEnabled=element.isEnabled();
        System.out.println("Button is enabled:"+isEnabled);

        return isEnabled;
    }
//    Get and print the size of the button.
    public void getButtonSize(WebElement element){

        int height=0;
        int width=0;
        Dimension size=element.getSize();

        System.out.println("Button size:"+size.height);
        System.out.println("Button size:"+size.width);

    }
//    Get and print the position of the button.
    public void printButtonLocation(WebElement element){
        int coordinateX=0;
        int coordinateY=0;

        coordinateY=element.getLocation().getX();
        coordinateX=element.getLocation().getY();

        System.out.println("coordinateX is :"+coordinateX);
        System.out.println("coordinateY is :"+coordinateY);
    }
//    Read the label text “Click this button” from the button
    public void readLabelTextButton(WebElement element){
        String label=null;
        label=element.getText();
        System.out.println("label is :"+label);
    }
//    Retrieve the button background color
    public void backGroundColor(){
    }
    public void backGroundColor2(){
    }
//    Read the button’s “class” attribute value
    public void getAttribute(){
    }
//    Perform click operation on “Click this button” button
    public void clickOperationButton(){
    }

//    Retrieve the “Reset” button’s color
    public void retriveResetButtonColor(){
    }
//    Perform click operation on “Reset” button
    public void clickReset(){
    }
//    Close the browser
    public void closeBrowser(){
    }
    public void run() throws InterruptedException {

        startBrowser();
        OpenUrl("https://web-locators-static-site-qa.vercel.app/Button ");

        WebElement button= driver.findElement(By.className("button"));
    }
}
