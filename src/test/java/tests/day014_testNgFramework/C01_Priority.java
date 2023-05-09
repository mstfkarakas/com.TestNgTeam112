package tests.day014_testNgFramework;

import org.testng.annotations.Test;

public class C01_Priority {

    // testNg
    // priority girilmezse veya ayni deger girilirse, harf sirasina gore calistirir.

    @Test(priority = 57)
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
