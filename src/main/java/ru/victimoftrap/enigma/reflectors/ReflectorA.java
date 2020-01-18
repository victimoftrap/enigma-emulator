package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import java.util.HashMap;
import java.util.Map;

public class ReflectorA implements Reflector {
    private final Map<Character, Character> reflectorMap;

    public ReflectorA() {
        reflectorMap = new HashMap<>();
        reflectorMap.put('A', 'E');
        reflectorMap.put('B', 'J');
        reflectorMap.put('C', 'M');
        reflectorMap.put('D', 'Z');
        reflectorMap.put('E', 'A');

        reflectorMap.put('F', 'L');
        reflectorMap.put('G', 'Y');
        reflectorMap.put('H', 'X');
        reflectorMap.put('I', 'V');
        reflectorMap.put('J', 'B');

        reflectorMap.put('K', 'W');
        reflectorMap.put('L', 'F');
        reflectorMap.put('M', 'C');
        reflectorMap.put('N', 'R');
        reflectorMap.put('O', 'Q');

        reflectorMap.put('P', 'U');
        reflectorMap.put('Q', 'O');
        reflectorMap.put('R', 'N');
        reflectorMap.put('S', 'T');
        reflectorMap.put('T', 'S');

        reflectorMap.put('U', 'P');
        reflectorMap.put('V', 'I');
        reflectorMap.put('W', 'K');
        reflectorMap.put('X', 'H');
        reflectorMap.put('Y', 'G');
        reflectorMap.put('Z', 'D');
    }

    @Override
    public AlphabeticSignal reflectorExchange(final AlphabeticSignal signal) {
        final char receivedChar = signal.getCharacter();
        final char reflectedChar = reflectorMap.getOrDefault(receivedChar, receivedChar);
        signal.setCharacter(reflectedChar);
        return signal;
    }
}
