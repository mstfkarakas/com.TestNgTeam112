package tests.day15_hard_soft_assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_HardAssert {

    @Test (groups = "reg1")
    public void test01(){


        Assert.assertTrue(6>4);  //True
        System.out.println("after first assertion");

        Assert.assertTrue(6>14);  // False. Test failed.
        System.out.println("after second assertion");

        Assert.assertEquals(6,6); // Not checked after the failed test above.
        System.out.println("after third assertion");

    }
}
