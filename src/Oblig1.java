
public class Oblig1 {


    //***************************** OPPGAVE 6 *****************************************

    /**
     * Metode som "rotere" innholdet i tabellen a én enhet. En rotasjon i en tom tabell eller i en tabell med nøyaktig
     * ett element er ingen feilsituasjon, men rotasjonen vil da ikke endre noe. Metoden tar inn en parameter for som
     * sier noe om hvor mange rotasjoner som skal utføres. Negativt tall roterer motsatt vei.
     *
     * @param a arrayet som skal roteres
     * @param k antall rotasjoner, og retning
     */

    public static void rotasjon(char[] a, int k) {

        if ((a == null) || (a.length == 1)) {
            System.out.println("Ingen endring i rotasjon. Objektet er null, eller array har lengde 1");
        } else {
            char[] b = a.clone();

            if (k < 0) { //ok
                for (int i = 0; i < a.length; ++i) {
                    int j = (i - k) % a.length;
                    a[i] = b[j];
                }
            } else {

                for (int i = 0; i < a.length; ++i) {
                    int j = (i + k) % a.length;
                    a[j] = b[i];
                }
            }
        }
    }
}
