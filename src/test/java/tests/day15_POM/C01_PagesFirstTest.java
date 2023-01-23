package tests.day15_POM;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C01_PagesFirstTest {

    @Test (groups = {"reg2","smoke1","reg4"})
    public void amazonTest(){

        // amazon anasayfaya gidelim

        Driver.getDriver().get("https://www.amazon.com");
        // Nutella icin arama yapalim
        // Arama kutusunun locate'i pages sayfasinda
        // POM'de pages sayfasindaki locate'lere erismek icin
        // pages sayfalarindan bir obje olusturulur.

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("Nutella" + Keys.ENTER);

        // sonuclarin Nutella icerdigini test edelim
        String expectedContent = "Nutella";
        String actualSearchResultContent = amazonPage.searchResultElement.getText();
        Assert.assertTrue(actualSearchResultContent.contains(expectedContent));

        Driver.closeDriver();
    }
}
