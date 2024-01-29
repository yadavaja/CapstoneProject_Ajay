package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class NSEIndiaStock_Page {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='header-search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@aria-label='Click to Serach']")
    private WebElement searchButton;

    @FindBy(xpath = "//*div[@class='autocompleteList tt-suggestion tt-selectable']/p/span")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//div[@class='searchLink']/a")
    private WebElement firstStock;





    @FindBy(xpath = "//*[@id='quoteLtp']")
    private WebElement stockCurrentValue;

    @FindBy(xpath = "//table[@id='priceInfoTable']/tbody/tr/td[1]")
    private WebElement stockPreviousValue;

    @FindBy(xpath = "//table[@id='priceInfoTable']/tbody/tr/td[2]")
    private WebElement stockOpenValue;

    @FindBy(xpath = "//table[@id='priceInfoTable']/tbody/tr/td[3]")
    private WebElement stockHighValue;

    @FindBy(xpath = "//table[@id='priceInfoTable']/tbody/tr/td[4]")
    private WebElement stockLowValue;

    @FindBy(xpath = "//*[@id='week52highVal']")
    private WebElement stock52WeekHighValue;

    @FindBy(xpath = "//*[@id='week52lowVal']")
    private WebElement stock52WeekLowValue;

    public NSEIndiaStock_Page(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this );
    }



    public void searchStock(String stockName) throws InterruptedException {

        Thread.sleep(5000);
        searchInput.sendKeys(stockName);
        Thread.sleep(5000);
        searchInput.sendKeys(Keys.ENTER);
       // firstSearchResult.click();
        //driver.findElement(By.xpath("//*div[@class='autocompleteList tt-suggestion tt-selectable']/p/span")).click();
        Thread.sleep(5000);
        firstStock.click();
        Thread.sleep(5000);
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));



    }

    public String stockCurrentValue(){
        return stockCurrentValue.getText();
    }

    public String stockPreviousValue(){

        return stockPreviousValue.getText();
    }

    public String stockOpenValue(){
        return stockOpenValue.getText();
    }

    public String stockHighValue(){

        return stockHighValue.getText();
    }

    public String stockLowValue(){
        return stockLowValue.getText();
    }
    public String get52WeekHighPrice() {

        return stock52WeekHighValue.getText();
    }

    public String get52WeekLowPrice() {

        return stock52WeekLowValue.getText();
    }
}
