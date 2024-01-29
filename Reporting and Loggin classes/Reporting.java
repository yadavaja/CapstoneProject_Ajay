package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReport;
	public ExtentReports xReport;
	public ExtentTest xTest;
	
	public void onStart(ITestContext testContext) {
		String dateStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName = "VerifyStockInformation"+ dateStamp+".html";
		htmlReport=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		htmlReport.config().setDocumentTitle("TestNG Program");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setAutoCreateRelativePathMedia(true);
		xReport=new ExtentReports();
		xReport.attachReporter(htmlReport);
		xReport.setSystemInfo("Tester Name :", "Ajay Yadav");
	}
	
	public void onFinish(ITestContext testContext) {
		xReport.flush();
	}
	public void onTestSuccess(ITestResult Tr) {
		xTest = xReport.createTest(Tr.getName());
		xTest.log(Status.PASS, "Test is passed");
		xTest.log(Status.PASS, MarkupHelper.createLabel(Tr.getName(), ExtentColor.GREEN));
		String ssPath= System.getProperty("user.dir")+"/Screenshot/"+Tr.getName()+".png";
	    File file = new File(ssPath);
	    
	    if(file.exists()) {
	    	try{
	    		xTest.pass("Screenshot of the test passed is: " +xTest.addScreenCaptureFromPath(ssPath));
	    	}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    }
	}
	public void onTestFailure(ITestResult Tr) {
		xTest = xReport.createTest(Tr.getName());
		xTest.log(Status.FAIL, "Test is failed");
		xTest.log(Status.FAIL, Tr.getThrowable());
		xTest.log(Status.FAIL, MarkupHelper.createLabel(Tr.getName(), ExtentColor.RED));
		 String ssPath= System.getProperty("user.dir")+"/Screenshot/"+Tr.getName()+".png";
		    File file = new File(ssPath);
		    
		    if(file.exists()) {
		    	try{
		    		xTest.fail("Screenshot of the test failed is: " +xTest.addScreenCaptureFromPath(ssPath));
		    	}
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    }
	}
	public void onTestSkip(ITestResult Tr) {
		xTest = xReport.createTest(Tr.getName());
		xTest.log(Status.SKIP, "Test is skipped");
		xTest.log(Status.SKIP, MarkupHelper.createLabel(Tr.getName(), ExtentColor.AMBER));
	}
}
