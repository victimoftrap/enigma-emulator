package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorIV implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char TURNOVER_POSITION = 'K';
    private AlphabeticSignal initialPosition = new AlphabeticSignal('A');

    public RotorIV() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'E');
        frontAlphabet.put('B', 'S');
        frontAlphabet.put('C', 'O');
        frontAlphabet.put('D', 'V');
        frontAlphabet.put('E', 'P');

        frontAlphabet.put('F', 'Z');
        frontAlphabet.put('G', 'J');
        frontAlphabet.put('H', 'A');
        frontAlphabet.put('I', 'Y');
        frontAlphabet.put('J', 'Q');

        frontAlphabet.put('K', 'U');
        frontAlphabet.put('L', 'I');
        frontAlphabet.put('M', 'R');
        frontAlphabet.put('N', 'H');
        frontAlphabet.put('O', 'X');

        frontAlphabet.put('P', 'L');
        frontAlphabet.put('Q', 'N');
        frontAlphabet.put('R', 'F');
        frontAlphabet.put('S', 'T');
        frontAlphabet.put('T', 'G');

        frontAlphabet.put('U', 'K');
        frontAlphabet.put('V', 'D');
        frontAlphabet.put('W', 'C');
        frontAlphabet.put('X', 'M');
        frontAlphabet.put('Y', 'W');
        frontAlphabet.put('Z', 'B');

        backAlphabet = frontAlphabet.inverseBidiMap();
    }

    @Override
    public AlphabeticSignal getInitialPosition() {
        return initialPosition;
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
        initialPosition.plus('B');
    }
}
