package Verschluesslung;

import java.util.Arrays;
public class Vigenere2 {
    public static void main(String[] argv) {

        String g1 = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
        String g2 = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOFEKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGGQEUJYOTVGGBRUJYS";

        schlüsselzeichengruppen(g2, 5);
        //haeufigkeiten(g2);
        //stellenHaeufigkeiten(g2, 0, 5);
        haeufigkeiten2(g2);
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
        System.out.println(toString(h));
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
        System.out.println(toString2(h));
        return h;
    }

    public static double[][] stellenHaeufigkeiten(String kryptogramm, int stelle, int sprung) {
        double[][] h = new double[26][2];

        int anzahlZ = kryptogramm.length();

        for (int i = stelle; i < kryptogramm.length(); i+=sprung) {
            char buchstabe = kryptogramm.charAt(i);

            int end = i + sprung;

            if(end>kryptogramm.length())
            {
                break;
            }

            if ('A' <= buchstabe && buchstabe <= 'Z') {
                h[buchstabe - 'A'][0]++;
            }
        }

        for (int j = 0; j < h.length; j++) {
            h[j][1] = h[j][0] / anzahlZ * 100;
        }
        System.out.println(toString(h));

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
}