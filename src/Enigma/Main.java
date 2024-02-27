package Enigma;

public class Main
{

    public static void main(String[] argv)
    {
        MiniEnigma m = new MiniEnigma();

        String w = "DACHCAFE";
        String g = "";

        for(int i=0; i<w.length(); i++)
        {
        g += m.encrypt( w.charAt(i) );
        }

        System.out.println(g);
    }
}