import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        int[] a = Oblig1Test.randPerm(100);
        System.out.println(Arrays.toString(a));
        Oblig1.quicksort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));


    }
}
