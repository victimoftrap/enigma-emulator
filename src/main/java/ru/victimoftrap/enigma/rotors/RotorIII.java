package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorIII implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char TURNOVER_POSITION = 'W';
    private AlphabeticSignal ringSetting = new AlphabeticSignal('A');

    public RotorIII() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('B', 'T');
        frontAlphabet.put('D', 'A');
        frontAlphabet.put('F', 'G');
        frontAlphabet.put('H', 'B');
        frontAlphabet.put('J', 'P');

        frontAlphabet.put('L', 'C');
        frontAlphabet.put('C', 'S');
        frontAlphabet.put('P', 'D');
        frontAlphabet.put('R', 'Q');
        frontAlphabet.put('T', 'E');

        frontAlphabet.put('X', 'U');
        frontAlphabet.put('V', 'F');
        frontAlphabet.put('Z', 'V');
        frontAlphabet.put('N', 'N');
        frontAlphabet.put('Y', 'Z');

        frontAlphabet.put('E', 'H');
        frontAlphabet.put('I', 'Y');
        frontAlphabet.put('W', 'I');
        frontAlphabet.put('G', 'X');
        frontAlphabet.put('A', 'J');

        frontAlphabet.put('K', 'W');
        frontAlphabet.put('M', 'L');
        frontAlphabet.put('U', 'R');
        frontAlphabet.put('S', 'K');
        frontAlphabet.put('Q', 'O');
        frontAlphabet.put('O', 'M');

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
