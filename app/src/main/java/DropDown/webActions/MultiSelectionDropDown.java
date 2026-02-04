package DropDown.webActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectionDropDown {

    WebDriver driver;
    public void startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        System.out.println("Chrome Driver Started......");
    }
    public void OpenUrl(String URL){
        driver.get(URL);
        System.out.println("Opening URL......");
    }
    public void allSelectedOption(WebElement webElement) throws InterruptedException {

        Select select = new Select(webElement);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options){
            if(option.isSelected()){
                select.getAllSelectedOptions().size();
                System.out.println("Selected Option: " + option.getText());
                Thread.sleep(1000);
            }
        }
    }
    public void firstSelectedOption(WebElement webElement) throws InterruptedException {
        Select select = new Select(webElement);
        select.getFirstSelectedOption();
        System.out.println("Selected First Selected Option...."+select.getFirstSelectedOption().getText());
        Thread.sleep(1000);
    }
    public void allDaysOption(WebElement webElement,List<String> values) throws InterruptedException {
        Select select = new Select(webElement);

       for (String value : values){
           select.selectByVisibleText(value);
           System.out.println("Selected Option..:"+value);
       }
       Thread.sleep(1000);
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("Closing Browser......");
    }
    public void run() throws InterruptedException {
//        Launch the chrome browser.
        startBrowser();
//        Open URL: https://web-locators-static-site-qa.vercel.app/Dropdown
        String URL="https://web-locators-static-site-qa.vercel.app/Dropdown";
        OpenUrl(URL);
//        Locate the dropdown “Skills”
        WebElement clickMultiSelectionTab=driver.findElement(By.xpath("//*[contains(@class,'css-8atqhb')]//button[2]"));
        clickMultiSelectionTab.click();
        WebElement skills=driver.findElement(By.xpath("//*[@class='DropdownMulti_section1']/select"));
//        Retrieve/Print the -
//                All selected options
        allSelectedOption(skills);
//        First selected option
        firstSelectedOption(skills);

//        Locate the dropdown “On which days of the week, could you watch TV?”
        WebElement allDays=driver.findElement(By.xpath("//*[@class='DropdownMulti_section2']/select"));
//        Select Monday, Friday,Sunday
        List<String> SelectedDays=List.of("Monday","Friday","Sunday");
        allDaysOption(allDays,SelectedDays);
//        Close the browser
        closeBrowser();

    }
}
