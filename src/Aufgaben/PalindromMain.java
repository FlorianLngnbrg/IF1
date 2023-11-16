package Aufgaben;

import Schlange.*;
import Stack.*;

public class PalindromMain {
    public static boolean istPalindrom(String s)
    {
        // Konvertiert den String s zum Ascii und fügt es in einen Array, um auf jedes Element (Buchstaben) zuzugreifen
        byte[] asciiS = s.getBytes();

        if(asciiS.length % 2 != 0)
        {
            System.out.println(asciiS.length);
            return false;
        }


        // forward für die korrekte Richtung des Wortes. Backward für die andere Richtung
        intArraySchlange forward = new intArraySchlange();
        intArrayKeller backward = new intArrayKeller();

        // Fügt die einzelnen Buchstaben als Zahlen in die Queue, bzw. auf den Stack.
        for(int i=asciiS.length-1; i>=0; i--)
        {
            forward.enqueue(asciiS[i]);
            backward.push(asciiS[i]);
        }
        // Vergleicht die Elemente, solange welche vorhanden sind.
        while(!forward.isEmpty() && !backward.isEmpty())
        {
            // Sind alle Elemente äquivalent, so ist es ein Palindrom.
            if(forward.head()== backward.peek())
            {
                forward.dequeue();
                backward.pop();
            } else return false;
        }
        return true;
    }

    // Gibt das Prüfergebnis aus
    public static void main(String[] args) {
        String s = "reittier";
        System.out.println( istPalindrom(s) );
    }
}