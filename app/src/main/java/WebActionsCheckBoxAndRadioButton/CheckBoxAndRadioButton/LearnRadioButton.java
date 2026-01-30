package WebActionsCheckBoxAndRadioButton.CheckBoxAndRadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LearnRadioButton {

    WebDriver driver;

    public void StartBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser Started.....");

    }
    public void OpenUrl(String URL) throws InterruptedException {
        driver.get(URL);
        System.out.println("Opening URL.....");

        driver.manage().window().maximize();
        System.out.println("Window Maximized.....");
        Thread.sleep(1000);
    }
    public boolean checkElementIsSelected(WebElement webElement) throws InterruptedException {

        boolean isSelected = false;
        isSelected=webElement.isSelected();
        Thread.sleep(1000);


        return isSelected;
    }
    public boolean checkElementIsEnabled(WebElement webElement) throws InterruptedException {

        boolean isEnabled=false;

            isEnabled=webElement.isEnabled();
            if(isEnabled){
                System.out.println("WebElement is Enabled....."+webElement.isEnabled());
            } else if (!isEnabled) {
                System.out.println("WebElement is disabled....."+!webElement.isEnabled());
        }
            Thread.sleep(1000);
        return isEnabled;
    }
    public String getAttributeIsSelected(WebElement webElement, String attributeName){
         String isValue = null;
        isValue=webElement.getAttribute(attributeName);

        return isValue;
    }
    public void clickButton(WebElement webElement) throws InterruptedException {
        webElement.click();
        Thread.sleep(1000);
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("Closing Browser.....");
    }
    public void run() throws InterruptedException {

//        Launch the chrome browser
            StartBrowser();
//        Open URL: https://web-locators-static-site-qa.vercel.app/Radio
            String url="https://web-locators-static-site-qa.vercel.app/Radio ";
            OpenUrl(url);

//        In the radio button group  “Select Your Gender”
//        Check whether the “Female” option is selected by default.
            WebElement femaleGender=driver.findElement(By.xpath("(//div[@class='RadioScreen_Container1']//input)[1]"));
            System.out.println("Female Gender is selected...:"+checkElementIsSelected(femaleGender));

//        Retrieve and print the attribute value - “type” and “value” of the “Female” option
        String attribute_Type=getAttributeIsSelected(femaleGender,"type");
        String attribute_Value=getAttributeIsSelected(femaleGender,"value");
        System.out.println("attribute_Type:"+attribute_Type);
        System.out.println("attribute_Value:"+attribute_Value);

//        In the radio button group “Rate yourself in JAVA”
//        Select the “Very Good” rating
        WebElement select_VeryGood= driver.findElement(By.xpath("(//div[@class='RadioScreen_section2']//input)[1]"));
        clickButton(select_VeryGood);
        System.out.println("Very Good is selected...");
//        In the radio button group “Is your PAN Card or other Photo ID card linked”
//        Check whether the “No” option is disabled
//        Check whether the “Yes” option is enabled
        WebElement select_Yes_Tab=driver.findElement(By.xpath("(//div[@class='RadioScreen_section3']//input)[1]"));
        WebElement select_No_Tab=driver.findElement(By.xpath("(//div[@class='RadioScreen_section3']//input)[2]"));

        checkElementIsEnabled(select_Yes_Tab);
        checkElementIsEnabled(select_No_Tab);

//        Select the “Yes” option
        clickButton(select_Yes_Tab);

        closeBrowser();
    }
}

