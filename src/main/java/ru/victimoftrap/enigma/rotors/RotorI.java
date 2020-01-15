package ru.victimoftrap.enigma.rotors;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorI implements BiDirectionConnection {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final int ROTATION_TRIGGER = 17;

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
    public Character getFront(final Character frontCharacter) {
        return frontAlphabet.get(frontCharacter);
    }

    @Override
    public Character getBack(final Character backCharacter) {
        return backAlphabet.get(backCharacter);
    }
}
