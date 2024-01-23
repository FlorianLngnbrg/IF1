package Verschluesslung;

import java.util.Arrays;

public class Vigenere2 {

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

    public static String decode(String geheim, String key) {
        return "";
    }

    public static void main(String[] argv) {
        //System.out.println( encode("DERKLARTEXTWIRDZUMGEHEIMTEXT","PLUTO") ); // SPLDZPCNXLIHCKROFGZSWPCFHTIN
        //System.out.println( encode("DERKLARTEXTWERDEGEHEIMTEXT","PLUTO") ); // SPLDZPCNXLIHYKRTRYASXXNXLI

        String g1 = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
        String g2 = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOFEKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGGQEUJYOTVGGBRUJYS";

        schlüsselzeichengruppen(g2, 5);
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
}