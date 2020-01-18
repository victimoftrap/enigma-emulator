package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorVI implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final char FIRST_TURNOVER_POSITION = 'A';
    private final char SECOND_TURNOVER_POSITION = 'N';
    private AlphabeticSignal initialPosition = new AlphabeticSignal('A');

    public RotorVI() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'J');
        frontAlphabet.put('B', 'P');
        frontAlphabet.put('C', 'G');
        frontAlphabet.put('D', 'V');
        frontAlphabet.put('E', 'O');

        frontAlphabet.put('F', 'U');
        frontAlphabet.put('G', 'M');
        frontAlphabet.put('H', 'F');
        frontAlphabet.put('I', 'Y');
        frontAlphabet.put('J', 'Q');

        frontAlphabet.put('K', 'B');
        frontAlphabet.put('L', 'E');
        frontAlphabet.put('M', 'N');
        frontAlphabet.put('N', 'H');
        frontAlphabet.put('O', 'Z');

        frontAlphabet.put('P', 'R');
        frontAlphabet.put('Q', 'D');
        frontAlphabet.put('R', 'K');
        frontAlphabet.put('S', 'A');
        frontAlphabet.put('T', 'S');

        frontAlphabet.put('U', 'X');
        frontAlphabet.put('V', 'L');
        frontAlphabet.put('W', 'I');
        frontAlphabet.put('X', 'C');
        frontAlphabet.put('Y', 'T');
        frontAlphabet.put('Z', 'W');

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
        final char c = initialPosition.getCharacter();
        if (c > FIRST_TURNOVER_POSITION && c <= SECOND_TURNOVER_POSITION) {
            return SECOND_TURNOVER_POSITION;
        } else {
            return FIRST_TURNOVER_POSITION;
        }
    }

    @Override
    public void rotate() {
        initialPosition.plus('B');
    }
}
