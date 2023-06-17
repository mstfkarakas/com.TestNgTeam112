package tests.day19_CrossBrowserTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.TestBaseCross;

public class C01_AmazonNutellaTest extends TestBaseCross {

    // Go to the amazon.com
    // search for nutella
    // test that result text contains nutella


    @Test
    public void test01() {
        // Go to the amazon.com
        driver.get(ConfigReader.getProperty("amazonURL"));

        // search for nutella
        // we did not use AmazonPage class because in amazonPage class we are using normal Driver class
        // But to do crossBrowser testing we need to use CrossDriver
        /*
        there are two ways to handle this problem
            ) we can cretae another page class for cross testing
            ) or we can directly locate the webelement without using any page class  (*)
         */

        // search for nutella

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // test that result text contains nutella
        String expectedWord = "Nutella";
        String actualWord = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actualWord.contains(expectedWord));
    }


}
