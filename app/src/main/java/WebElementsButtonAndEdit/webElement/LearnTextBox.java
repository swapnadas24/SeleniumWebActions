package WebElementsButtonAndEdit.webElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LearnTextBox {

    WebDriver driver;

    //    Launch the chrome browser
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Browser started.....");
        driver.manage().window().maximize();
        System.out.println("Browser maximized.....");
    }

    //    Open url : https://web-locators-static-site-qa.vercel.app/Edit
    public void OpenUrl(String url) {
        driver.get(url);
        System.out.println("Opening URL....." + url);
    }

    //    Check whether the “Enter your name” textbox is displayed
    public boolean enterYourName(WebElement name) {

        boolean IsDisplayed = false;
        IsDisplayed = name.isDisplayed();

        return IsDisplayed;

    }

    //    Enter/Type your name in the “Enter your name” textbox
    public void enterYourNameText(WebElement name, String NameText) {

        name.sendKeys(NameText);
    }

    //    Read/Retrieve and print the placeholder value “Type your nationality” from “Your nationality” textbox
    public void getPlaceHolderNationality(WebElement placeHolder) {
        String placeHolderTxt = null;
        placeHolderTxt = placeHolder.getText();
    }

    //    Check whether the “My weight before starting the wellness program(in kgs)” textbox is enabled
    public boolean getMyWeightBefore(WebElement weight) {
        boolean IsEnabled = false;
        IsEnabled = weight.isEnabled();

        return IsEnabled;
    }

    //    Get and print the size of “My weight before starting the wellness program(in kgs)” textbox
    public void getSizeBeforeMyWeight(WebElement weight) {

        int height = 0;
        int width = 0;

        Dimension size = weight.getSize();
        System.out.println("Get height of My weight before starting the wellness program(in kgs)..." + size.height);
        System.out.println("Get width of My weight before starting the wellness program(in kgs)..." + size.width);
    }

    //    List down the total number of textboxes present on the web pagevoid
    public void totalBox() {
        List<WebElement> totalNoOfbox = driver.findElements(By.xpath("//*[@id='root']//input"));
        int count = 0;
        count = totalNoOfbox.size();

        System.out.println("Total box count is " + count);


    }

    //    Close the browser
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed.....");
    }

    public void run() {
        startBrowser();
        OpenUrl("https://web-locators-static-site-qa.vercel.app/Edit");

        WebElement Uname = driver.findElement(By.xpath("//div[1]/*[@class='Edit_textField']"));
        enterYourName(Uname);
        System.out.println("Entered Your Name text box is displayed...." + enterYourName(Uname));
        enterYourNameText(Uname, "swapna");
        System.out.println("Enter your name...." + Uname);

        WebElement plchlderNationlity = driver.findElement(By.xpath("//div[3]/*[@class='Edit_textField']"));
        getPlaceHolderNationality(plchlderNationlity);
        System.out.println("PlaceHolder Nationality printing...." + plchlderNationlity);

        WebElement getWeightBefore = driver.findElement(By.className("placeholders42"));
        getMyWeightBefore(getWeightBefore);
        System.out.println("Enter your weight before is displayed...." + getMyWeightBefore(getWeightBefore));

        try {
            getMyWeightBefore(getWeightBefore);
        } catch (Exception e) {
            System.out.println("Get my weight not interactable.......");
        }
        getSizeBeforeMyWeight(getWeightBefore);
        totalBox();
        closeBrowser();

    }
}


