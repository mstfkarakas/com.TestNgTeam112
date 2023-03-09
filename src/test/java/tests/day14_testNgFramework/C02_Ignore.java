package tests.day14_testNgFramework;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class C02_Ignore {

    @Test(priority = 57) @Ignore    // @Ignore testi ignore eder.
    public void youTubeTest(){
        System.out.println("YouTube");

    }

    @Test(priority = -3) // en kucuk sayi -3 oldugu icin burdan baslar. Kucukten buyuge dogru calisir.
    public void wiseTest(){
        System.out.println("Wise Quarter");

    }

    @Test  // priority yazmassak, 0 degeri alir.
    public void amazonTest(){
        System.out.println("Amazon");

    }

}
