package FullEnigma;

import java.util.HashMap;

public class Steckerbrett
{
    private HashMap<Character, Character> steckerbrettMap;

    public Steckerbrett()
    {
        steckerbrettMap = new HashMap<>();
    }

    public void steckeEin(char buchstabe1, char buchstabe2)
    {
        steckerbrettMap.put(buchstabe1, buchstabe2);
        steckerbrettMap.put(buchstabe2, buchstabe1);
    }

    public char steckeUm(char buchstabe)
    {
        return steckerbrettMap.getOrDefault(buchstabe, buchstabe);
    }
}