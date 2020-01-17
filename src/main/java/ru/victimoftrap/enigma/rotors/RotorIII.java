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
        frontAlphabet.put('A', 'B');
        frontAlphabet.put('B', 'D');
        frontAlphabet.put('C', 'F');
        frontAlphabet.put('D', 'H');
        frontAlphabet.put('E', 'J');

        frontAlphabet.put('F', 'L');
        frontAlphabet.put('G', 'C');
        frontAlphabet.put('H', 'P');
        frontAlphabet.put('I', 'R');
        frontAlphabet.put('J', 'T');

        frontAlphabet.put('K', 'X');
        frontAlphabet.put('L', 'V');
        frontAlphabet.put('M', 'Z');
        frontAlphabet.put('N', 'N');
        frontAlphabet.put('O', 'Y');

        frontAlphabet.put('P', 'E');
        frontAlphabet.put('Q', 'I');
        frontAlphabet.put('R', 'W');
        frontAlphabet.put('S', 'G');
        frontAlphabet.put('T', 'A');

        frontAlphabet.put('U', 'K');
        frontAlphabet.put('V', 'M');
        frontAlphabet.put('W', 'U');
        frontAlphabet.put('X', 'S');
        frontAlphabet.put('Y', 'Q');
        frontAlphabet.put('Z', 'O');

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
