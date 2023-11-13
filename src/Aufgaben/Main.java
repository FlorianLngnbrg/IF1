package Aufgaben;

import Schlange.*;
import Stack.*;

public class Main {

    public static void main(String[] args)
    {
        intArraySchlange biber = new intArraySchlange();
        intArrayKeller teller = new intArrayKeller();


        // Fügt Biber in die Schlange ein. Der erste hinzugefügte Biber ist auch das erste Element in der Queue. 1 = großer Teller. 0 = kleiner Teller
        biber.enqueue(0);
        biber.enqueue(1);
        biber.enqueue(1);
        biber.enqueue(0);
        biber.enqueue(1);

        // Fügt Teller hinzu. 1 = großer Teller. 0 = kleiner Teller. Erster hinzugefügter Teller ist das unterste Element.
        teller.push(1);
        teller.push(0);
        teller.push(1);
        teller.push(1);
        teller.push(0);

        //for(int i=0; i<biber.length(); i++)
        //Solange Biber noch in der Schlange stehen...
        while(!biber.isEmpty() && !teller.isEmpty() )
        {
            //Vergleicht die Größe des obersten Tellers mit dem ersten in der Schlange stehenden Bibers.
            if(teller.peek()==biber.head())
            {
                //Gibt aus. Löscht den obersten Teller und den am Anfang stehenden Biber.
                System.out.println(teller.peek() + " " + biber.head());
                teller.pop();
                biber.dequeue();

                //Größe der Biber und Teller stimmt nicht überein.
            } else System.out.println("passt nicht!");
        }

        // Gibt Fehlerausgabe, wenn die Anzahl der Biber mit der Anzahl der Teller nicht übereinstimmt.
        if(!biber.isEmpty() || !biber.isEmpty())
        {
            System.out.println("passt nicht!");
        }
    }
}
