package tests.day17_ReusableMethods_XmlFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SwitchToNewWindow {

    // go to the https://the-internet.herokuapp.com/iframe
    // click on elemental selenium link
    // title of new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
    // switch to new tab


    @Test (groups = "reg2")
    public void test() {

// go to the https://the-internet.herokuapp.com/iframe
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");

// click on elemental selenium link
        WebElement link = Driver.getDriver().findElement(By.xpath("//a[text()='Elemental Selenium']"));
        ReusableMethods.clickWithTimeOut(link,3);  // bu metodu da denedim ama runningParallelClassesTest.xml yine fail oldu.


//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
//        Driver.getDriver().switchTo().window(originalHandleValue);


        // title of new tab is "Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro"
        // switch to new tab

        // to switch to new tab we used a method from reusableMethods class
        ReusableMethods.switchToWindow("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro");


        String expectedContent = "A free, once-weekly e-mail on how to use Selenium like a Pro";
        String actualContent = Driver.getDriver().findElement(By.xpath("//h2[text()='A free, once-weekly e-mail on how to use Selenium like a Pro']")).getText();
        Assert.assertEquals(actualContent, expectedContent);

        Driver.quitDriver();

    }


}
