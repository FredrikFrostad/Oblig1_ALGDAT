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


    //******************************* OPPGAVE 7 ***************************************

    //TODO: LEGG TIL KOMMENTARER!!


    /**
     * Metode som fletter sammen to strenger. Dersom strengene har ulik lengde leggers de overskytende
     * tegnene fra den lengste parameterstrengen til bakerst i returstrengen
     * @param s en streng som skal flettes
     * @param t en streng som skal flettes
     * @return resultatet av flettingen mellom s og t
     */
    public static String flett(String s, String t) {

        String interleaved = null;

        if (s.length() == t.length())
        {
            interleaved = stringWeaver(s,t,true,false);
        }
        if (s.length() < t.length())
        {
            interleaved = stringWeaver(s,t,false, false);
        }
        if (s.length() > t.length())
        {
            interleaved = stringWeaver(t,s,false, true);
        }

        return interleaved;
    }


    public static String stringWeaver(String shortest, String longest, boolean equal, boolean swapped) {

        StringBuilder interleaved = new StringBuilder();

        if (equal)
        {
            for (int i = 0; i < longest.length(); i++) {
                interleaved.append(shortest.charAt(i));
                interleaved.append(longest.charAt(i));
            }
        }else
        {
            int i = 0;
            while (i < shortest.length()) {
                if (swapped)
                {
                    interleaved.append(longest.charAt(i));
                    interleaved.append(shortest.charAt(i));
                }else {
                    interleaved.append(shortest.charAt(i));
                    interleaved.append(longest.charAt(i));
                }
                i++;
            }
            while (i < longest.length()) {
                interleaved.append(longest.charAt(i));
                i++;
            }
        }
        return interleaved.toString();
    }

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
        //Sortert hjelpetabell
        int[] sorted_a = Arrays.copyOf(a,a.length);
        Arrays.sort(sorted_a);
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
    public static boolean inneholdt(String a, String b) {

        if(a.equals("")){
            return true;
        }
        //Lager nytt char array av characters i streng
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        //System.out.println("Array a usortert: " + Arrays.toString(aChar));
        //System.out.println("Array b usortert: " + Arrays.toString(bChar));

        //1) Sorter aChar, og bChar
        Arrays.sort(aChar, 0, aChar.length); //Bruke egen motode for dette?
        Arrays.sort(bChar, 0, bChar.length); //Bruke egen motode for dette?

        //System.out.println("Array a sortert: " + Arrays.toString(aChar));
        //System.out.println("Array b sortert: " + Arrays.toString(bChar));


        int i = 0, j = 0, k = 0;
        boolean aInB = false;
        boolean singleChar = false;
        int nDuplicateA = 0;
        char duplicateA = 0;
        char singleA = 0;
        int count = 0;

        while (i < aChar.length && j < bChar.length) {

            //l = i;

            if((k+1)==a.length()){
                singleA = aChar[k]; //Lagrer unna enkelt char
                singleChar = true;
                nDuplicateA = 0; //Mulig overflødig pga at neste while "nuller" ut denne... Legges inn for lesbarhet inntil videre
                k++;
                i++; //Sykroniserer i med antall bevegelser i k retning
            }

            else if(aChar[k] == aChar[k+1]) { //Håndtering/telling av duplikater for a. Må hodtere corner case der hvor jeg er på slutten av løkka
                //Finner antall duplikater av en type character i a
                while ((aChar[k] == aChar[k+1]) && (k < aChar.length)) {
                    duplicateA = aChar[k];
                    nDuplicateA++;
                    k++;
                    i = i + k; //Oppdaterer i slik at i flyttes til nytt offset tilsvarende antall duplikater nDuplicate. kanksje bare bruke i isteden for k?
                    if(k+1>=aChar.length)
                        break;
                }
            }else{ //Håndtering av enkelt char
                singleA = aChar[k]; //Lagrer unna enkelt char
                singleChar = true;
                nDuplicateA = 0; //Mulig overflødig pga at neste while "nuller" ut denne... Legges inn for lesbarhet inntil videre
                k++;
                i++; //Sykroniserer i med antall bevegelser i k retning
            }



            if((bChar[j] == duplicateA) && (!singleChar)){ //Tilfellet hvor den er lik for neste
                k= k + 1; //Må flytte offset for k lik antall duplikater slik at den sjekker riktig for neste.

                int n = nDuplicateA;
                for (int l = 0; l < n  ; l++) {

                    if((bChar[j] == duplicateA)){
                        if (nDuplicateA == 0) {
                            aInB = true;
                        } else if (nDuplicateA > 0) {
                            aInB = false; //False så lenge den ikke har funnet likt antall char i b som i a.
                            nDuplicateA--;
                        }
                    }else{ //Hvis du har kommet hit og bChar[j] != duplicateA, så er ikke a ikke inneholdt i b
                        return false;
                    }

                    j++;
                    if(j>=bChar.length)
                        break;
                }
            }else if ((bChar[j] != duplicateA) && (!singleChar)) { //Må løpe igjennom hele for å se om det finnes noen like.
                aInB = false; //Ikke umiddelbart inneholdt, må sjekke hele b.
                for (int l = j; l < bChar.length ; l++) {

                    if((bChar[j] == duplicateA) && (j<bChar.length)){
                        if (nDuplicateA == 0) {
                            aInB = true;
                            //j++;//TODO: Litt usikker på denne...
                            break;
                        } else if (nDuplicateA > 0) {
                            aInB = false; //False så lenge den ikke har funnet likt antall char i b som i a.
                            nDuplicateA--;
                        }
                    }

                    j++;
                }
                if(nDuplicateA >0) //Hvis sant etter å ha sjekket resten av b. a er ikke inneholdt i b
                    return aInB;
            } else if ((bChar[j] == singleA) && singleChar){ //tilfelle for single char
                //Den single char i a finnes i b
                aInB = true;
                j++;
                singleChar = false;
            }else{
                return false;
            }

/*
            for (int l = 0; l < nDuplicateA ; l++) {


                if(bChar[j]==duplicateA){

                }
                j++;
            }
*/
            /*
            if (bChar[j] == aChar[i]) {
                System.out.println("A-tabell char " + aChar[i] + " A-index " + i + " finnes også i B-tabell som "
                        + bChar[j] + " på index " + j);

                aInB = true;
                System.out.println("Er a innehold i b? " + aInB);

            }

            */

        //i++;//Tror kanskje jeg ikke trenger denne pga at i oppdateres innenfra while løkke.
        //k++;


        }

            //Hvis denne inntreffer er i b mindre enn a, og resultatet er false

            if(i < aChar.length){ //Hvis dette -> hovedløkka har terminert pga at j>=cChar.length -> DET ER FLERE CHAR I a enn i b.. a kan ikke være inneholdt i b
                //System.out.println("Char " + aChar[i] + " i a på indeks " + i + " finnes ikke i B-tabellen");
                aInB = false;
                //System.out.println("a er ikke inneholdt i b, da b er kortere enn a");
            }
            /*
            while (i < aChar.length) {
                System.out.println("Char " + aChar[i] + " i a på indeks " + i + " finnes ikke i B-tabellen");
                aInB = false;
                System.out.println("Er a innehold i b? " + aInB);
                i++;
            }*/


/*
            //Hvis denne inntreffer betyr det at b har enda flere chars en a, og resultatet er allerede kjent.
            while (j < bChar.length) {

                System.out.println("b inneholder flerer char enn a... dvs a er inneholdt i b hvis de tidligere " +
                        "char verdiene er inneholdt");
                j++;
            }
*/

            //String nyA = "";
            //StringBuilder buildA = new StringBuilder();

            //int temp = aChar[0];
            //int countA = 0;
            //int countB = 0;
            //      int nDupA = 0;
            //      char charDupA = 0;
            //      boolean dupA = true;

            //       int nDupB = 0;
            //       char charDupB = 0;
//        boolean dupB = true;


//        boolean aInB = false;
//        int loopCounter = 0;



/*
        //Funker ikke i det hele tatt... men har noen interessante tanker...
        for (int i = 0; i < aChar.length; i++) {
            if (aChar[i+1] == aChar[i]) {
                charDupA = aChar[i];
                nDupA++;
                dupA = true;
            }else{
                dupA = false;
                charDupA = aChar[i];
                nDupA = 0;
            }

            for (int k = 0; k < nDupA ; k++) {
                if (bChar[i+1-nDupA+k] == bChar[i+2-nDupA+k]) {
                    charDupB = bChar[i];
                    nDupB++;
                    dupB = true;
                }else{
                    dupB = false;
                    charDupB = aChar[i];
                    nDupB = 0;
                }
            }

            if((nDupA==nDupB) && (loopCounter>0)){ //Hvis true så finnes mengden av characterduplikater fra a i b...
                aInB = true;
                System.out.println("Likt antall duplikater av char:" + charDupA +", og " + charDupB);
            }else{
                System.out.println(nDupA+ " av Char " + charDupA + " finnes ikke i array b. ");
                aInB = false;

            }


            //while(dupA == false){ //Hvis det ikke er flere duplikater i a, så sjekkes b for det som ble funnet i a
            //}




            loopCounter++;
        }
*/
            //return aInB;


            //Mulig merge sort er best.. tips fra lærer er å bruke Merge Sort... men å telle antall treff...

            //2) Loop igjennom char array1, og char array2. sjekk om antallet fra array1 (feks antall AA) ligger i char array2.
            //Feks: AA i aChar må være en delmengde i bChar
/*
        for (int i = 0; i < aChar.length ; i++) {

            if(aChar[i]==temp){
                countA++;
            }
            else{
                temp = aChar[i];
            }

            if(bChar[i]==temp){
                countB++;
            }
            else{
                temp = aChar[i];
            }


            //buildA.append(aChar[i]);


        }


        return false;
*/
            //TODO
        //System.out.println("Er a inneholdt i b? " + aInB);
        return aInB;
        }




/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////







    // **************************** DIVERSE HJELPEMETODER *****************************


    public static void quicksort(int[] a) {


    }

    public static void partition(int[] a) {
        System.out.println(Arrays.toString(a));
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

        for (int i = 1; i < a.length; i++) {
            if (a[i] < minverdi) {
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }
}
