package Enigma;

    public class MiniEnigma {
        MiniRotor rgt = new MiniRotor("BDGCAEFH");
        MiniRotor mid = new MiniRotor("FBEAGCHD");
        MiniRotor lft = new MiniRotor("FDEABGCH");
        MiniRotor rfl = new MiniRotor("HFGEDBCA");

        public void step() {
            rgt.step();
            if (rgt.turnover()) {
                mid.step();
                if (mid.turnover()) {
                    lft.step();
                }
            }
        }

        public char encrypt(char c) {
            step();

            c = rgt.transform(c, 1);
            c = mid.transform(c, 1);
            c = lft.transform(c, 1);

            c = rfl.transform(c, 1);

            c = lft.transform(c, 0);
            c = mid.transform(c, 0);
            c = rgt.transform(c, 0);

            return c;
        }
    }