package tests.day15_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_QualitydemyLoginTest_NonManuel {

    @Test
    public void test01() {

        // QUALITYDEMY ANA SAYFAYA GIDIN
        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyURL"));
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

    //    WebElement cookieAccept = Driver.getDriver().findElement(By.xpath("//a[text()='Accept']"));
    //    cookieAccept.click();

        // login linkine tiklayin
        qualitydemyPage.firstLoginLink.click();

        // gecerli username ve sifre yi ilgili kutulara yazin
        qualitydemyPage.emailBox.sendKeys(ConfigReader.getProperty("qdValidUsername"));
        qualitydemyPage.passwordBox.sendKeys(ConfigReader.getProperty("qdValidPassword"));

        // login butonuna basin
        qualitydemyPage.loginButton.click();

        // basarili olarak giris yapildigini test edin
        Assert.assertTrue(qualitydemyPage.successfulLoginElement.isDisplayed());

        // sayfayi kapatin

        Driver.closeDriver();
    }

}
