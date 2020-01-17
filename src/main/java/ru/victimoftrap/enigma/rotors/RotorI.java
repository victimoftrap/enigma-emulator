package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorI implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char TURNOVER_POSITION = 'R';
    private AlphabeticSignal initialPosition = new AlphabeticSignal('A');

    public RotorI() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'E');
        frontAlphabet.put('B', 'K');
        frontAlphabet.put('C', 'M');
        frontAlphabet.put('D', 'F');
        frontAlphabet.put('E', 'L');

        frontAlphabet.put('F', 'G');
        frontAlphabet.put('G', 'D');
        frontAlphabet.put('H', 'Q');
        frontAlphabet.put('I', 'V');
        frontAlphabet.put('J', 'Z');

        frontAlphabet.put('K', 'N');
        frontAlphabet.put('L', 'T');
        frontAlphabet.put('M', 'O');
        frontAlphabet.put('N', 'W');
        frontAlphabet.put('O', 'Y');

        frontAlphabet.put('P', 'H');
        frontAlphabet.put('Q', 'X');
        frontAlphabet.put('R', 'U');
        frontAlphabet.put('S', 'S');
        frontAlphabet.put('T', 'P');

        frontAlphabet.put('U', 'A');
        frontAlphabet.put('V', 'I');
        frontAlphabet.put('W', 'B');
        frontAlphabet.put('X', 'R');
        frontAlphabet.put('Y', 'C');
        frontAlphabet.put('Z', 'J');

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
