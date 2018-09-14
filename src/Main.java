import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        //int[] a = Oblig1Test.randPerm(100);
        //System.out.println(Arrays.toString(a));
        //Oblig1.quicksort(a,0,a.length-1);
        //System.out.println(Arrays.toString(a));


        //int[] b = {4,6,7,9,-2,-3,-10,16,-13};
        //Oblig1.delsortering(b);
        //System.out.println(Arrays.toString(b));

        Oblig1.inneholdt2("ABBA", "RABARBRA");

        String s = "asdfghjkløæqwertyuiopåzxcvbnm";
        char[] c = s.toCharArray();
        Oblig1.quicksort(c,0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }
}
