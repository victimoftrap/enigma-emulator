package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectorCTest {
    private Reflector reflector = new ReflectorC();

    @Test
    void testExchangeLetters() {
        final var signalA = new AlphabeticSignal('A');
        final var signalF = new AlphabeticSignal('F');

        assertEquals('F', reflector.reflectorExchange(signalA).getCharacter());
        assertEquals('A', reflector.reflectorExchange(signalF).getCharacter());
        assertEquals('F', signalA.getCharacter());
        assertEquals('A', signalF.getCharacter());

        final var signalL = new AlphabeticSignal('L');
        final var signalZ = new AlphabeticSignal('Z');

        assertEquals('Z', reflector.reflectorExchange(signalL).getCharacter());
        assertEquals('L', reflector.reflectorExchange(signalZ).getCharacter());
        assertEquals('Z', signalL.getCharacter());
        assertEquals('L', signalZ.getCharacter());
    }

    @Test
    void testExchangeLetters_nonLatinCharacter_shouldReturnThisCharacter() {
        final var signal = new AlphabeticSignal('@');
        assertEquals(signal, reflector.reflectorExchange(signal));
    }
}