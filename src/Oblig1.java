import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Oblig1 {

    // ***************************************** OPPGAVE 1: ****************************************


    /**
     * Metode som finner og returnerer største verdi i et array
     *
     * Metoden utfører flest antall ombyttinger når største verdi ligger på første index index
     * Metoden utfører færrest antall ombyttinger når største verdi ligger på siste index
     *
     * @param a arrayet der den største verdien skal lokaliseres
     * @return den største verdien i arrayet
     */
    public static int maks(int[] a) {

        return -1;
    }

    /**
     * Metode som teller antall ombyttinger som må gjøres i maks-metoden
     * @param a arrayet det vi skal finne største verdi
     * @return antallet sammenligninger som gjøres for å finne største verdi
     */
    public static int ombyttinger(int[] a) {


        return -1;
    }

    /**
     * Metoden maks vil gjøre flest ombyttinger når den største verdien ligger først i arrayet, da vil det utføres n-1 bytter
     * Det gjøres færrest ombyttinger dersom tabellen er sortert i stigende rekkefølge
     * TODO: Fullfør besvarelsen av average case scenario
     * Avsnitt 1.1.6 i kompendiet omhandler average case effektivitet for denne algoritmen. Der får vi vite at det harmoniske
     * tallet for denne algoritmen er Hn tilnærmet lik log(n) - 0,557
     */


    //***************************** OPPGAVE 2  ****************************************


    /**
     * Metode som finner antall ulike verdier i et stigende sortert array
     * @param a arrayet der vi søker etter distinkte verdier
     * @return antall distinkte verdier i arrayet
     */
    public static int antallUlikeSortert(int[] a) {

        return -1;
    }

    /**
     * Metode som sjekker om et array er sortert stigende
     * @param a arrayet som skal kontrolleres
     * @return true dersom gyldig sortert, false ellers
     */
    public static boolean sjekkGyldigFormat(int[] a) {


        return false;
    }

    //***************************** OPPGAVE 3 *****************************************


    /**
     * Metode som finner antall distinkte verdier i et usortert array.
     * Metoden teller antallet duplikater i arrayet, trekker dette tallet fra antall
     * elementer og returnerer differansen
     * @param a arrayet vi skal finne ulike verdier i
     * @return antall ulike verdier
     */
    public static int antallUlikeUsortert(int[] a) {


        return -1;
    }

    //***************************** OPPGAVE 4 *****************************************

    /**
     * Metode som deler et array i to sorterte deler, der venstre side inneholder oddetallene sortert,
     * og høyre side inneholder partallene sortert.
     * @param a arrayet som skal sorteres
     */
    public static void delsortering(int[] a) {


    }

    public static int antallPartall(int[] a) {
        int antPartall = 0;
        for (int k = 0; k < a.length; k++) {
            if (a[k] % 2 == 0) {antPartall++;}
        }
        return antPartall;
    }


    //***************************** OPPGAVE 5 *****************************************

    /**
     * Metode som "rotere" innholdet i tabellen a én enhet. En rotasjon i en tom tabell eller i en tabell med nøyaktig
     * ett element er ingen feilsituasjon, men rotasjonen vil da ikke endre noe.
     * @param a arrayet som skal roteres
     */
    public static void rotasjon(char[] a) {
        if ((a == null)||(a.length ==1)){
            System.out.println("Ingen endring i rotasjon. Objektet er null, eller array har lengde 1");
        }
        else{
            for (int i = a.length-1; i > 0; i--) { //Starter på slutten av array a.length-1 og går til index 0
                char temp = a[i]; //Lagrer unna verdien i index du står i
                a[i] = a[i - 1]; //Erstatter index du står i med verdien til neste index
                a[i-1] = temp; //Dytter mellomlagret verdi inn i neste index
            }
        }
    }

    //***************************** OPPGAVE 6 *****************************************

    /**
     * Metode som "rotere" innholdet i tabellen a én enhet. En rotasjon i en tom tabell eller i en tabell med nøyaktig
     * ett element er ingen feilsituasjon, men rotasjonen vil da ikke endre noe. Metoden tar inn en parameter for som
     * sier noe om hvor mange rotasjoner som skal utføres. Negativt tall roterer motsatt vei.
     * @param a arrayet som skal roteres
     * @param k antall rotasjoner, og retning
     */
    public static void rotasjon(char[] a, int k ) {
        //char[] result = new char[a.length];

        // if x<n, x%n = x
        // if x=n, x%n = 0 =>
        // x % n
/*
        //Circular array running backwards
        for (int i = 0; i < a.length ; i = (i+1)%a.length ) { //i = (i+1)%a.length lager et sirkulært array som looper uendelig
            System.out.print(a[i]);
        }
*/
/*
        //Circular array running backwards
        for (int i = a.length-1; i >=0; i = (i-1)%a.length) {
            System.out.print(a[i]);

            if (i ==0){
                i = a.length;
            }
        }
*/

        if ((a == null)||(a.length ==1)){
            System.out.println("Ingen endring i rotasjon. Objektet er null, eller array har lengde 1");
        }
        else{

            int n = Math.abs(k);

            for (int i = 0; i < n ; i++) {
                char temp;
                int j = 0;

                if(k <0 ){
                    //System.out.println("Du flytter " + n + " mot venstre");
                    while (j < (a.length-1)){
                        temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                        j++;
                    }

                }
                else{
                    //System.out.println("Du flytter " + n + " mot høyre");
                    for (int x = a.length-1; x > 0; x--) { //Starter på slutten av array a.length-1 og går til index 0
                        char tempTest = a[x]; //Lagrer unna verdien i index du står i
                        a[x] = a[x - 1]; //Erstatter index du står i med verdien til neste index
                        a[x-1] = tempTest; //Dytter mellomlagret verdi inn i neste index
                    }
                }


            }

/*
            for (int j = 0; j < k ; j++) {
                for (int i = a.length-1; i > 0; i--) { //Starter på slutten av array a.length-1 og går til index 0
                    char temp = a[i]; //Lagrer unna verdien i index du står i
                    a[i] = a[i - 1]; //Erstatter index du står i med verdien til neste index
                    a[i-1] = temp; //Dytter mellomlagret verdi inn i neste index
                }
            }
*/
/*
            for (int i = 0; i <k ; i++) {
                char temp = a[i]; //Lagrer unna verdien i index du står i
                a[i] = a[i+1];
                a[i+1] = temp;

                char temp2 = a[k];
                a[k] = a[a.length-1];
                rotasjon(a);
            }
*/
            //Testing
            System.out.println(Arrays.toString(a));

        }
    }

    //******************************* OPPGAVE 8 ***************************************


    /**
     * Metode som indekssorterer en tabell. Metoden endrer ikke parametertabellen.
     * @param a Tabellen som vi ønsker indekssortert
     * @return en tabell med indekser ordnet etter elementstørrelse i parametertabellen
     */
    public static int[] indekssortering(int[] a) {

        return null;
    }

    //******************************* OPPGAVE 9 ***************************************

    public static int[] tredjeMin(int[] a){

        return null;
    }


    // **************************** DIVERSE HJELPEMETODER *****************************

    /**
     * Metode som implementerer bubblesort-algoritmen i et intervall
     * @param a arrayet som inneholder intervallet som skal sorteres
     * @param v nedre grense for intervallet
     * @param h øvre grense for intervallet
     */
    public static void bubbleSort(int[] a, int v, int h) {
        int count = 0;
        for (int j = v; j < h; ++j) {
            //Itererer over alle elementene i a
            for (int i = v; i < h - 1; ++i) {

                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    count++;
                }
            }
        }
        System.out.println(count);
    }


    /**
     * Metode som bytter om to verdier i et array
     * @param a arrayet som inneholder verdiene som skal bytte plass
     * @param i index til den ene verdien
     * @param j index til den andre verdien
     */
    public  static void bytt(int[] a, int i, int j) {

        if (i < 0 || i > a.length - 1 || j < 0 || j > a.length - 1) {
            throw new IllegalArgumentException
                    ("Illegal input argument. Input must be within array bounds");
        }

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /**
     * Metode som finner index til største verdi i et array, dersom arrayet inneholder duplikatverdier er det
     * høyreverdien som returneres
     * @param a arrayet vi skal søke etter største verdi i
     * @return index til største verdi
     */
    public static int maksIndex(int[] a) {

        //Sjekker om arrayet er gyldig (ikke null)
        if(a == null) throw new NullPointerException
                (a.toString() + "is null");

        int m = 0;              // indeks til største verdi i a[0:til>
        int maksverdi = a[0];   // største verdi i a[0:a.length>

        for (int i = 0 + 1; i < a.length; i++) {
            if (a[i] >= maksverdi)
            {
                m = i;                // indeks a.lenght største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    /**
     * Metode som finner index til største verdi i et intervall, dersom arrayet inneholder duplikatverdier er det
     * høyreverdien som returneres
     * @param a arrayet vi skal søke etter største verdi i
     * @return index til største verdi
     */
    public static int maksIndex(int[] a,int fra, int til) {

        //Sjekker om arrayet er gyldig (ikke null)
        if(a == null) throw new NullPointerException
                (a.toString() + "is null");

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:a.length>

        for (int i = fra + 1; i <= til; i++) {
            if (a[i] >= maksverdi)
            {
                m = i;                // indeks a.lenght største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }


    /**
     * Metode som finner index til minste verdi i et array, dersom arrayet inneholder duplikatverdier er
     * det index til venstreverdien som returneres
     * @param a arrayet vi skal søke etter minste verdi i
     * @return index til minste verdi
     */
    public static int minIndex(int[] a) {

        int m = 0;
        int minverdi = a[0];

        for (int i = 0 + 1; i < a.length; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }
}
