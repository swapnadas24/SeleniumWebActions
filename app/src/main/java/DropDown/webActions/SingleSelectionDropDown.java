package DropDown.webActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SingleSelectionDropDown {

    WebDriver driver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        System.out.println("Chrome driver started....");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    public void OpenUrl(String URL) {
        driver.get(URL);
        System.out.println("Opening URL: " + URL);

        driver.manage().window().maximize();
        System.out.println("Window Maximized....");
    }
    public void selectByVisibleText(WebElement webElement, String text) throws InterruptedException {

        Select option = new Select(webElement);

        List<WebElement> options = option.getOptions();
        for (WebElement option1 : options) {
            if (option1.getText().equals(text)) {
                option.selectByVisibleText(text);
                break;
            }
        }
        Thread.sleep(1000);

    }

    public void lastOption(WebElement webElement) throws InterruptedException {

        Select option = new Select(webElement);
        List<WebElement> options = option.getOptions();
        int index=options.size()-1;
        option.selectByIndex(index);
        Thread.sleep(1000);
    }
    public void IsMultipleOption(WebElement webElement) throws InterruptedException {
        boolean IsMultiple=false;
        Select option = new Select(webElement);
        IsMultiple=option.isMultiple();

        if(IsMultiple){
            System.out.println("Selecting Multiple Options....."+IsMultiple);
        }else{
            System.out.println("Selecting Single Options....."+!IsMultiple);
        }
        Thread.sleep(1000);
    }
    public void selectDefaultOption(WebElement webElement) throws InterruptedException {
        WebElement defaultOption;
        Select option=new Select(webElement);

        defaultOption=option.getFirstSelectedOption();
        System.out.println("Selected Default Option...."+defaultOption.getText());
        Thread.sleep(1000);
    }
    public void printAllOption(WebElement webElement) throws InterruptedException {

        Select option=new Select(webElement);
        List<WebElement> webElements = option.getOptions();

        for (WebElement webElement1 : webElements) {

            System.out.println("Print All Option...."+webElement1.getText());
        }
    }
    public void closeBrowser() {
        driver.quit();
        System.out.println("Browser closed...");
    }
    public void run() throws InterruptedException {

//        Launch the Chrome browser.
        startBrowser();
//        Open URL: https://web-locators-static-site-qa.vercel.app/Dropdown
        String url="https://web-locators-static-site-qa.vercel.app/Dropdown";
        OpenUrl(url);
//        Locate the dropdown “Which country do you want to travel”
//        Select “Australia” using selectByVisibleText() method
        WebElement select_Country= driver.findElement(By.xpath("//div[@class='Dropdown_section1']//select"));
        selectByVisibleText(select_Country,"Australia");
        System.out.println("Country name Australia is printed.....");

//        Locate the dropdown “What would you prefer to watch among the listed movies?”
//        Select the last option
        WebElement movie_option=driver.findElement(By.xpath("//div[@class='Dropdown_section2']//select"));
        lastOption(movie_option);
        System.out.println("Moviename name lastOption is printed.....");
        System.out.println("Selected Default Option....");

//        Locate the dropdown “What would you prefer to eat among the listed fruits?”
//        Check whether you can select more than one option
        WebElement select_fruits=driver.findElement(By.xpath("//div[@class='Dropdown_section3']//select"));
        IsMultipleOption(select_fruits);
        System.out.println("Selected All Multiple Option....");
        selectDefaultOption(select_fruits);
//        Retrieve/Print the default option selected
        printAllOption(select_fruits);
//        Retrieve/Print all the options present in the dropdown
//        Close the browser
        closeBrowser();
    }
}
