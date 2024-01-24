package TestScript;


import Pages.NSEIndiaStock_Page;
import Utilities.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {
	WebDriver driver;
	ChromeOptions options ;


	
	@BeforeClass
	@Parameters({"Browser","URL"})
	public void Setup(String Browser,String url) throws InterruptedException {

		Log.info("Setting up Browser ");
		if(Browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		}
		else if(Browser.equalsIgnoreCase("edge")) {

			EdgeOptions options = new EdgeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(options);
		}
		else if(Browser.equalsIgnoreCase("firefox")) {


			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}


		driver.get(url);
		driver.manage().window().maximize();
        Thread.sleep(5000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='graph-container'])[1]")));
//		wait.until(ExpectedConditions.jsReturnsValue("return typeof Highcharts !== 'undefined' && Highcharts.charts.length > 0;"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void tearDown() {


		Log.info("Closing the  Browser ");
	   // driver.close();
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver,String tname)throws IOException {

		Log.info("Taking screenshots ");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
	}
	

}
