package tests.day014_testNgFramework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_DependsOnMethod {

    @Test (dependsOnMethods = "wiseTest")
    public void youTubeTest(){
        System.out.println("YouTube");
        Assert.assertTrue(8==8);

    }

    @Test(priority = 3)
    public void wiseTest(){
        System.out.println("Wise Quarter");

    }

    @Test (dependsOnMethods = "youTubeTest")
    public void amazonTest(){
        System.out.println("Amazon");

    }

}
