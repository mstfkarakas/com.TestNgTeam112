package utilities;

public class ReusableMethods {

    public static void wait (int second) {

        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {

        }
    }
}
