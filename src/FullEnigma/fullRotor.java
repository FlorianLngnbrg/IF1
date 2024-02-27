package FullEnigma;

import java.util.Arrays;

public class fullRotor {
    private int pos;
    private int[] rtl, ltr;

    public fullRotor(String cfg, int ringstellung) {
        rtl = new int[26];
        ltr = new int[26];
        pos = 0;

        cfg = cfg.toUpperCase();

        for(int i = 0; i < 26; i++) {
            char c = cfg.charAt(i % cfg.length());
            rtl[i] = (c - 'A' + i - ringstellung + 26) % 26;
            ltr[c - 'A'] = (26 - rtl[i]) % 26;
        }

        System.out.println(Arrays.toString(rtl));
        System.out.println(Arrays.toString(ltr));
    }

    public char transform(char c, int dir) {
        c = Character.toUpperCase(c);
        int index = c - 'A';

        if(dir == 1) {
            return (char) ('A' + (index + rtl[(index - pos + 26) % 26]) % 26);
        } else {
            return (char) ('A' + (index + ltr[(index - pos + 26) % 26]) % 26);
        }
    }

    public void step() {
        pos = (pos + 1) % 26;
    }

    public int getPos() {
        return pos;
    }

    public boolean turnover() {
        return pos == 0;
    }
}


