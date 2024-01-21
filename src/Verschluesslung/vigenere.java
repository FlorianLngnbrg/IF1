package Verschluesslung;

public class vigenere
{
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

    public static void main(String[] args)
    {
        encrypt("Hallo", "Flo");
        decrypt("MLZQZ", "Flo");
    }
}
