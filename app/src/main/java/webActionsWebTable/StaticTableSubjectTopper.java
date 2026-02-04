package webActionsWebTable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticTableSubjectTopper {

    WebDriver driver;
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started......");
    }
    public void OpenUrl(String url){
        driver.get(url);
        System.out.println("Opening url: " + url);
        driver.manage().window().maximize();
        System.out.println("Maximized window...");
    }
    public void printAllHeaders(List<WebElement> elements){

        for (WebElement element : elements){
            System.out.println("Header: " + element.getText());
        }

    }
    public void printSecondRowData(List<WebElement> elements){

        for (WebElement element : elements){
            if(element.getText().contains("DPS_Grade9_31")){
                System.out.println("Second row data: "+ element.getText());
                break;
            }
        }
    }
    public void printTotalNumberOfRow(List<WebElement> elements){

            System.out.println("Total row count: " +elements.size());

    }
    public void printStudentInfo(List<WebElement> elements){

        for (WebElement element : elements){
            if(element.getText().contains("Java")){
                System.out.println("Student Information: "+ element.getText());
                break;
            }
        }
    }
    public void clickButton(WebElement element) throws InterruptedException {
        element.click();
        System.out.println("Clicking on element: " + element.getText());
        Thread.sleep(1000);
    }
    public void CloseBrowser(){
        driver.close();
        driver.quit();
        System.out.println("Closing Browser");
    }
    public void run() throws InterruptedException {

//        Launch the Chrome browser
          startBrowser();
//        Open URL: https://web-locators-static-site-qa.vercel.app/Web%20Table
          String URL="https://web-locators-static-site-qa.vercel.app/Web%20Table";
          OpenUrl(URL);
//        Select “Static Table - Subject Topper” table
          WebElement selectSubjectTopperTab= driver.findElement(By.xpath("//div[@class='MuiBox-root css-8atqhb']//button[2]"));
          clickButton(selectSubjectTopperTab);
//        List/Print the names of all header columns
         List<WebElement> allHeaders=driver.findElements(By.xpath("//thead[@class='MuiTableHead-root css-1wbz3t9']"));
         printAllHeaders(allHeaders);
//        List/Print the information in the second data row
         List<WebElement> totalRows=driver.findElements(By.xpath("//tbody[contains(@class,'css-1xnox0e')]/tr"));

         printSecondRowData(totalRows);
//        Find the Student Name, Roll Number and the Mark of the topper in “Java”
         printStudentInfo(totalRows);

//        Print the total number of data rows
        printTotalNumberOfRow(totalRows);
//        Print the average of all the “Highest Marks”
          CloseBrowser();
    }
}
