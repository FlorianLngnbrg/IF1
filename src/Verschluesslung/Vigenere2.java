package Verschluesslung;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vigenere2 {
    private static double[] relHEnglisch = {8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015, 6.094, 6.966, 0.153, 0.772, 4.025, 2.406, 6.749, 7.507, 1.929, 0.095, 5.987, 6.327, 9.056, 2.758, 0.978, 2.360, 0.150, 1.974, 0.074};
    private static double[] relHDeutsch = {6.51, 1.89, 3.06, 5.08, 17.4, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53, 9.78, 2.51, 0.79, 0.02, 7.00, 7.27, 6.15, 4.35, 0.67, 1.89, 0.03, 0.04, 1.13};
    private static double[] relHFranzoesisch = {7.63, 0.90, 3.26, 3.66, 14.72, 1.07, 0.87, 0.74, 7.53, 0.55, 0.05, 5.45, 2.97, 7.09, 5.38, 3.02, 1.36, 6.55, 7.95, 7.23, 6.31, 1.63, 0.11, 0.39, 0.31, 0.14};
    public static void main(String[] argv)
    {

        String g1 = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
        String g2 = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOFEKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGGQEUJYOTVGGBRUJYS";
        String g3 = "IMIEWWEEJJSRDSRHGZZOCMTXJUYNWMCYBVURJVSVSVSNVUZATMZAFUXNSBVATBRAECEQLIDQJMXBMLVAFPVECAKRTHVVUCEQEQVOJZEROTVHDPKRUMEJFQKHOLSEFQKQBAKBQNKRXMEATUZGUIXIPUKHSUVFDPFYMLVEWWEEJJSRDSJVDPSRJLVGBATUFVMBMTLAESRZJVGNOBZAFVVVORLAHMUNIMIFPZZRGMIWVVXRXQJGFVVOFMIHOLBNNMZANIVQFTJBSQVSFZCHFBKQJZEXVUDZBVIBFEVEJKBUFJSAFJZEO";

        //intelligenterVigenerecracker(g3, relHDeutsch);
        bruteforceVigenerecracker(g3, 15, relHDeutsch);
    }


    public static void intelligenterVigenerecracker(String kryptogramm, double[] sprache)
    {
        int[] kasiskiResults = KasikiTest(kryptogramm);

        for(int result : kasiskiResults)
        {
            String key = schlüsselwortCracker(kryptogramm, result, sprache);
            decrypt(kryptogramm, key);
        }
        System.out.println("Nicht das richtige Schlüsselwort? Dann bruteforceVigenerecracker verwenden.");
    }

    public static void bruteforceVigenerecracker(String kryptogramm, int crack, double[] sprache)
    {
        for(int l=0; l<crack; l++)
        {
            String key = schlüsselwortCracker(kryptogramm, l, sprache);
            System.out.println(key);
        }
    }

    public static String schlüsselwortCracker(String geheim, int Kasiski, double[] lang)
    {
        StringBuilder keyword = new StringBuilder();

        for(int j=0; j<Kasiski; j++)
        {
            double[][] t = stellenHaeufigkeiten(geheim, j, Kasiski);
            double summe = 0;
            String letter = "";
            double tempDoub = 0;

            for (int verschiebung = 0; verschiebung < 26; verschiebung++) {
                summe = 0;

                for (int i = 0; i < lang.length; i++) {
                    summe += Math.abs(t[(i + verschiebung) % 26][1] - lang[i]);
                }

                if (verschiebung == 0 || summe < tempDoub) {
                    tempDoub = summe;
                    char u = (char) (65 + verschiebung);
                    letter = String.valueOf(u);
                }
            }
            keyword.append(letter);
        }
        return keyword.toString();
    }

    public static String encode(String klar, String schlüsselwort) {
        String geheim = "";

        int j = 0;

        for (int i = 0; i < klar.length(); i++) {
            char c = klar.charAt(i);

            int schlüssel = schlüsselwort.charAt(j) - 65;
            geheim += (char)((c - 65 + schlüssel) % 26 + 65);

            j = (j + 1) % schlüsselwort.length();
        }
        return geheim;
    }

    public static int[] KasikiTest(String kryptogramm)
    {
        Map<String, List<Integer>> wiederholungen = new HashMap<>();

        for (int i = 0; i < kryptogramm.length() - 2; i++) {
            String trigramm = kryptogramm.substring(i, i + 3);

            if (wiederholungen.containsKey(trigramm)) {
                wiederholungen.get(trigramm).add(i);
            } else {
                List<Integer> positions = new ArrayList<>();
                positions.add(i);
                wiederholungen.put(trigramm, positions);
            }
        }

        List<Integer> abstaende = new ArrayList<>();

        for (String trigramm : wiederholungen.keySet()) {
            List<Integer> positions = wiederholungen.get(trigramm);

            if (positions.size() > 1) {
                for (int i = 0; i < positions.size() - 1; i++) {
                    for (int j = i + 1; j < positions.size(); j++) {
                        int abstand = positions.get(j) - positions.get(i);
                        abstaende.add(abstand);
                    }
                }
            }
        }

        List<Integer> faktoren = new ArrayList<>();

        for (int abstand : abstaende) {
            String faktorString = primfaktoren(abstand);
            if (!faktorString.isEmpty()) {
                String[] faktorArray = faktorString.trim().split(" ");
                for (String faktor : faktorArray) {
                    faktoren.add(Integer.parseInt(faktor));
                }
            }
        }

        return faktoren.stream().distinct().mapToInt(Integer::intValue).toArray();
    }

    public static void encrypt(String klar, String schluesselwort)
    {
        String geheim = "";
        klar = klar.toUpperCase();
        schluesselwort = schluesselwort.toUpperCase();

        int j = 0;

        for (int i = 0; i < klar.length(); i++) {
            char c = klar.charAt(i);

            int schluessel = schluesselwort.charAt(j) - 65;
            geheim += (char)((c - 65 + schluessel) % 26 + 65);

            j = (j + 1) % schluesselwort.length();
        }

        System.out.println("Klartext: " + klar);
        System.out.println("Geheimtext: " + geheim);
    }

    public static String decode(String geheim, String key) {
        return "";
    }

    public static void decrypt(String geheim, String schluesselwort)
    {
        String klar = "";
        geheim = geheim.toUpperCase();
        schluesselwort = schluesselwort.toUpperCase();

        int j = 0;

        for (int i = 0; i < geheim.length(); i++) {
            char c = geheim.charAt(i);

            int schlüssel = schluesselwort.charAt(j) - 65;
            klar += (char)((c - 65 + 26 - schlüssel) % 26 + 65);

            j = (j + 1) % schluesselwort.length();
        }

        System.out.println("Mögliches Schlüsselwort: " + schluesselwort);
        System.out.println("Geheimtext: " + geheim);
        System.out.println("Klartext: " + klar);
    }

    public static String[] bildeZeichengruppen (String geheim, int anz) {
        String[] gruppen = new String[anz];
        for(int i=0; i<anz; i++) {
            gruppen[i] = "";
        }

        for(int i=0; i<geheim.length(); i++) {
            gruppen[i % anz] += geheim.charAt(i);
        }
        return gruppen;
    }

    public static String[] schlüsselzeichengruppen (String g, int kasiskiResult)
    {
        int anz;
        int dividend = g.length();
        int h = 0;

        if(dividend % kasiskiResult != 0)
        {
            anz = dividend/kasiskiResult + 1;
        } else anz = dividend/kasiskiResult;

        String[] gruppen = new String[anz];

        for (int i = 0; i < g.length(); i += kasiskiResult)
        {
            int end = i + kasiskiResult;
            if (end > g.length())
            {
                end = g.length();
            }
            gruppen[h] = g.substring(i, end);
            h++;
        }

        System.out.println(Arrays.toString(gruppen));

        return gruppen;
    }
    public static void findDuplicates1() {
        String text = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";
        for(int i=0; i<text.length(); i++) {
            if( text.startsWith("HOO", i) ) {
                System.out.println("HOO" + " " + i);
            }
        }
    }
    public static void findDuplicates2() {
        String text = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";
        for(int j=0; j<text.length()-2; j++) {
            String muster = text.substring(j, j+3);
            for (int i=j+3; i < text.length(); i++) {
                if (text.startsWith(muster, i)) {
                    System.out.println(muster + ":" + j + ":" + i + ":" + (i-j) );
                }
            }
        }
    }
    public static void findDuplicates3(String text) {
       for(int l=15; l>=3; l--) {
           for (int j = 0; j < text.length()-l+1; j++) {
               String muster = text.substring(j, j+l);
               for (int i = j + l; i < text.length(); i++) {
                   if (text.startsWith(muster, i)) {
                       System.out.println(muster + ":" + j + ":" + i + ":" + (i - j));
                   }
               }
           }
       }
    }

    public static double[][] haeufigkeiten(String kryptogramm) {
        double[][] h = new double[26][2];

        int anzahlZ = kryptogramm.length();

        for (int i = 0; i < kryptogramm.length(); i++) {
            char buchstabe = kryptogramm.charAt(i);

            if ('A' <= buchstabe && buchstabe <= 'Z') {
                h[buchstabe - 'A'][0]++;
            }
        }

        for (int j = 0; j < h.length; j++) {
            h[j][1] = h[j][0] / anzahlZ * 100;
        }
        return h;
    }

    public static double[] haeufigkeiten2(String kryptogramm) {
        double[] h = new double[26];

        int anzahlZ = kryptogramm.length();

        for (int i = 0; i < kryptogramm.length(); i++) {
            char buchstabe = kryptogramm.charAt(i);

            if ('A' <= buchstabe && buchstabe <= 'Z') {
                h[buchstabe - 'A']++;
            }
        }

        for (int j = 0; j < h.length; j++) {
            h[j] = h[j] / anzahlZ * 100;
        }
        return h;
    }

    public static double[][] stellenHaeufigkeiten(String kryptogramm, int stelle, int sprung) {
        double[][] h = new double[26][2];
        int z = 0;

        int anzahlZ = kryptogramm.length();

        for (int i = stelle; i < kryptogramm.length(); i+=sprung) {
            char buchstabe = kryptogramm.charAt(i);
            int end = i + sprung;

            if(end>kryptogramm.length())
            {
                break;
            }

            z++;
            if ('A' <= buchstabe && buchstabe <= 'Z') {
                h[buchstabe - 'A'][0]++;
            }
        }

        for (int j = 0; j < h.length; j++) {
            h[j][1] = h[j][0] / z * 100;
        }

        return h;
    }

    public static String toString(double s[][])
    {
        String z = "";
        String a = "Absolute Häufigkeit: ";
        String b = "Relative Häufigkeit: ";


        for(int i=0; i<s.length; i++)
        {
            a += s[i][0] + " ";
            b += s[i][1] + "%" +  " ";
        }
        z = a + "\n" + b;

        return z;
    }

    public static String toString2(double s[])
    {
        String z = "";
        String b = "Relative Häufigkeit: ";


        for(int i=0; i<s.length; i++)
        {
            b += s[i] + "%" +  " ";
        }
        z += b;

        return z;
    }
    public static String primfaktoren(int zahl) {
        String faktoren = "";
        for(int i=2; i<=zahl/2; i++) {
            while(zahl%i == 0) {
                faktoren += i + " ";
                zahl /= i;
            }
        }
        return faktoren;
    }
}
