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

    public static String ausgabeRing(Queue<Dominostein> s) { return s.toString(); }

    // public boolean pruefeRing()  { }

    public static void ringBilden()
    {
        Queue<Dominostein> ring = new Queue<>();
        Dominostein aktuell = vorrat.getItem(0);
        vorrat.delete(0);
        ring.enqueue(aktuell);
        Dominostein naechster = null;

        while(!vorrat.isEmpty())
        {
            if(vorrat.getItem(0).getLinks() == aktuell.getRechts())
            {
                ausgabeRing(ring);
                aktuell = vorrat.getItem(0);
                vorrat.delete(0);
                ring.enqueue(aktuell);
            }
            if(vorrat.isEmpty())
            {
                break;
            } else
            {
                naechster = vorrat.getItem(0);
                vorrat.delete(0);
            }
            if(aktuell.getRechts() == naechster.getLinks())
            {
                ring.enqueue(naechster);
                aktuell = naechster;
            } else  vorrat.append(naechster);
        }
        if(ring.head().getLinks() == aktuell.getRechts())
        {
            ausgabeRing(ring);
        } else System.out.println("Fehler: Vorraussetzung nicht erfüllt");
    }


    public static void main(String[] args)
    {
        Dominostein d2 = new Dominostein(2, 4);
        Dominostein d3 = new Dominostein(5, 6);
        Dominostein d4 = new Dominostein(2, 3);
        Dominostein d5 = new Dominostein(2, 3);
        Dominostein d6 = new Dominostein(1, 3);
        Dominostein d7 = new Dominostein(5, 6);

        vorrat.append(new Dominostein(1, 3));
        vorrat.append(d2);
        vorrat.append(d3);
        vorrat.append(d4);
        vorrat.append(d5);
        vorrat.append(d6);

        ringBilden();
    }
}
