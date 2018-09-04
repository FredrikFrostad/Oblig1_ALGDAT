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

    }
}
