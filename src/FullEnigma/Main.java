package FullEnigma;

public class Main {

    public static void main(String[] argv) {
        fullEnigma enigma = new fullEnigma("EKMFLGDQVZNTOWYHXUSPAIBRCJ", "AJDKSIRUXBLHWTMCQGZNPYFVOE", "BDFHJLCPRTXVZNYEIWGAKMUSQO", "YRUHQSLDPXNGOKMIEBFZCWVJAT", 1, 1, 1, "");

        String verschluesselt = enigma.decrypt("WSPFPTC");

        System.out.println("Verschlüsselter Text: " + verschluesselt);
    }
}
