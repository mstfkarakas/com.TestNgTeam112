package tests.day15_POM;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_ConfigurationFileUse {

    /*
       POM'de hedef test class'inda
       manuel olarak hic bir Test Data'si GIRMEMEKTIR

       Test datalari :
       1- Kullanacagimiz WebDriver : Driver class'indan dinamik olarak kullaniyoruz
       2- Locate : Locate'leri pages sayfalarindan dinamik olarak kullaniyoruz
       3- Ne Kaldi: String degerler olan data'lar kaldi:
          kullanilan Url, aranan kelime, expected icerik, dogru kullanici adi,
          yanlis kullanici adi, yanlis sifre... gibi datalar.
          txt gibi ama txt olmayan bi dosya olusturacagiz.
    */


    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys(ConfigReader.getProperty("amazonSearchedContent") + Keys.ENTER);

        String expectedContent = ConfigReader.getProperty("amazonExpectedContent");
        String actualSearchedContent = amazonPage.searchResultElement.getText();

        Assert.assertTrue(actualSearchedContent.contains(expectedContent));


        Driver.closeDriver();
    }
}
