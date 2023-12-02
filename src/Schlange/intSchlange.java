package Schlange;
public interface intSchlange
{
    // Wahrheitswert, prüft, ob die Schlange leer ist
    public boolean isEmpty();

    // Ein neues Element mit dem angegebenen Inhalt wird am Ende an die Schlange angehängt.
    public void enqueue(int x);

    // Der Inhalt des vordersten Elements der Schlange wird zurückgegeben, das Element aber nicht entnommen.
    public int head();

    // Das vorderste Element wird entnommen. Der Inhalt dieses Elements wird zurückgegeben.
    public int dequeue();

    // Gibt die Länge der Schlange an
    public int length();

}
