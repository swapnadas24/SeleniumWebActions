package WebActionsCheckBoxAndRadioButton.CheckBoxAndRadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LearnCheckBox {

    WebDriver driver;
    //    Launch the Chrome
    public WebDriver startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        System.out.println("Browser started....");
        return driver;
    }
    //    Open URL: https://web-locators-static-site-qa.vercel.app/Checkbox
    public void OpenUrl(String url){
        driver.get(url);
        driver.manage().window().maximize();
        System.out.println("Window Maximized....");
    }
    //    In the checkbox “To which course are you enrolled into?”
//    List the options which are enabled (clickable)
    public boolean checkElementIsEnabled(List<WebElement> webElements) throws InterruptedException {

        boolean IsEnabled=false;
        for(WebElement webElement:webElements){
            IsEnabled=webElement.isEnabled();
        }
        Thread.sleep(1000);
        return IsEnabled;
    }
    //    Retrieve and print the “type” attribute value for - FDT,DSA
    public String getAttribute(WebElement webElement,String attributeName) throws InterruptedException {

        String IsValue=null;
        IsValue=webElement.getAttribute(attributeName);
        Thread.sleep(1000);
        return IsValue;
    }
    //    In the checkbox “Your phone has which Operating System (OS)?” -
//    Check what options are selected by default
//    Deselect the default
    public boolean getDefaultSelectedOption(List<WebElement> webElements) throws InterruptedException {

        boolean IsSelected=false;

        for(WebElement webElement:webElements){
            IsSelected=webElement.isSelected();
            if(IsSelected){
                webElement.click();
                break;
            }
            Thread.sleep(1000);
        }
        return  IsSelected;
    }


    //    In the checkbox “Select all the possible days when you could watch a phone” -
//    Select all the options
    public void selectAllOptions(List<WebElement> allDays) throws InterruptedException {

        for(WebElement day:allDays){
            if(!day.isSelected()){
                day.click();
            }
            Thread.sleep(1000);
        }

    }
    public void clickOnButton(WebElement webElement) throws InterruptedException {
        webElement.click();
        Thread.sleep(1000);
    }
    //    Close the browser
    public void closeBrowser(){

        driver.quit();
        System.out.println("Browser Closed....");
    }
    public void run() throws InterruptedException {

        String Url="https://web-locators-static-site-qa.vercel.app/Checkbox";
        startBrowser();
        OpenUrl(Url);
        //In the checkbox “To which course are you enrolled into?”
        //List the options which are enabled (clickable)
        List<WebElement> allOptions=driver.findElements(By.xpath("//*[@class='Checkbox_section1']//input"));
        checkElementIsEnabled(allOptions);
        System.out.println("Elements are enabled...."+checkElementIsEnabled(allOptions));

        WebElement checkBox_QA= driver.findElement(By.xpath("(//div[@class='Checkbox_section1']//preceding::input)[1]"));
        WebElement checkBox_DSA= driver.findElement(By.xpath("(//div[@class='Checkbox_section1']//preceding::input)[4]"));
        WebElement checkBox_FDT= driver.findElement(By.xpath("(//div[@class='Checkbox_section1']//preceding::input)[2]"));

        //    Select QA and DSA
        clickOnButton(checkBox_QA);
        System.out.println("QA is selected....:");
        Thread.sleep(1000);
        clickOnButton(checkBox_DSA);
        System.out.println("DSA is selected....:");

        // Retrieve and print the “type” attribute value for - FDT,DSA
        String FDT_Checkbox=getAttribute(checkBox_FDT,"type");
        String DSA_Checkbox=getAttribute(checkBox_DSA,"type");
        System.out.println("FDT attribute value:"+FDT_Checkbox);
        System.out.println("DSA attribute value:"+DSA_Checkbox);

        //    In the checkbox “Your phone has which Operating System (OS)?” -
        //    Check what options are selected by default
        //    Deselect the default
        List<WebElement> selected_defaultCheckBox=driver.findElements(By.xpath("//div[@class='Checkbox_section2']//input"));
        System.out.println("Default Checkbox.....:"+getDefaultSelectedOption(selected_defaultCheckBox));
        //    Select Android or iOS
        clickOnButton(selected_defaultCheckBox.get(2));
        System.out.println("Selected device...:"+selected_defaultCheckBox.get(2));


        //    In the checkbox “Select all the possible days when you could watch a phone” -
        //    Select all the options
        List<WebElement> all_SelectedOptions=driver.findElements(By.xpath("//div[@class='Checkbox_section3']//input"));
        selectAllOptions(all_SelectedOptions);

        System.out.println("All Checkbox selected.....");
        closeBrowser();

    }
}