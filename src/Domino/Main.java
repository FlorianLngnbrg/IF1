package Domino;
import Liste.*;
import Schlange.*;

public class Main {
    public static DynArray<Dominostein> vorrat = new DynArray<Dominostein>();
    public static Queue<Dominostein> s = new Queue<Dominostein>();
    public static int felderZaehlen(DynArray<Dominostein> vorrat, int augenzahl) {

        int anzahl = 0;

        for(int i=0; i< vorrat.getLength(); i++)
        {
            if(vorrat.getItem(i).getRechts() == augenzahl)
            {
                anzahl++;
            } else if(vorrat.getItem(i).getLinks() == augenzahl)
            {
                anzahl++;
            }
        }
        return anzahl;
    }

    public boolean ringMoeglich(DynArray<Dominostein> vorrat)
    {
        for(int i=1; i<=6; i++)
        {
            int felderAnzahl = felderZaehlen(vorrat ,i);
            {
                if(felderAnzahl % 2 != 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean pruefeRing()
    {

    }


    public static void main(String[] args)
    {
        Dominostein d1 = new Dominostein(1, 3);
        Dominostein d2 = new Dominostein(2, 4);
        Dominostein d3 = new Dominostein(5, 6);
        Dominostein d4 = new Dominostein(2, 3);
        Dominostein d5 = new Dominostein(2, 3);
        Dominostein d6 = new Dominostein(1, 3);
        Dominostein d7 = new Dominostein(5, 6);

        for(int j=0)

    }
}
