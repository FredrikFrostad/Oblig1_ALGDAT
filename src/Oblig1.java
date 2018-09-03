import java.util.NoSuchElementException;

public class Oblig1 {

    /**
     * Metode som bytter om to verdier i et array
     * @param a arrayet som inneholder verdiene som skal bytte plass
     * @param i index til den ene verdien
     * @param j index til den andre verdien
     */
    public  static void bytt(int[] a, int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * Metode som finner og returnerer største verdi i et array
     * @param a arrayet der den største verdien skal lokaliseres
     * @return den største verdien i arrayet
     */
    public static int maks(int[] a) {

        if (a.length < 1) {
            throw new NoSuchElementException
                    ("\nTabellen er tom, vennligst send en gyldig tabell som parameter.");
        }

        int m = a[0];

        for (int i = 0; i < a.length - 1; ++i) {

            if (a[i] >  a[i + 1]) {
                bytt(a,i, i +1);
                m = a[i+1];
            }
        }

        return m;
    }

    public static void main(String[] args) {

        int[] a = {6,3,8,0,7,4,2};
        int[] b = new int[0];
        System.out.println(maks(a));
        for (int e:a) {
            System.out.print(e + " ");
        }

        try {
            maks(b);
        }catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }
}
