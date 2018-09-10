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

        //Har tabellen lengde 0?
        if (a.length==0){
            throw new NoSuchElementException("Tabellen har langde 0. Den er tom! ");
        }

        int m = a[0]; //Variabel for å lagre unna største verdi. Må initieres der hvor løkka starter å kjøre.

        //Looper igjennom arrayet.
        for (int i = 0; i <= a.length-2 ; i++ ) { //

            if(a[i] > a[i+1]) {
                m = a[i]; //Tar vare på det største tallet.
                bytt(a,i,i+1); //Det største tallet skal boble oppover mot slutten av tabellen.
            }
            else{ //Hvis ikke nest siste er større enn siste, så er den største verdien på siste index
                m = a[i+1];
            }
        }
        return m;
    }

    /**
     * Metode som teller antall ombyttinger som må gjøres i maks-metoden
     * @param a arrayet det vi skal finne største verdi
     * @return antallet sammenligninger som gjøres for å finne største verdi
     */
    public static int ombyttinger(int[] a) {

        //Har tabellen lengde 0?
        if (a.length==0){
            throw new NoSuchElementException("Tabellen har langde 0. Den er tom! ");
        }

        int nOmbyttinger = 0;

        for (int i = 0; i <= a.length-2 ; i++ ) { //

            if(a[i] > a[i+1]) {
                bytt(a,i,i+1); //Det største tallet skal boble oppover mot slutten av tabellen
                nOmbyttinger++;
            }

        }
        //System.out.println("Antall byttinger: " + nOmbyttinger);
        return nOmbyttinger;
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
        int antallUlikeSorterte = 1; //Minst 1 ulik hvis a har en lengde på 1

        if(a.length == 0)
            return 0;

        for (int i = 1; i < a.length ; i++) {
            if(a[i-1]<a[i]) {
                antallUlikeSorterte++;
            }
            else if(a[i-1]>a[i]){ //Hvis den neste verdien er større en den du står i, så har vi en inversjon, og en usortert tabell
                throw new IllegalStateException("Tabellen er ikke sortert stigende! Sorter tabellen først");
            }
        }
        return antallUlikeSorterte;
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

        if(a.length == 0)
            return 0;

        int antallDuplikat = 0;
                //(int)Arrays.stream(a).distinct().count();
        //System.out.println(Arrays.stream(a).distinct().count());


        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < i ; j++) {
                if (a[i]==a[j]){
                    antallDuplikat++;
                    break;
                }
            }
        }
        //System.out.println(antallDuplikat);
        return a.length-antallDuplikat;
    }

    //***************************** OPPGAVE 4 *****************************************

    /**
     * Metode som deler et array i to sorterte deler, der venstre side inneholder oddetallene sortert,
     * og høyre side inneholder partallene sortert.
     * @param a arrayet som skal sorteres
     */
    public static void delsortering(int[] a) {
        //Har tabellen lengde 0?
        if (a==null){
            throw new NoSuchElementException("Tabellen har langde 0. Den er tom! ");
        }

        //Moving the odd number over to the left side
        int oddMoved = 0; //Funker til å flytte odde nummere på venstre side, og som offsett for når even nummere starter
        for (int i = 0; i < a.length ; i++) {
            if(Math.abs(a[i]%2)==1){
                bytt(a,oddMoved,i);
                oddMoved++;
            }
        }

        //Arrays.sort er rask nok
        Arrays.sort(a,0,oddMoved);
        Arrays.sort(a,oddMoved,a.length);

        //Bublesort er for treigt
        //bubbleSort(a,0,oddMoved);
        //bubbleSort(a,oddMoved,a.length);








/*      DETTE FUNKER MEN BLIR FOR TREIGT!
        //Finner miste verdi for odde og fyller opp fra index 0 til oddMoved offseten
        for (int i = 0; i < oddMoved; i++) {
            int minst = minIndex(a,i,oddMoved);
            bytt(a, i, minst);
        }

        //Finner miste verdi for odde og fyller opp fra index 0 til oddMoved offseten
        for (int i = oddMoved; i < a.length; i++) {
            int minst = minIndex(a,i,a.length);
            bytt(a, i, minst);
        }
*/


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
        char[] a2 = new char[a.length];
        char[] b = new char[a.length];

        for (int i = 0; i <a.length ; i++) {
            a2[i] = a[i];
        }

        if ((a == null)||(a.length ==1)){
            System.out.println("Ingen endring i rotasjon. Objektet er null, eller array har lengde 1");
        }
        else{

            int n = Math.abs(k);
/*
            for (int j = 0; j < a.length-1; j++) {
                int temp2 = a[j+k];
                a[j+k]= a[j];
            }
*/

            int j = 1;
            char tempA;
            char temp1;
            char temp2;

            System.out.println("Array a: "+ Arrays.toString(a));
            for (int i = 0; i < a.length ; i++) {


                System.out.println("");
                System.out.println("LOOP RUNDE: " + (i+1) + ", k=" +k);



                if (k<0){


                    System.out.println("Array a: i="+ i +"("+a2[i]+")" + " => Array b: i=" + i+k+a.length +"("+b[(i+k+a2.length)%a2.length]+")");
                    b[(i+k+a2.length)%a2.length] = a2[i];
                    System.out.println(Arrays.toString(a2) + " - origin");
                    System.out.println(Arrays.toString(b));
                    System.out.println();

                    System.out.println("Array a: i="+ i +"("+a[i]+")" + " => Array a: i=" + i+k+a.length +"("+a[(i+k+a.length)%a.length]+")");
                    a[(i+k+a.length)%a.length] = a[i];
                    System.out.println(Arrays.toString(a2) + " - origin");
                    System.out.println(Arrays.toString(a));
                }
                else{


                    System.out.println("Array a: i="+ i +"("+a2[i]+")" + " => Array b: i=" + ((k*j)+i)%a2.length +"("+b[((k*j)+i)%a2.length]+")");
                    b[(i+k)%a2.length] = a2[i];
                    System.out.println(Arrays.toString(a2) + " - origin");
                    System.out.println(Arrays.toString(b));

                    System.out.println();

                    System.out.println("Array a: i="+ i +"("+a[i]+")" + " => Array a: i=" + ((k*j)+i)%a.length +"("+a[((k*j)+i)%a.length]+")");
                    temp1 = a[(i+k)%a.length];
                    a[(i+k)%a.length] = a[i];
                    System.out.println(Arrays.toString(a2) + " - origin");
                    System.out.println(Arrays.toString(a));
                }








 /*
              //Får ikke fancy løsning til å funke
                //int temp = a[(n*i)%a.length];
                //System.out.println("Gjeldende index i=" +i);
                //System.out.println("Index som lagres unna=" + i + "*" + n + "%"+ a.length+ "=" + (n*i)%a.length);
                //System.out.println("Fra index:" + i);
                //System.out.println("Til index:" + ((i+k)%a.length));
                System.out.println("");
                System.out.println("LOOP RUNDE: " + (i+1) + ", k=" +k);
                int fra = i;
                int til = (i+k)%a.length;

                System.out.println("j=" + j + ", i=" + i +", Array før endring: "+Arrays.toString(a));


                temp1 = a[((k*j)+i)%a.length]; //Den "neste" indeksen
                System.out.println("Lagret unna verdi:" + temp1+"(i=" + (((k*j)+i)%a.length)+")");


                System.out.println("i="+ i +"("+a[i]+")" + " => i=" + ((k*j)+i)%a.length +"("+a[((k*j)+i)%a.length]+")");
                a[((k*j)+i)%a.length] = a[i];

                tempA = a[i+1];
                System.out.println("tempA("+tempA+")" + " => "  + "i=" +i +"(" + a[i]+")" );

                System.out.println("Array etter endring: "+Arrays.toString(a));

                j++;
*/

            }

            System.out.println("");
            System.out.println(Arrays.toString(a2)+ " - a2 -skygge referanse");
            System.out.println(Arrays.toString(b)+ " - b endret fra a2");
            System.out.println(Arrays.toString(a)+ " - a");

            /*
            //FUNKER MEN FOR TREIGT
            for (int i = 0; i < n ; i++) {

                if(k <0 ){
                    for (int j = 0; j < a.length-1; j++) { //Starter på slutten av array a.length-1 og går til index 0
                        char temp = a[j]; //Lagrer unna verdien i index du står i
                        a[j] = a[j + 1]; //Erstatter index du står i med verdien til neste index
                        a[j + 1] = temp; //Dytter mellomlagret verdi inn i neste index
                    }
                }
                else{
                    //System.out.println("Du flytter " + n + " mot høyre");
                    for (int j = a.length-1; j > 0; j--) { //Starter på slutten av array a.length-1 og går til index 0
                        char tempTest = a[j]; //Lagrer unna verdien i index du står i
                        a[j] = a[j - 1]; //Erstatter index du står i med verdien til neste index
                        a[j-1] = tempTest; //Dytter mellomlagret verdi inn i neste index
                    }
                }
            }*/








            //System.out.println(Arrays.toString(a));

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
        //System.out.println(count);
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
     * Metode som finner index til minste verdi i et array, med til og fra som parameter.
     * Dersom arrayet inneholder duplikatverdier er det index til venstreverdien som returneres
     * @param a arrayet vi skal søke etter minste verdi i
     * @return index til minste verdi
     */
    public static int minIndex(int[] a,int fra, int til) {

        int m = fra;              // indeks til største verdi i a[fra:til>
        int minverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] < minverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                minverdi = a[m];     // største verdi oppdateres
            }
        }
        return m;
    }
}
