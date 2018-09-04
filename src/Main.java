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
        for (int i = 0; i < 10; i++) {
            try {

                int[] a = Oblig1.randPerm(10);
                int c = Oblig1.ombytting(a);
                System.out.println("\nAntall ombyttinger utført: " + c);

            }catch (NoSuchElementException e) {
                System.out.println(e);
            }
        }

    }
}
