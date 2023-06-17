package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseReport {

    protected static ExtentReports extentReports; //extent report'
    protected static ExtentTest extentTest; // saves failed or passed, also takes a picture
    protected static ExtentHtmlReporter extentHtmlReporter; // Html report

    // before the TEST
    @BeforeTest(alwaysRun = true) // alwaysRun : .
    public void setUpTest() {
        extentReports = new ExtentReports(); // Starts reporting
        //After report is created, you decide where to save it
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Report"+date+".html"; // user.dir path of the project
        //Starts HTML report and decides the file path
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // We can add all info we want to add
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Akif");
        extentHtmlReporter.config().setDocumentTitle("First Test");
        extentHtmlReporter.config().setReportName("TestNG Reports");

    }

    // after every test method, if there is an error, takes a screen shoot
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // if it fails
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // if skipped
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignores
        }
        Driver.closeDriver();

    }


    // To end reporting:
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {

        extentReports.flush();
    }
}

