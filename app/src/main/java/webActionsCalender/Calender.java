package webActionsCalender;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Calender {

    WebDriver driver;
    public void startBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started.....");
    }
    public void OpenUrl(String url){
        driver.get(url);
        System.out.println("Opening url....."+url);
    }
    public void clickOnCalenderTab(WebElement element){
        element.click();
        System.out.println("Clicking on calender tab..."+element);
    }
    public void selectYear(String yearOfBirth) throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='css-l0iinn']//button"));
        System.out.println("Clicking dropdown arrow....:");
        dropdown.click();
        Thread.sleep(2000);
        List<WebElement> years=driver.findElements(By.xpath("//div[contains(@class,'css-h6iofx')]//button"));

        JavascriptExecutor js= (JavascriptExecutor) driver;
        for(WebElement year:years){
            if(year.getText().equals(yearOfBirth)){

                // “js” is a JavascriptExecutor object
                js.executeScript("arguments[0].scrollIntoView()",year);
                Thread.sleep(1000);
                year.click();
                break;
            }
        }
        System.out.println("Selecting year..."+yearOfBirth);
    }
    private int getMonthIndex(String month) throws ParseException {

        int monthIndex=0;
        // TODO : Create the instance of Calendar class
        Calendar calendar=Calendar.getInstance();

        // TODO : Create the instance of SimpleDateFormat.Pass "MMM" into constructor of
        SimpleDateFormat sdf=new SimpleDateFormat("MMM");

        // TODO : Parse the month which you want to select
        Date date=sdf.parse(month);
        // TODO : Set the date using Calendar object use method setTime();
        calendar.setTime(date);
        // TODO : Get the index of month which you want to select and assign to indexOfMonth
        monthIndex=calendar.get(Calendar.MONTH);

        return monthIndex;
    }
    public void selectMonth(String month) throws ParseException, InterruptedException {

        // TODO : Get the index of month which you want to select using getMonthIndex()
        int monthIndex=getMonthIndex(month);

        // TODO : Get the index of present month on UI using getMonthIndex()
        int indexOfCurrentmonth;
       
        // TODO : Using do while loop write the logic to select expected month.
        WebElement clickNextButton= driver.findElement(By.xpath("(//div[@class='css-k008qs']/button)[2]"));
        do{
            clickNextButton.click();
            Thread.sleep(1000);
        // TODO : Get the present month present on UI using findElement()
           WebElement currentMonth= driver.findElement(By.xpath("(//div[@class='css-l0iinn']//div[@class='css-1v994a0'])[1]"));
            indexOfCurrentmonth=getMonthIndex(currentMonth.getText());

        }while(indexOfCurrentmonth!=monthIndex);
        System.out.println("Selected month:"+month);

    }
    public void selectDay(String dateToSelect) throws InterruptedException {

        List<WebElement> dateList=driver.findElements(By.xpath("//div[@class='css-i6bazn']//button"));

        for(WebElement date:dateList){
            if(date.getText().equals(dateToSelect)){
                date.click();
                Thread.sleep(1000);
                break;
            }
        }
        System.out.println("Selecting day..."+dateToSelect);
    }
    public void closeBrowser(){
        driver.quit();
        System.out.println("Closing Browser.....");
    }
public void run() throws ParseException, InterruptedException {
//    Launch the Chrome browser
    startBrowser();
//    Open URL: https://web-locators-static-site-qa.vercel.app/Calendar
    String URL="https://web-locators-static-site-qa.vercel.app/Calendar ";
    OpenUrl(URL);
    WebElement clickCalenderTab= driver.findElement(By.xpath("(//div[contains(@class,'css-1nvf7g0')]/button)[2]"));
    clickOnCalenderTab(clickCalenderTab);

// TODO : Call method selectYear() and pass the year as parameter
    selectYear("1990");
// TODO : Call method selectMonth() and pass the month as parameter
    selectMonth("Jun");
// TODO : Call method selectDate() and pass the date as parameter
    selectDay("26");
// TODO: Call the method closeBrowser
    closeBrowser();
}
}
