package HyperLinkAndImages.HyperLink;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LearnHyperLink {

//    Launch the Chrome browser
    WebDriver driver;
    public void startBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Chrome driver started.....");

        driver.manage().window().maximize();
        System.out.println("ChromeDriver has maximized....");
    }
//    Open URL: https://web-locators-static-site-qa.vercel.app/Hyperlink
    public void OpenUrl(String url){
        driver.get(url);
        System.out.println("Opening url: " + url);
    }
//    Check whether the “Crio.do” link is displayed
    public boolean linkDisplayed(WebElement element){
        boolean IsDisplayed = false;
        IsDisplayed=element.isDisplayed();

        return IsDisplayed;
    }
//    Check whether the “Crio.do” link  is enabled
    public boolean linkEnabled(WebElement element){

        boolean IsEnabled=false;
        IsEnabled=element.isEnabled();
        return IsEnabled;
    }
//    Read and print the text “Crio.do”
    public String getText(WebElement element){
        String text="";
        text=element.getText();
        return text;
    }
//    Retrieve and print the “href” attribute value
    public String  getAttribute(WebElement element,String attributeName){
        String attributeValue=null;
        attributeValue = element.getAttribute(attributeName);
        return attributeValue;
    }
//    Count and print the total hyperlinks present on the web page
    public void getHyperlinks(List<WebElement> links){

        int count=0;
        count=links.size();
        System.out.println("Count total hyperlinks present on the web page: "+count);

        //    Print how many of these are visible and not visible
        int visibleCount=0;
        int invisibleCount=0;

        for(WebElement link:links){
            if(link.isDisplayed()){
                visibleCount++;
            }else{
                invisibleCount++;
            }
        }
        System.out.println("Visible links present on the web page: "+visibleCount);
        System.out.println("Invisible links present on the web page: "+invisibleCount);

        //Print how many links are having text ”Crio.Do”
        if(links.contains("Crio.Do")){
            System.out.println("Crio.Do present on the web page:"+links.contains("Crio.Do"));
        }
    }
    //    Click on the link under “Find out how many links are available” text
    public void clickOnLink(WebElement element){

        element.click();
    }

//    Close the browser
    public void browserClosed(){
        driver.quit();
        System.out.println("Browser closed.....");
    }

    public void run(){
        startBrowser();
        OpenUrl("https://web-locators-static-site-qa.vercel.app/Hyperlink");

        WebElement CrioDo_link= driver.findElement(By.xpath("//*[contains(text(),'Crio.do')]"));

        linkDisplayed(CrioDo_link);
        System.out.println("Link Displayed....."+linkDisplayed(CrioDo_link));

        linkEnabled(CrioDo_link);
        System.out.println("Link Enabled....."+linkEnabled(CrioDo_link));

        getText(CrioDo_link);
        System.out.println("Text Displayed....."+getText(CrioDo_link));

        String hrefAttribute=getAttribute(CrioDo_link,"href");

        System.out.println("Attribute Displayed....."+hrefAttribute);

        List<WebElement> totalLinks=driver.findElements(By.tagName("a"));
        getHyperlinks(totalLinks);

        WebElement ExternalLink= driver.findElement(By.partialLinkText("Find out how many"));
        clickOnLink(ExternalLink);
        System.out.println("Find out how many links are available ...is clicked.....");
        browserClosed();


    }

}
