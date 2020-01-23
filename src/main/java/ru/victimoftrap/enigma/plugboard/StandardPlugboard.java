package ru.victimoftrap.enigma.plugboard;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class StandardPlugboard implements Plugboard {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;

    public StandardPlugboard() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'A');
        frontAlphabet.put('B', 'B');
        frontAlphabet.put('C', 'C');
        frontAlphabet.put('D', 'D');
        frontAlphabet.put('E', 'E');

        frontAlphabet.put('F', 'F');
        frontAlphabet.put('G', 'G');
        frontAlphabet.put('H', 'H');
        frontAlphabet.put('I', 'I');
        frontAlphabet.put('J', 'J');

        frontAlphabet.put('K', 'K');
        frontAlphabet.put('L', 'L');
        frontAlphabet.put('M', 'M');
        frontAlphabet.put('N', 'N');
        frontAlphabet.put('O', 'O');

        frontAlphabet.put('P', 'P');
        frontAlphabet.put('Q', 'Q');
        frontAlphabet.put('R', 'R');
        frontAlphabet.put('S', 'S');
        frontAlphabet.put('T', 'T');

        frontAlphabet.put('U', 'U');
        frontAlphabet.put('V', 'V');
        frontAlphabet.put('W', 'W');
        frontAlphabet.put('X', 'X');
        frontAlphabet.put('Y', 'Y');
        frontAlphabet.put('Z', 'Z');

        backAlphabet = frontAlphabet.inverseBidiMap();
    }

    @Override
    public AlphabeticSignal exchange(final AlphabeticSignal signal) {
        final char signalChar = signal.getCharacter();
        final Character exchanged = frontAlphabet.getOrDefault(signalChar, signalChar);
        signal.setCharacter(exchanged);
        return signal;
    }

    @Override
    public AlphabeticSignal backwardExchange(final AlphabeticSignal signal) {
        final char signalChar = signal.getCharacter();
        final char exchanged = backAlphabet.getOrDefault(signalChar, signalChar);
        signal.setCharacter(exchanged);
        return signal;
    }

    @Override
    public void reconnect(final char letter1, final char letter2) {
        final char letter1ConnectedTo = frontAlphabet.get(letter1);
        frontAlphabet.put(letter1ConnectedTo, letter1ConnectedTo);

        final char letter2ConnectedTo = backAlphabet.get(letter2);
        backAlphabet.put(letter2ConnectedTo, letter2ConnectedTo);

        frontAlphabet.put(letter1, letter2);
        backAlphabet.put(letter1, letter2);
    }
}
