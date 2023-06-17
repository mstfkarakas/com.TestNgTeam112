package tests.day16_POM_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertions {

    @Test
    public void hardAssertion() {

        /*
            Assert islemi ilk failed oldugunda
            Selenium calismayi durdurur
            ve java.lang.AssertionError: verir

            Eger bir test method'u icinde birden fazla assertion varsa
            ilk failed olanda calisma durur
            sonraki assertion'lar calismamis olur

            TestNG bu konuda da bize daha fazla kontrol yetkisi vermistir
            Istersek TestNG assertion failed olsa bile
            bizim istedigimiz satira kadar
            kodlarin calismaya devam etmesini saglar

            "artik rapor ver" dedigimizde
            failed olan tum assertion'lari raporlar
            ve failed olan varsa calismayi durdurur
         */

        int num = 23;

        Assert.assertFalse(num % 2 == 0, "Number must be even");
        Assert.assertTrue(num < 100, "Number must be greater than 100");
        Assert.assertTrue(num < 1000, "Number must be smaller than 1000");
        Assert.assertFalse(num % 3 == 0, "Number must not be a multiple of 3");
    }

    @Test
    public void softAssertionTest() {

        /*
            SoftAssert class'i sayesinde
            assertAll()'nun calisacagi satira kadar
            failed olan olsa bile, tum assertion'lar calismaya devam eder.

            assertAll() calistiginda
            failed olan assertion'lara ait raporu verir
            ANCAK hangi satirda olduklarini vermez

            Selenium hata mesaji da assertAll()'un bulundugu satiri isaret eder.

            Failed olan assertion'lari kolaylikla bulabilmemiz icin
         */

        int num = 102;
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(num % 2 == 0, "Number must be even");
        softAssert.assertTrue(num > 100, "Number must be greater than 100");
        softAssert.assertTrue(num < 1000, "Number must be smaller than 1000");
        softAssert.assertFalse(num % 3 == 0, "Number must not be a multiple of 3");

        softAssert.assertAll();
    }
}
