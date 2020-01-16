package ru.victimoftrap.enigma.rotors;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

public class RotorII implements Rotor {
    private final BidiMap<Character, Character> frontAlphabet;
    private final BidiMap<Character, Character> backAlphabet;
    private final int ROTATION_TRIGGER = 5;

    public RotorII() {
        frontAlphabet = new DualHashBidiMap<>();
        frontAlphabet.put('A', 'A');
        frontAlphabet.put('J', 'J');
        frontAlphabet.put('D', 'P');
        frontAlphabet.put('K', 'C');
        frontAlphabet.put('S', 'Z');

        frontAlphabet.put('I', 'W');
        frontAlphabet.put('R', 'R');
        frontAlphabet.put('U', 'L');
        frontAlphabet.put('X', 'F');
        frontAlphabet.put('B', 'B');

        frontAlphabet.put('L', 'D');
        frontAlphabet.put('H', 'K');
        frontAlphabet.put('W', 'O');
        frontAlphabet.put('T', 'T');
        frontAlphabet.put('M', 'Y');

        frontAlphabet.put('C', 'U');
        frontAlphabet.put('Q', 'Q');
        frontAlphabet.put('G', 'G');
        frontAlphabet.put('Z', 'E');
        frontAlphabet.put('N', 'N');

        frontAlphabet.put('P', 'H');
        frontAlphabet.put('Y', 'X');
        frontAlphabet.put('F', 'M');
        frontAlphabet.put('V', 'I');
        frontAlphabet.put('O', 'V');
        frontAlphabet.put('E', 'S');

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

    @Override
    public int getNextRotorTriggeredStep() {
        return ROTATION_TRIGGER;
    }
}
