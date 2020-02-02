package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectorATest {
    private Reflector reflector = new ReflectorA();

    @Test
    void testExchangeLetters() {
        final var signalD = new AlphabeticSignal('D');
        final var signalZ = new AlphabeticSignal('Z');

        assertEquals('Z', reflector.reflectorExchange(signalD).getCharacter());
        assertEquals('D', reflector.reflectorExchange(signalZ).getCharacter());
        assertEquals('Z', signalD.getCharacter());
        assertEquals('D', signalZ.getCharacter());

        final var signalF = new AlphabeticSignal('F');
        final var signalL = new AlphabeticSignal('L');

        assertEquals('L', reflector.reflectorExchange(signalF).getCharacter());
        assertEquals('F', reflector.reflectorExchange(signalL).getCharacter());
        assertEquals('L', signalF.getCharacter());
        assertEquals('F', signalL.getCharacter());
    }

    @Test
    void testExchangeLetters_nonLatinCharacter_shouldReturnThisCharacter() {
        final var signal = new AlphabeticSignal('@');
        assertEquals(signal, reflector.reflectorExchange(signal));
    }
}