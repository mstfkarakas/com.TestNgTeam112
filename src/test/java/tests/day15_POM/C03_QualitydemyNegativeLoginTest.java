package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C03_QualitydemyNegativeLoginTest {

    @Test (groups = "reg2")
    public void test01(){

        // qualitydemy anasayfaya gidin
        Driver.getDriver().get("https://www.qualitydemy.com/");
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        // ilk login linkine tiklayin
        qualitydemyPage.firstLoginLink.click();

        // kullanici adi olarak selenium
        qualitydemyPage.emailBox.sendKeys("Selenium@selenium.com");

        // password olarak heyecandir yazin
        qualitydemyPage.passwordBox.sendKeys("heyecandir");

        // login butonuna tiklayin
        qualitydemyPage.loginButton.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());

        // sayfayi kapatin
        Driver.closeDriver();

    }
}
