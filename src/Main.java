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

        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {9,2,3,4,5,6,7,8,1};
        int[] c = {};
        int[] d = {1,1,1,1,2,2,3,3,8,9,9,9};
        int[] e = {-7,3,2,6,-8,-9,5,1,2,8,13,-4};

        //for (int i:e) { System.out.print(i + " "); }

        //Oblig1.sortschmort(e);
        Oblig1.delsortering(e);

        //System.out.println();

        //for (int i:e) { System.out.print(i + " "); }
    }
}
