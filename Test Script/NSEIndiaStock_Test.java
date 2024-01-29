package TestScript;

import Pages.NSEIndiaStock_Page;
import Utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class NSEIndiaStock_Test extends BaseTest {

   NSEIndiaStock_Page NSEIndiaStock_Page ;


    @Test
    public void verifyStockInformationRCOM() throws InterruptedException {


        Log.info("Starting Test named verifyStockInformationRCOM  ");

        NSEIndiaStock_Page=new NSEIndiaStock_Page(driver);
        String stockName = "RCOM";
        NSEIndiaStock_Page.searchStock(stockName);
        Log.info("Verify Stock information  ");
        Assert.assertTrue(NSEIndiaStock_Page.stockCurrentValue().equals("1.75"));
        Assert.assertTrue(NSEIndiaStock_Page.stockPreviousValue().equals("1.80"));
        Assert.assertTrue(NSEIndiaStock_Page.stockOpenValue().equals("1.75"));
        Assert.assertTrue(NSEIndiaStock_Page.stockHighValue().equals("1.80"));
        Assert.assertTrue(NSEIndiaStock_Page.stockLowValue().equals("1.75"));

        Log.info("Printing 52 week High and Low values ");
        System.out.println("52 week High Value is ----  "+NSEIndiaStock_Page.get52WeekHighPrice() );
        System.out.println("52 week High Value is ----  "+NSEIndiaStock_Page.get52WeekLowPrice() );
        Log.info("End of executing test");
    }

    @Test
    public void selectAnyStockNIFTY50() throws InterruptedException{

        Log.info("Starting Test named selectAnyStockNIFTY50  ");

        WebElement stock = driver.findElement(By.xpath("//table[@id='tab1Ganier']/tbody/tr/td/a"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", stock);

        stock.click();
        Thread.sleep(5000);

        // Get the handles of all open windows
        Set<String> windowHandles = driver.getWindowHandles();


        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
        }

        System.out.println("52 week High Value is ----  "+NSEIndiaStock_Page.get52WeekHighPrice() );
        System.out.println("52 week High Value is ----  "+NSEIndiaStock_Page.get52WeekLowPrice() );
        Log.info("End of executing test");
    }
}
