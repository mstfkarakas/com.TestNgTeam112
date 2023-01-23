package tests.day15_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_Qualitydemy_NegativeLogin {

    @Test (groups = {"reg1","smoke"})
    public void test01() {

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyURL"));
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        WebElement cookieAccept = Driver.getDriver().findElement(By.xpath("//a[text()='Accept']"));
        cookieAccept.click();

        // login linkine tiklayin
        qualitydemyPage.firstLoginLink.click();

        // gecerSIZ username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdInvalidUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdInvalidPassword"));

        // login butonuna basin
        qualitydemyPage.loginButton.click();

        // basariSIZ olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());

        // sayfayi kapatin
        Driver.quitDriver();

    }


}
