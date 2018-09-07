import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {


        /*
        //Test for oppgave5
        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(Arrays.toString(a));
        Oblig1.rotasjon(a);
        */
        /*
        //Test for oppgave6
        char[] a = {'A','B','C','D'};
        System.out.println(Arrays.toString(a));
        Oblig1.rotasjon(a,-3);
        //for (int i:test) { System.out.print(i + " "); }
        */

        String s = "qwerty";
        String t = "qwerty";

        String result = Oblig1.flett(s,t);
        System.out.print(result);
    }
}
