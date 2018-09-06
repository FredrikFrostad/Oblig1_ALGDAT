import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {

        /*
        int[] b = new int[0];
        System.out.println(maks(b));
        for (int e:b) {
            System.out.print(e + " ");
        }
        */
        /*
        try {
            maks(b);
        }catch (NoSuchElementException e) {
            System.out.println(e);
        }
*/


        /*
        int snitt = 0;
        int n = 100000;

        for (int i = 0; i < n; i++) {
            try {

                int[] a = Oblig1.randPerm(10);
                //int[] a = {1,2,3,4,5};

                int c = Oblig1.ombytting(a);
                System.out.println("\nAntall ombyttinger utført: " + c);
                snitt += c;

            }catch (NoSuchElementException e) {
                System.out.println(e);
            }
        }

        System.out.println("Gjennomsnittet er: " + snitt/n + " ombyttinger");
*/


/*      Test av oppgave 2
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {9,2,3,4,5,6,7,8,1};
        int[] c = {};
        int[] d = {1,1,1,1,2,2,3,3,8,9,9,9};

        //Testprint
        System.out.println(d.length);


        System.out.println(Oblig1.antallUlikeSortert(d));
  */
/*
        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {9,2,3,4,5,6,7,8,1};
        int[] c = {};
        int[] d = {1,1,1,1,2,2,3,3,8,9,9,9};
        int[] e = {2,-7,3,2,6,-8,0,-9,5,1,2,8,13,15};
        a = new int[]{-4, -1, 3, 0, 2, -3, -2, 4, 1};

        for (int i:e) { System.out.print(i + " "); }

        Oblig1.delsortering(e);
        //Oblig1.bubble(e,0, 5);
        //Oblig1.bubble(e,5, a.length);
        System.out.println("test");
        //System.out.println();

        for (int i:e) { System.out.print(i + " "); }
*/

//        int[] a = {1,2,3,4,5,6,7,8,9};
        //int[] b = {9,2,3,4,5,6,7,8,1};
        //int[] c = {};
        //int[] d = {1,1,1,1,2,2,3,3,8,9,9,9};
        //int[] e = {2,-7,3,2,6,-8,0,-9,5,1,2,8,13,15};
        //a = new int[]{-4, -1, 3, 0, 2, -3, -2, 4, 1};

        //int[] test = Oblig1.indekssortering(a);

        //for (int i:test) { System.out.print(i + " "); }

        /*
        //Test for oppgave5
        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(Arrays.toString(a));
        Oblig1.rotasjon(a);
        */

        //Test for oppgave6
        char[] a = {'A','B','C','D','E','F','G','H','I','J'};
        System.out.println(Arrays.toString(a));
        Oblig1.rotasjon(a,-2);
    }
}
