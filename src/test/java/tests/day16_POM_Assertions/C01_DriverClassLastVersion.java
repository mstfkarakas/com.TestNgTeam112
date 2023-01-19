package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DriverClassLastVersion {
    // 3 tane test methodu olusturalim

    // 1. method'da amazon'a gidip, url'in amazon icerdigini test edin
    @Test
    public void amazonTest() {

        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        String expectedContent = "amazon";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedContent));


    }
    // 2. method'da Wisequarter anasayfaya gidip, title'in Wise Quarter icerdigini test edin

    @Test
    public void WisequarterTest() {
        Driver.getDriver().get(ConfigReader.getProperty("wiseURL"));
        String expectedContent = "Wise Quarter";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedContent));

    }
    // 3. method'da facebook anasayfaya gidip, title'in Facebook icerdigini test edin

    @Test
    public void test03() {
        Driver.getDriver().get(ConfigReader.getProperty("faceURL"));
        String expectedContent = "Facebook";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedContent));

    }

    // her method'da yeni driver olusturup, method sonunda driver'i kapatin



}
