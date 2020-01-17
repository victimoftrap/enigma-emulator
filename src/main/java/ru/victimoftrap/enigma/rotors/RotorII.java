package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorII implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char TURNOVER_POSITION = 'F';
    private AlphabeticSignal initialPosition = new AlphabeticSignal('A');

    public RotorII() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'A');
        frontAlphabet.put('B', 'J');
        frontAlphabet.put('C', 'D');
        frontAlphabet.put('D', 'K');
        frontAlphabet.put('E', 'S');

        frontAlphabet.put('F', 'I');
        frontAlphabet.put('G', 'R');
        frontAlphabet.put('H', 'U');
        frontAlphabet.put('I', 'X');
        frontAlphabet.put('J', 'B');

        frontAlphabet.put('K', 'L');
        frontAlphabet.put('L', 'H');
        frontAlphabet.put('M', 'W');
        frontAlphabet.put('N', 'T');
        frontAlphabet.put('O', 'M');

        frontAlphabet.put('P', 'C');
        frontAlphabet.put('Q', 'Q');
        frontAlphabet.put('R', 'G');
        frontAlphabet.put('S', 'Z');
        frontAlphabet.put('T', 'N');

        frontAlphabet.put('U', 'P');
        frontAlphabet.put('V', 'Y');
        frontAlphabet.put('W', 'F');
        frontAlphabet.put('X', 'V');
        frontAlphabet.put('Y', 'O');
        frontAlphabet.put('Z', 'E');

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
