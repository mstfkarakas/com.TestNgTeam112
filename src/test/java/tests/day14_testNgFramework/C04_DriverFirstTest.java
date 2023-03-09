package tests.day14_testNgFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverFirstTest {

    @Test
    public void test01(){

    /*
        Page objet model, Java'daki OOP consept'e dayanir
        1- Driver class'inda webdriver olusturup kulanmak icin static yontem kullanilir
        2- Locate'leri page sayfalarinda yapip
           onlara obje olusturarak ulasabiliriz
     */

        Driver.getDriver().get("https://www.amazon.com");

        // Driver.getDriver().get("https://www.wisequarter.com");

        // Driver.getDriver().get("https://www.youtube.com");

        // Nutella icin arama yapin
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Arama sonuclarinin Nutella icerdigini test edin.
        WebElement searchedElement = Driver.getDriver().findElement(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']"));
        String expectedContent = "Nutella";
        String actualContent = searchedElement.getText();
        Assert.assertTrue(actualContent.contains(expectedContent));


        Driver.closeDriver();
    }


}
