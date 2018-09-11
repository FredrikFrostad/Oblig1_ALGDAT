import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        int[] a = Oblig1Test.randPerm(10);
        System.out.println(Arrays.toString(a));
        Oblig1.partition(a,0,a.length-1);
        System.out.println(Arrays.toString(a));


    }
}
