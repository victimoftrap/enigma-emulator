package ru.victimoftrap.enigma.rotors;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorIII implements BiDirectionConnection {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final int ROTATION_TRIGGER = 22;

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
    public Character getFront(final Character frontCharacter) {
        return frontAlphabet.get(frontCharacter);
    }

    @Override
    public Character getBack(final Character backCharacter) {
        return backAlphabet.get(backCharacter);
    }
}
