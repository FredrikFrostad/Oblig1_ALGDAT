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

        //Sjekker at tabellen ikke er tom
        if (a.length < 1) {
            throw new NoSuchElementException
                    ("\nTabellen er tom, vennligst send en gyldig tabell som parameter.");
        }

        //Initialiserer variabel som holder på største verdi
        int m = a[0];

        //Itererer over arrayet og "bobler" største verdi "oppover"
        for (int i = 0; i < a.length - 1; ++i) {

            if (a[i] >  a[i + 1]) {
                bytt(a,i, i +1);
                m = a[i+1];
            }
            else
                {
                    m = a[i+1];
                }
        }
        System.out.println(m);
        return m;
    }

    /**
     * Metode som teller antall ombyttinger som må gjøres i maks-metoden
     * @param a arrayet det vi skal finne største verdi
     * @return antallet sammenligninger som gjøres for å finne største verdi
     */
    public static int ombyttinger(int[] a) {

        int counter = 0;

        //Sjekker at tabellen ikke er tom
        if (a.length < 1) {
            throw new NoSuchElementException
                    ("\nTabellen er tom, vennligst send en gyldig tabell som parameter.");
        }

        //Initialiserer variabel som holder på største verdi
        int m = a[0];

        //Itererer over arrayet og "bobler" største verdi "oppover"
        for (int i = 0; i < a.length - 1; ++i) {

            if (a[i] >  a[i + 1]) {
                bytt(a,i, i +1);
                counter++;
                m = a[i+1];
            }
        }
        return counter;
    }

    /**
     * Metoden maks vil gjøre flest ombyttinger når den største verdien ligger først i arrayet, da vil det utføres n-1 bytter
     * Det gjøres færrest ombyttinger dersom tabellen er sortert i stigende rekkefølge
     * TODO: Fullfør besvarelsen av average case scenario
     * Avsnitt 1.1.6 i kompendiet omhandler average case effektivitet for denne algoritmen. Der får vi vite at det harmoske
     * tallet for denne algoritmen er Hn tilnærmet lik log(n) - 0,557
     */


    //***************************** OPPGAVE 2  ****************************************


    /**
     * Metode som finner antall ulike verdier i et stigende sortert array
     * @param a arrayet der vi søker etter distinkte verdier
     * @return antall distinkte verdier i arrayet
     */
    public static int antallUlikeSortert(int[] a) {

        //Variabel som holder på returverdi
        int distinct = 0;

        //Sjekker om tabellen er tom
        if (a.length == 0) {return distinct;}

        //Sjekker om tabellen er sortert stigende
        if (sjekkGyldigFormat(a))
        {
            //Dersom tabellen ikke er tom inneholder den minst en distinkt verdi
            distinct = 1;

            //Sjekker om neste verdi er ulik forrige og øker teller dersom true
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] != a[i + 1])
                {
                    distinct++;
                }
            }
        }else
        {
            throw new IllegalStateException
                    ("Parametertabellen må være sortert stigende");
        }


        return distinct;
    }

    /**
     * Metode som sjekker om et array er sortert stigende
     * @param a arrayet som skal kontrolleres
     * @return true dersom gyldig sortert, false ellers
     */
    public static boolean sjekkGyldigFormat(int[] a) {

        //Sjekker om tabellen har gyldig format (er sortert stigende)
        if (maksIndex(a) != a.length - 1 || minIndex(a) != 0)
        {
         return false;
        }
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
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

        //Variabel som holder på returverdi
        int distinct = a.length;
        //Variabler som teller antall duplikattall
        int duplicate = 0;

        //Sjekker om tabellen er tom
        if (a.length == 0) {return 0;}

        //Ytre for løkke som itererer gjennom tabellen en gang
        for (int i = 0; i < a.length; i++) {

            //Indre løkke itererer over alle elementer i tabellen opp til i
            //Dersom vi finner at a[i] er lik et element til venstre i tabellen er
            //a[i] et duplikattall og teller øker med en.
            for (int j = 0; j < i; j++) {

                //sjekker om vi har funnet et duplikattall,
                // øker i så fall teller med en og hopper ut av indre loop
                if (i != j && a[i] == a[j])
                {
                    duplicate++;
                    break;
                }
            }
        }

        return distinct - duplicate;
    }

    //***************************** OPPGAVE 4 *****************************************

    /**
     * Metode som deler et array i to sorterte deler, der venstre side inneholder oddetallene sortert,
     * og høyre side inneholder partallene sortert.
     * @param a arrayet som skal sorteres
     */
    public static void delsortering(int[] a) {

        int i = 0;
        int j = a.length - 1;

        //Iterer gjennom arrayet en gang med ytre while løkke
        while (i < a.length) {
            //Dersom vi finner et partall bytter det plass med det oddetallet som er lengst
            //til venstre for gjeldende posisjon i arrayet.
            if (a[i] % 2 == 0) {
                //Itererer over mulige oddetall til høyre for a[i]
                while (j > i) {
                    //Dersom vi finner et oddetall bytter vi plass med partallet a[i]
                    if (a[j] % 2 != 0) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                        break;
                    }
                    --j;
                }
            }
            ++i;
        }
        //finner antall partall for å beregne korrekte intervaller for sortering
        int partall = antallPartall(a);
        //sorterer hvert av intervallene separat
        //bubbleSort(a,0,a.length-partall);
        //bubbleSort(a,a.length-partall, a.length);
        Arrays.sort(a,0,a.length-partall);
        Arrays.sort(a,a.length-partall, a.length);
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

//test
    }

    //******************************* OPPGAVE 8 ***************************************

    public static int[] indekssortering(int[] a) {

        int[] index = new int[a.length];

        for (int i = 0; i < index.length; i++) {
            index[i] = -i-1;
        }

        int[] b = Arrays.copyOf(a,a.length);

        Arrays.sort(b);

        for (int i = 0; i < a.length;i++) {     //iterere over tabell index
            finnIndex(a,b,index,i,i);
        }

        return index;
    }

    public static void finnIndex(int[] a, int[] b, int[] index, int start, int position) {

        for (int i = start; i < a.length; i++) {
            if (b[position] == a[i]) {
                for (int j = 0; j < a.length; j++) {
                    if (index[j] == i) {
                        finnIndex(a,b,index,i,position);
                    }else
                        {
                            index[position] = i;
                        }
                }
            }
        }
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


    /**
     * Metode som genererer et randomisert array
     * @param n arrayets lengde
     * @return det permuterte arrayet
     */
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

}
