package tests.day18_HtmlReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_CreatingReport extends TestBaseReport {

        /*
    To create report in TestNG

    1) add dependency com.aventstack  4.0.9
    2) extend the class to TestBaseReport
    3) in the test class you should create the test by using objects from TestBaseReport
    extentTest = extentReports.createTest("Amazon Nutella Test","User should be able to search for Nutella");

    4) write info for each step by using extentTest object
        - if it is not an assertion we should use extentTest.info method
        - if it is an assertion we should use extentTest.pass method

*/
  @Test
    public void test01() {

      // 1) go to the amazon.com
      // 2) Search for Nutella
      // 3) Test that result text has nutella

      extentTest = extentReports.createTest("Amazon Nutella Test", "User should be able to search for Nutella");
      // 1) go to the amazon.com
      Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
      extentTest.info("User reached the website (amazon)");

      // 2) Search for nutella
      AmazonPage amazonPage = new AmazonPage();
      amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchedContent") + Keys.ENTER);
      extentTest.info("User search for Nutella on Amazon");

      // 3) Test that result text has Nutella
      String expectedContent = ConfigReader.getProperty("amazonExpectedSearchContent");
      String actualContent = amazonPage.searchResultElement.getText();
      extentTest.info("System saved result content");

      Assert.assertTrue(actualContent.contains(expectedContent));
      extentTest.pass("Tested that result content contains the expected content");


   //   Driver.closeDriver();  // TestBaseReport closed the page already.


              /*  go to test-output
              right-click the report
              open in chrome
              */
  }
}
