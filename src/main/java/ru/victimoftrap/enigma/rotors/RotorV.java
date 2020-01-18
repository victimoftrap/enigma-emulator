package ru.victimoftrap.enigma.rotors;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class RotorV implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char TURNOVER_POSITION = 'A';
    private AlphabeticSignal initialPosition = new AlphabeticSignal('A');

    public RotorV() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'V');
        frontAlphabet.put('B', 'Z');
        frontAlphabet.put('C', 'B');
        frontAlphabet.put('D', 'R');
        frontAlphabet.put('E', 'G');

        frontAlphabet.put('F', 'I');
        frontAlphabet.put('G', 'T');
        frontAlphabet.put('H', 'Y');
        frontAlphabet.put('I', 'U');
        frontAlphabet.put('J', 'P');

        frontAlphabet.put('K', 'S');
        frontAlphabet.put('L', 'D');
        frontAlphabet.put('M', 'N');
        frontAlphabet.put('N', 'H');
        frontAlphabet.put('O', 'L');

        frontAlphabet.put('P', 'X');
        frontAlphabet.put('Q', 'A');
        frontAlphabet.put('R', 'W');
        frontAlphabet.put('S', 'M');
        frontAlphabet.put('T', 'J');

        frontAlphabet.put('U', 'Q');
        frontAlphabet.put('V', 'O');
        frontAlphabet.put('W', 'F');
        frontAlphabet.put('X', 'E');
        frontAlphabet.put('Y', 'C');
        frontAlphabet.put('Z', 'K');

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
