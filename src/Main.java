import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        int[] a = Oblig1Test.randPerm(10);
        System.out.println(Arrays.toString(a));
        // quicktest.quickSort(a,0,a.length-1);
        //int i = quicktest.partition(a,0,a.length-1);
        //int i = Oblig1.partition(a,0,a.length-1);
        //System.out.println("index: " + i);
        Oblig1.quicksort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));


    }
}
