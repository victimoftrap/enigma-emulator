package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorI implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char TURNOVER_POSITION = 'R';
    private AlphabeticSignal ringSetting = new AlphabeticSignal('A');

    public RotorI() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('E', 'U');
        frontAlphabet.put('K', 'W');
        frontAlphabet.put('M', 'Y');
        frontAlphabet.put('F', 'G');
        frontAlphabet.put('L', 'A');

        frontAlphabet.put('G', 'D');
        frontAlphabet.put('D', 'F');
        frontAlphabet.put('Q', 'P');
        frontAlphabet.put('V', 'V');
        frontAlphabet.put('Z', 'Z');

        frontAlphabet.put('N', 'B');
        frontAlphabet.put('T', 'E');
        frontAlphabet.put('O', 'C');
        frontAlphabet.put('W', 'K');
        frontAlphabet.put('Y', 'M');

        frontAlphabet.put('H', 'T');
        frontAlphabet.put('X', 'H');
        frontAlphabet.put('U', 'X');
        frontAlphabet.put('S', 'S');
        frontAlphabet.put('P', 'L');

        frontAlphabet.put('A', 'R');
        frontAlphabet.put('I', 'I');
        frontAlphabet.put('B', 'N');
        frontAlphabet.put('R', 'Q');
        frontAlphabet.put('C', 'O');
        frontAlphabet.put('J', 'J');

        backAlphabet = frontAlphabet.inverseBidiMap();
    }

    @Override
    public AlphabeticSignal getRingSetting() {
        return ringSetting;
    }

    public void setRingSetting(final AlphabeticSignal ringSetting) {
        this.ringSetting = ringSetting;
    }

    @Override
    public AlphabeticSignal exchange(final AlphabeticSignal signal) {
        final char exchanged = frontAlphabet.get(signal.getCharacter());
        signal.setCharacter(exchanged);
        return signal;
    }

    @Override
    public AlphabeticSignal backwardExchange(final AlphabeticSignal signal) {
        final char exchanged = backAlphabet.get(signal.getCharacter());
        signal.setCharacter(exchanged);
        return signal;
    }

    @Override
    public char getTurnoverPosition() {
        return TURNOVER_POSITION;
    }

    @Override
    public void rotate() {
        ringSetting.plus('B');
    }
}
