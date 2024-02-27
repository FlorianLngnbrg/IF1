package FullEnigma;

public class fullEnigma {
    private fullRotor rgt;
    private fullRotor mid;
    private fullRotor lft;
    private fullRotor rfl;
    private Steckerbrett steckerbrett;

    public fullEnigma(String rotorCfgRgt, String rotorCfgMid, String rotorCfgLft, String rotorCfgRfl, int ringstellungRgt, int ringstellungMid, int ringstellungLft, String steckerCfg) {
        rgt = new fullRotor(rotorCfgRgt, ringstellungRgt);
        mid = new fullRotor(rotorCfgMid, ringstellungMid);
        lft = new fullRotor(rotorCfgLft, ringstellungLft);
        rfl = new fullRotor(rotorCfgRfl, 0);
        steckerbrett = new Steckerbrett();

        setzeSteckerverbindungen(steckerCfg);
    }

    private void setzeSteckerverbindungen(String steckerCfg) {
        steckerCfg = steckerCfg.toUpperCase();
        for (int i = 0; i < steckerCfg.length(); i += 2) {
            char buchstabe1 = steckerCfg.charAt(i);
            char buchstabe2 = steckerCfg.charAt(i + 1);
            steckerbrett.steckeEin(buchstabe1, buchstabe2);
        }
    }

    public void step() {
        rgt.step();
        if (rgt.turnover()) {
            mid.step();
            if (mid.turnover()) {
                lft.step();
            }
        }
    }

    public String decrypt(String geheim) {

        String klar = "";

        for (int i = 0; i < geheim.length(); i++) {
            char h = geheim.charAt(i);

            step();

            h = steckerbrett.steckeUm(h);

            h = rfl.transform(h, 1);
            h = lft.transform(h, 1);
            h = mid.transform(h, 1);
            h = rgt.transform(h, 1);

            h = rgt.transform(h, 0);
            h = mid.transform(h, 0);
            h = lft.transform(h, 0);
            h = rfl.transform(h, 0);

            h = steckerbrett.steckeUm(h);

            klar += h;
        }

        return klar;
    }


    public String encrypt(String c)
    {
        String geheim = "";

        for(int i=0; i<c.length(); i++)
        {

            char l = c.charAt(i);

            step();

            l = steckerbrett.steckeUm(l);

            l = rgt.transform(l, 1);
            l = mid.transform(l, 1);
            l = lft.transform(l, 1);

            l = rfl.transform(l, 1);

            l = lft.transform(l, 0);
            l = mid.transform(l, 0);
            l = rgt.transform(l, 0);

            l = steckerbrett.steckeUm(l);

            geheim += l;

        }
        return geheim;
    }
}
