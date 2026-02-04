package webActionsWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTableShoeSize {
    WebDriver driver;
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started......");
    }
    public void OpenUrl(String url){
        driver.get(url);
        System.out.println("Opening url.....:" + url);
        driver.manage().window().maximize();
        System.out.println("Maximized window......");
    }
    public void selectButton(WebElement element){
       //element is selected
        element.isSelected();
        System.out.println("Selecting button: " + element.getText());
    }
    public void selectShoeSize(List<WebElement> elements) throws InterruptedException {

        for (WebElement element : elements) {

            element.click();
            Thread.sleep(2000);
            System.out.println("Shoe size selection is clicked......");
            break;
        }
    }
    public void selectHeelToToeSize(List<WebElement> elements) throws InterruptedException {

       String value;
        for (WebElement element : elements) {
            if(element.getText().contains("10.6")) {
                value = element.getText();
                System.out.println("Selecting heel to toe value is...." +value);

            }
        }
    }
    public void closeBrowser(){
        driver.close();
        driver.quit();
        System.out.println("Closing Browser......");
    }
    public void run() throws InterruptedException {
//        Launch the Chrome browser
        startBrowser();
//        Open URL: https://web-locators-static-site-qa.vercel.app/Web%20Table
        String URL="https://web-locators-static-site-qa.vercel.app/Web%20Table";
        OpenUrl(URL);
//        Select table “Static Table - Shoe Size Selection”
        WebElement selectShoeSizeTab= driver.findElement(By.xpath("//div[@class='MuiBox-root css-8atqhb']//button[1]"));
        selectButton(selectShoeSizeTab);
//        In the table “Shoe's Size Chart”
//        Select your shoe size (by clicking on the radio button in the specific row)
        List<WebElement> selectShoeSizeFromRows=driver.findElements(By.xpath("(//td[contains(@class,'css-q34dxg')]/parent::tr)[3]/td"));
        selectShoeSize(selectShoeSizeFromRows);

//        Print the “Heel to Toe” value of your selection
        selectHeelToToeSize(selectShoeSizeFromRows);
//        Close the browser
        closeBrowser();
}
}
