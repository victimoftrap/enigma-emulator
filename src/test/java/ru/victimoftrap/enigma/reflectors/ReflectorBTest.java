package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReflectorBTest {
    private Reflector reflector = new ReflectorB();

    @Test
    void testExchangeLetters() {
        final var signalA = new AlphabeticSignal('A');
        final var signalY = new AlphabeticSignal('Y');

        assertEquals('Y', reflector.reflectorExchange(signalA).getCharacter());
        assertEquals('A', reflector.reflectorExchange(signalY).getCharacter());
        assertEquals('Y', signalA.getCharacter());
        assertEquals('A', signalY.getCharacter());

        final var signalI = new AlphabeticSignal('I');
        final var signalP = new AlphabeticSignal('P');

        assertEquals('P', reflector.reflectorExchange(signalI).getCharacter());
        assertEquals('I', reflector.reflectorExchange(signalP).getCharacter());
        assertEquals('P', signalI.getCharacter());
        assertEquals('I', signalP.getCharacter());
    }

    @Test
    void testExchangeLetters_nonLatinCharacter_shouldReturnThisCharacter() {
        final var signal = new AlphabeticSignal('@');
        assertEquals(signal, reflector.reflectorExchange(signal));
    }
}