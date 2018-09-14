import com.sun.org.apache.xpath.internal.SourceTree;

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
                if (a[i] == a[j])
                {
                    duplicate++;
                    break;
                }
            }
        }
        return distinct - duplicate;
    }

    //***************************** OPPGAVE 4 *****************************************

    public static void delsortering(int[] a) {

        int partall = 0;
        int oddetall = 0;

        if (a.length == 0) {
            return;
        }

        partition(a, 0, a.length - 1);

        for (int i = 0; i < a.length; i++) {


            if (Math.floorMod(a[i], 2) == 0) {
                partall = partall + 1;
            } else {
                oddetall = oddetall + 1;
            }

        }

        quicksort(a, 0, oddetall - 1);
        quicksort(a, oddetall, a.length - 1);
    }

    public static void partition(int a[], int v, int h) {
        while (true) {
            while (v <= h && a[h] % 2 == 0) {
                h--;

            }
            while (h >= v && a[v] % 2 != 0) {
                v++;
            }
            if (v < h) {
                bytt(a, v++, h--);
            }
            if (v >= h) {
                break;
            }
        }

    }

    //***************************** OPPGAVE 5 *****************************************

    /**
     * Metode som "rotere" innholdet i tabellen a én enhet. En rotasjon i en tom tabell eller i en tabell med nøyaktig
     * ett element er ingen feilsituasjon, men rotasjonen vil da ikke endre noe.
     * @param a arrayet som skal roteres
     */
    public static void rotasjon(char[] a) {
        if ((a == null)||(a.length ==1)){

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
     *
     * @param a arrayet som skal roteres
     * @param k antall rotasjoner, og retning
     */

    public static void rotasjon(char[] a, int k) {

        if ((a == null) || (a.length == 1)) {

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


    //******************************* OPPGAVE 7 ***************************************

    //TODO: LEGG TIL KOMMENTARER!!


    /**
     * Metode som tar imot en strengtabell iog fletter sammen alle strengene som ligger i tabellen
     * @param s tabell som inneholder strengene som skal flettes
     * @return en streng som inneholder resultatet av flettingen
     */
    public static String flett(String... s){

        StringBuilder interleaved = new StringBuilder();

        int i = 0;
        int longest = findLongest(s);
        while (i <= longest)  {

            for (int j = 0; j < s.length; j++) {
                if (s[j].length() > i)
                {
                    interleaved.append(s[j].charAt(i));
                }
            }
            i++;
        }
        return interleaved.toString();
    }

    /**
     * Metode som finner lengste streng i en tabell
     * @param s tabellen hvor vi skal finne lengste streng
     * @return en integer med lengden til den lengste strengen
     */
    public static int findLongest(String[] s) {
        int maxlength = 0;

        for (String str : s) {
            if (str.length() > maxlength) {
                maxlength = str.length();
            }
        }
        return maxlength;
    }


    //******************************* OPPGAVE 8 ***************************************


    /**
     * Metode som indekssorterer en tabell. Metoden endrer ikke parametertabellen.
     * @param a Tabellen som vi ønsker indekssortert
     * @return en tabell med indekser ordnet etter elementstørrelse i parametertabellen
     */
    public static int[] indekssortering(int[] a) {


        //Tabell som skal inneholde de sorterte indeksene
        int[] index = new int[a.length];

        //Returner tom tabell dersom parametertabellen er tom
        if (a.length < 1) {return index;}

        //Sortert hjelpetabell
        int[] sorted_a = Arrays.copyOf(a,a.length);
        quicksort(sorted_a,0, sorted_a.length-1);

        //Finner duplikatverdier til venstre for gjeldende element og teller dem
        for (int i = 0; i < a.length; i++) {
            int sort_val = sorted_a[i];
            int duplicates_count = 0;
            int k = i - 1;
            while (k >= 0 && sorted_a[k] == sort_val){
                duplicates_count++;
                k--;
            }

            //Befolker indekstabellen basert på den sorterte kopitabellen
            //Dersom vi finner en match mellom sortert tabell og parametertabellen settes tilhørende
            //index fra parametertabellen inn i indekstabellen, så fremt duplikatteller er null.
            for (int j = 0; j < a.length; j++) {
                if (a[j] == sort_val){
                    if (duplicates_count > 0)
                        duplicates_count--;
                    else{
                        index[i] = j;
                    }
                }
            }
        }
        return index;
    }

    // **************************** OPPGAVE 9 *****************************************


    /**
     * Metode som finner indeksene til de tre minste verdiene i en tabell.
     * @param a tabellen hvor vi skal søke etter de tre minste verdiene
     * @return et sortert array inneholdende
     */
    public static int[] tredjeMin(int[] a) {

        if (a.length < 3) {
            throw new NoSuchElementException
                    ("Parametertabellen inneholder for få elementer!!");
        }

        //Setter startverdier for minst(m), nestminst(nm) og nestnestminst(nnm)
        int m = 0, nm = 1, nnm = 2;

        //Sørger for at minst < nestminst før vi begynner å iterere
        if (a[m] > a[nm]) {
            int temp = m;
            m = nm;
            nm = temp;
        }

        for (int i = 0; i < a.length; i++) {

            //Dersom ny minst, oppdater alle tre verdier
            if (a[i] < a[m])
            {
                nnm = nm;
                nm = m;
                m = i;
            }
            //Dersom ny nestminst oppdater nestminst og nestnestminst
            else if (a[i] < a[nm] && a[i] > a[m])
            {
                nnm = nm;
                nm = i;
            }
            //Dersom ny nestnestminst, oppdater bare denne
            else if (a[i] < a[nnm] && a[i] > a[nm])
            {
                nnm = i;
            }
        }

        //Returnerer indeksene til de tre minste verdiene sortert stigende
        return new int[] {m,nm,nnm};
    }


    // **************************** OPPGAVE 10 *****************************************

    /**
     * Sjekker om characters i string a er inneholdt i string b. Hver bokstav i det første ordet skal forekommer minst
     like mange ganger i det andre ordet som i det første, men ikke nødvendigvis i samme rekkefølge. Et ord er tenkt
     som oppramsing av bokstaver.
     * @param a
     * @param b
     * @return
     */
    public static boolean inneholdt(String a, String b) {

        if(a.equals("")) return true;

        //Lager nytt char array av characters i streng
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        //Sortering av aChar, og bChar tabell. Videre referert til som a og b i kommentarer under.
        Arrays.sort(aChar, 0, aChar.length); //
        Arrays.sort(bChar, 0, bChar.length); //

        int i = 0; //Ytre indeks for tabell a
        int j = 0; //Ytre og indre indeks for tabell b
        int k = 0; //Indre indeks for tabell a
        boolean aInB = false;
        boolean singleChar = false;
        int nDuplicateA = 0;
        char duplicateA = 0;
        char singleA = 0;

        //Yttre løkke som looper tilsvarende antall characters fra streng a, og streng b
        while (i < aChar.length && j < bChar.length) {

            //Hvis man får en ny kjørerunde i loopen, og er på på siste index (cornercase),
            //så behandles det som skjer i løkka som enkelt char case.
            if((k+1)==a.length()){
                singleA = aChar[k]; //Lagrer unna enkelt char
                singleChar = true;
                k++;
                i++;
            }
            //Håndtering/telling av duplikater for a. Ser om nåværende og neste char er like.
            else if(aChar[k] == aChar[k+1]) {
                //Finner antall duplikater av en type character i a
                while ((aChar[k] == aChar[k+1]) && (k < aChar.length)) { //Går så lenge det er duplikater.
                    duplicateA = aChar[k]; //Lagrer unna duplikat character
                    nDuplicateA++; //Teller opp antall duplikater
                    k++; //Oppdaterer indeks teller for tabell a loop.
                    i = i + k; //Oppdaterer ytre løkke slik at i flyttes med offsett tilsvarende antall opptelte indekser i a
                    if(k+1>=aChar.length) //Bryter opptelling hvis den neste tellingen går over lengden til a
                        break;
                }
            }else{ //Håndtering/telling av enkelt char
                singleA = aChar[k]; //Lagrer unna enkelt char
                singleChar = true; //Flagg for å fortelle løkke for tabell b at det ikke er duplikat, men en enkelt char.
                k++;
                i++;
            }

            //Løkke for tabell b. Denne tar inn resultatet fra løkken som har telt opp duplikater og enkelt chars
            //i fra tabell a. Løkken ser om a er inneholdt i b.
            if((bChar[j] == duplicateA) && (!singleChar)){ //Tilfellet hvor den er lik for neste, og ikke singel char
                k= k + 1; //Om b finner at utvalget fra a er inneholdt i b, så legges det til offset på løkka for a for neste runde
                int n = nDuplicateA; //temp variable som brukes for hvor mange characters som skal sjekkes for duplikat
                //Løkken sjekker om n telte duplikat fra a er inneholdt i b.
                for (int l = 0; l < n  ; l++) {
                    if((bChar[j] == duplicateA)){ //a er inneholdt i b
                        if (nDuplicateA == 0) { //alle sjekkede characters fra a er inneholdt i b
                            aInB = true; //a er inneholdt i b
                        } else if (nDuplicateA > 0) {
                            aInB = false; //False så lenge den ikke har funnet likt antall char i b som i a.
                            nDuplicateA--; //Teller ned sjekkede duplikater
                        }
                    }else{ //Hvis du har kommet hit og bChar[j] != duplicateA, så er ikke a ikke inneholdt i b
                        return false;
                    }

                    j++;
                    if(j>=bChar.length) //Bryter for loop om j går utover størrelsen på b
                        break;
                }
             //Tilfelle hvor man enda ikke vet om a er inneholdt i b. Dvs a kan være inneholdt i b lengre ut i b tabellen.
            }else if ((bChar[j] != duplicateA) && (!singleChar)) { //Må løpe igjennom hele for å se om det finnes noen like.
                aInB = false; //Ikke umiddelbart inneholdt, må sjekke hele b.

                //Looper hele b for å se om a er inneholdt, da den ikke var inneholdt på starten av tabell b
                for (int l = j; l < bChar.length ; l++) {

                    if((bChar[j] == duplicateA) && (j<bChar.length)){ //a er inneholdt i b
                        if (nDuplicateA == 0) { //Alle sjekkede a er inneholdt i b.
                            aInB = true;
                            k++; //oppdaterer indeks for a tabell for neste kjøring.
                            break; //Trenger ikke sjekke resten av tabell b ved treff på at alle i a er inneholdt i b.
                        } else if (nDuplicateA > 0) {
                            aInB = false; //False så lenge ikke alle sjekkede fra a er inneholdt i b.
                            nDuplicateA--;
                        }
                    }
                    j++;
                }
                if(nDuplicateA >0) //Hvis sant etter å ha sjekket resten av b. a er ikke inneholdt i b
                    return aInB;
            //Håndtering av sjekk på om a er inneholdt i b når det kun er en character.
            } else if ((bChar[j] == singleA) && singleChar){ //tilfelle for single char
                //En enkelt char i a finnes i b
                aInB = true;
                j++;
                singleChar = false; //tilbakestiller singel character flagg for neste kjøring.
            }else{
                return false; //Returnere false hvis ingen av sjekkede chars i a er inneholdt i b.
            }
        }
            //Hvis denne inntreffer er i b tabellen mindre enn a, og resultatet er false. a kan ikke være inneholdt i b
            if(i < aChar.length){ //Hvis dette -> hovedløkka har terminert pga at j>=cChar.length -> a>b -> return false
                aInB = false;
            }
        return aInB;
        }




/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////







    // **************************** DIVERSE HJELPEMETODER *****************************

    public static void quicksort(int[] a, int left,  int right) {
        int pivotIndex = partisjoner(a, left,right);

        if (left < pivotIndex - 1) {
            quicksort(a, left, pivotIndex -1);
        }
        if (right > pivotIndex - 1) {
            quicksort(a,pivotIndex, right);
        }
    }

    static int partisjoner(int[] a, int left, int right) {

        int i = left;
        int j = right;
        int pivot = a[(left + right) / 2];

        while (i <= j)  {

            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                bytt(a, i, j);

                i++;
                j--;
            }
        }
        return i;
    }

    public static void quicksort(char[] a, int left,  int right) {
        int pivotIndex = partisjoner(a, left,right);

        if (left < pivotIndex - 1) {
            quicksort(a, left, pivotIndex -1);
        }
        if (right > pivotIndex - 1) {
            quicksort(a,pivotIndex, right);
        }
    }

    static int partisjoner(char[] a, int left, int right) {

        int i = left;
        int j = right;
        char pivot = a[(left + right) / 2];

        while (i <= j)  {

            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                bytt(a, i, j);

                i++;
                j--;
            }
        }
        return i;
    }





    /**
     * Bubblesort som sorterer en hel tabell
     * @param unsorted arrayet som skal sorteres
     * @return det sorterte arrayet
     */
    public int[] bubbleSort(int[] unsorted) {
        int[] sorted = unsorted;

        for (int i = 0; i < unsorted.length ; i++) {
            for (int j = 1; j < unsorted.length; j++) {

                if (unsorted [j-1] > unsorted [j]) {
                    int tmp = unsorted[j-1];
                    unsorted[j-1] = unsorted[j];
                    unsorted[j] = tmp;
                }
            }
        }
        return sorted;
    }

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
     * Metode som bytter om to integere i et array
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
     * Metode som bytter om to characters i et array
     * @param a arrayet som inneholder verdiene som skal bytte plass
     * @param i index til den ene verdien
     * @param j index til den andre verdien
     */
    public  static void bytt(char[] a, int i, int j) {

        if (i < 0 || i > a.length - 1 || j < 0 || j > a.length - 1) {
            throw new IllegalArgumentException
                    ("Illegal input argument. Input must be within array bounds");
        }

        char temp = a[i];
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

        for (int i = 1; i < a.length; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }
}
