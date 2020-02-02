package ru.victimoftrap.enigma.plugboard;

import org.junit.jupiter.api.Test;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

import static org.junit.jupiter.api.Assertions.*;

class StandardPlugboardTest {
    @Test
    void testExchangeLetters() {
        final var plugboard = new StandardPlugboard();

        final var signalA = new AlphabeticSignal('A');
        assertEquals(signalA, plugboard.exchange(signalA));
        assertEquals(signalA, plugboard.backwardExchange(signalA));

        final var signalU = new AlphabeticSignal('U');
        assertEquals(signalU, plugboard.exchange(signalU));
        assertEquals(signalU, plugboard.backwardExchange(signalU));
    }

    @Test
    void testReconnectLetters() {
        final var plugboard = new StandardPlugboard();

        final var signalA = new AlphabeticSignal('A');
        assertEquals('A', plugboard.exchange(signalA).getCharacter());
        assertEquals('A', plugboard.backwardExchange(signalA).getCharacter());

        plugboard.reconnect('A', 'Z');
        final var signalZ = new AlphabeticSignal('Z');
        signalA.setCharacter('A');
        assertEquals('Z', plugboard.exchange(signalA).getCharacter());
        assertEquals('A', plugboard.backwardExchange(signalZ).getCharacter());

        plugboard.reconnect('A', 'B');
        signalA.setCharacter('A');
        signalZ.setCharacter('Z');
        final var signalB = new AlphabeticSignal('B');
        assertEquals('B', plugboard.exchange(signalA).getCharacter());
        assertEquals('A', plugboard.backwardExchange(signalB).getCharacter());
    }
}