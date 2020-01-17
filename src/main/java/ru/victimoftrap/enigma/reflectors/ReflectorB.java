package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import java.util.Map;
import java.util.HashMap;

public class ReflectorB implements Reflector {
    private final Map<Character, Character> reflectorMap;

    public ReflectorB() {
        reflectorMap = new HashMap<>();
        reflectorMap.put('A', 'Y');
        reflectorMap.put('B', 'R');
        reflectorMap.put('C', 'U');
        reflectorMap.put('D', 'H');
        reflectorMap.put('E', 'Q');

        reflectorMap.put('F', 'S');
        reflectorMap.put('G', 'L');
        reflectorMap.put('H', 'D');
        reflectorMap.put('I', 'P');
        reflectorMap.put('J', 'X');

        reflectorMap.put('K', 'N');
        reflectorMap.put('L', 'G');
        reflectorMap.put('M', 'O');
        reflectorMap.put('N', 'K');
        reflectorMap.put('O', 'M');

        reflectorMap.put('P', 'I');
        reflectorMap.put('Q', 'E');
        reflectorMap.put('R', 'B');
        reflectorMap.put('S', 'F');
        reflectorMap.put('T', 'Z');

        reflectorMap.put('U', 'C');
        reflectorMap.put('V', 'W');
        reflectorMap.put('W', 'V');
        reflectorMap.put('X', 'J');
        reflectorMap.put('Y', 'A');
        reflectorMap.put('Z', 'T');
    }

    @Override
    public AlphabeticSignal reflectorExchange(final AlphabeticSignal signal) {
        final char receivedChar = signal.getCharacter();
        final char reflectedChar = reflectorMap.getOrDefault(receivedChar, receivedChar);
        signal.setCharacter(reflectedChar);
        return signal;
    }
}
