package TestScript;

import Pages.NSEIndiaStock_Page;
import Utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class NSEIndiaStock_Test extends BaseTest {

   NSEIndiaStock_Page NSEIndiaStock_Page ;


    @Test
    public void testStockInformation() throws InterruptedException {


        Log.info("Starting Test named testStockInformation  ");

        NSEIndiaStock_Page=new NSEIndiaStock_Page(driver);
        String stockName = "TATAMOTORS";
        NSEIndiaStock_Page.searchStock(stockName);
        Log.info("Verify Stock information  ");
        Assert.assertTrue(NSEIndiaStock_Page.stockCurrentValue().equals("805.40"));
        Assert.assertTrue(NSEIndiaStock_Page.stockPreviousValue().equals("800.45"));
        Assert.assertTrue(NSEIndiaStock_Page.stockOpenValue().equals("802.40"));
        Assert.assertTrue(NSEIndiaStock_Page.stockHighValue().equals("808.45"));
        Assert.assertTrue(NSEIndiaStock_Page.stockLowValue().equals("788.50"));


        System.out.println("52 week High Value is ----  "+NSEIndiaStock_Page.get52WeekHighPrice() );
        System.out.println("52 week High Value is ----  "+NSEIndiaStock_Page.get52WeekLowPrice() );

    }
}
