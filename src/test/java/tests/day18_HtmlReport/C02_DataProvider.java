package tests.day18_HtmlReport;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] wordsToSearchOnAmazon() {

        Object[][] wordsToSearchOnAmazonArray= {{"Nutella"},{"Java"},{"Samsung"},{"GPU"},{"Apple"}};

        return wordsToSearchOnAmazonArray;
    }

    /*
    To execute same test with a lot of different data, we can use @DataProvider

    We should create the test according to the data provider

    1) we should add dynamic parameters
    2) after the @Test annotation we should add (dataProvider = "theValue")
    3) then we should create a method to provide data (we can right-click on the data provider value to create it)
    4) we should enter all the data in a two-dimensional object array, and we should return the array

     **** when we use a lot of data values in our test it is called DDT (DATA DRIVEN TEST)

    */


    @Test(dataProvider = "wordsToSearchOnAmazon")
    public void test(String amazonSearchedContent){
        // search for nutella in amazon.com and test it

        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys(amazonSearchedContent + Keys.ENTER);

        String expectedWord = amazonSearchedContent;
        String actualContent = amazonPage.searchResultElement.getText();

        Assert.assertTrue(actualContent.contains(expectedWord));


    }
}
