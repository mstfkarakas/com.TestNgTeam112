package tests.day15_POM;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C02_QualitydemyPositiveLoginTest {

    @Test (groups = {"reg2","smoke"})
    public void test01(){

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get("https://www.qualitydemy.com");
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        // login linkine tiklayin
        qualitydemyPage.firstLoginLink.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordBox.sendKeys("Nevzat152032");

        // login butonuna basin
        qualitydemyPage.loginButton.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.successfulLoginElement.isDisplayed());

        // sayfayi kapatin
        Driver.quitDriver();

    }
}
