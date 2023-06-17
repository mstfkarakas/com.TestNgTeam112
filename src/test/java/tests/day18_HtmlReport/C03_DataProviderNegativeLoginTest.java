package tests.day18_HtmlReport;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProviderNegativeLoginTest {
    @DataProvider
    public static Object[][] provideUsernameAndPassword() {
        Object[][] provideUsernameAndPassword = {{"merhaba@televole.com", "12345"},{"qwert","12345"},{"asdfg","2345"},{"zxcvb","5678"}};

        return provideUsernameAndPassword;
    }

    // 1) go to the QualityDemy homepage
    // 2) enter wrong password and username
    // 3) test that user can not login
    /*
    // username     password
    // A11          A12345
    // B12          B12345
    // C13          C12345
    // D14          D12345
    // E15          E12345
     */


    @Test(dataProvider = "provideUsernameAndPassword")
    public void test(String username, String password){

        Driver.getDriver().get(ConfigReader.getProperty("qualitydemyURL"));
        QualitydemyPage qualitydemyPage = new QualitydemyPage();

        qualitydemyPage.firstLoginLink.click();
        qualitydemyPage.emailBox.sendKeys(username);
        qualitydemyPage.passwordBox.sendKeys(password);
        qualitydemyPage.loginButton.click();

        Assert.assertTrue(qualitydemyPage.emailBox.isEnabled());


    }

}
