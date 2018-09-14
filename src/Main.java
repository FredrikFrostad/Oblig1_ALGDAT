import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        int total = 0;
        int i;
        for (i = 0; i < 100000; i++) {
            int[] a = Oblig1Test.randPerm(100);
            total += Oblig1.ombyttinger(a);
        }
        System.out.println("snitt: " + total/i);
    }
}
