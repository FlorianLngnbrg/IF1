package Verschluesslung;

import java.util.Arrays;
import java.math.BigInteger;

public class RSA
{
    public static void main(String[] args)
    {
        // BigInteger p =  new BigInteger("237940396700775216816291802885713368052234118190036003415747923418640791299988172540360423957");
        // BigInteger q =  new BigInteger("276069853871622551497390234491079316684587161426206011699548030008033365526058621488961267769");
        //generiereSchlüsselpaar();

        RSA();
    }

   // public static BigInteger generiereSchlüsselpaar(BigInteger a, BigInteger b)
    //{
      //  BigInteger n = a.multiply(b);


    //}

    public static void RSA()
    {
        // BigInteger N = new BigInteger("114381625757888867669235779976146612010218296721242362562561842935706935245733897830597123563958705058989075147599290026879543541");
        BigInteger c = new BigInteger("96869613754622061477140922254355882905759991124574319874695120930816298225145708356931476622883989628013391990551829945157815154");
        BigInteger s = new BigInteger("16717861150380844246015271389168398245436901032358311217835038446929062655448792237114490509578608655662496577974840004057020373");
        BigInteger d = new BigInteger("37465627834572364586478676189037589734959768978773402895789");
        BigInteger m = new BigInteger("2205182004011414040514140509140009012001040903190820011419090519050113190411011101020504051305");

        BigInteger p = new BigInteger("3149452840165999639727229214164663990536511212676640513481697941049613726354244400696440886182215573");
        BigInteger q = new BigInteger("2130630690627070880715583294954809349283622923249112320683997772918229525841306410291244277245243737");
        BigInteger a = new BigInteger("1");

        BigInteger N = q.multiply(p);
        System.out.println(N);

        BigInteger pq = (p.subtract(a)).multiply(q.subtract(a));

        BigInteger e = d.modInverse(pq);

        BigInteger geheim = m.modPow(d, N);

        System.out.println(geheim);

        BigInteger klar = geheim.modPow(e, N);

        System.out.println(klar);

        BigInteger g_tom = new BigInteger("1555663719481730629142561037911641256128681746219312749541497204979418615978598023959734339026218186552604203946203446862694796863484068287001177469463024296114086385807314018296636499481075381396651");
        BigInteger n_tom = new BigInteger("4083860888640");
        BigInteger e_tom = new BigInteger("1816495230487");

        // BigInteger ef = e_tom.modInverse((p.subtract(a)).multiply(q.subtract(a)));

        BigInteger geheim_tom = g_tom.modPow(e, N);

        System.out.println(geheim_tom);


        // BigInteger m = g_tom.mod





        // BigInteger e = d.modInverse((p.subtract(a)).multiply(q.subtract(a)));

        //System.out.println(p.bitLength());
    }
}
