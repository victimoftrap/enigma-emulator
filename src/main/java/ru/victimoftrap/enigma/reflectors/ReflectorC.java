package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import java.util.Map;
import java.util.HashMap;

public class ReflectorC implements Reflector {
    private final Map<Character, Character> reflectorMap;

    public ReflectorC() {
        reflectorMap = new HashMap<>();
        reflectorMap.put('A', 'F');
        reflectorMap.put('B', 'V');
        reflectorMap.put('C', 'P');
        reflectorMap.put('D', 'J');
        reflectorMap.put('E', 'I');

        reflectorMap.put('F', 'A');
        reflectorMap.put('G', 'O');
        reflectorMap.put('H', 'Y');
        reflectorMap.put('I', 'E');
        reflectorMap.put('J', 'D');

        reflectorMap.put('K', 'R');
        reflectorMap.put('L', 'Z');
        reflectorMap.put('M', 'X');
        reflectorMap.put('N', 'W');
        reflectorMap.put('O', 'G');

        reflectorMap.put('P', 'C');
        reflectorMap.put('Q', 'T');
        reflectorMap.put('R', 'K');
        reflectorMap.put('S', 'U');
        reflectorMap.put('T', 'Q');

        reflectorMap.put('U', 'S');
        reflectorMap.put('V', 'B');
        reflectorMap.put('W', 'N');
        reflectorMap.put('X', 'M');
        reflectorMap.put('Y', 'H');
        reflectorMap.put('Z', 'L');
    }

    @Override
    public AlphabeticSignal reflectorExchange(final AlphabeticSignal signal) {
        final char receivedChar = signal.getCharacter();
        final char reflectedChar = reflectorMap.getOrDefault(receivedChar, receivedChar);
        signal.setCharacter(reflectedChar);
        return signal;
    }
}
