package ru.victimoftrap.enigma.signal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlphabeticSignalTest {
    @Test
    void testPlusOperation() {
        final AlphabeticSignal signal1 = new AlphabeticSignal('A');
        char actualChar1 = signal1.plus('R').getCharacter();
        assertEquals('R', actualChar1);

        final AlphabeticSignal signal2 = new AlphabeticSignal('U');
        char actualChar2 = signal2.plus('E').getCharacter();
        assertEquals('Y', actualChar2);

        final AlphabeticSignal signal3 = new AlphabeticSignal('N');
        char actualChar3 = signal3.plus('C').getCharacter();
        assertEquals('P', actualChar3);

        final AlphabeticSignal signal4 = new AlphabeticSignal('O');
        char actualChar4 = signal4.plus('H').getCharacter();
        assertEquals('V', actualChar4);

        final AlphabeticSignal signal5 = new AlphabeticSignal('A');
        char actualChar5 = signal5.plus('A').getCharacter();
        assertEquals('A', actualChar5);

        final AlphabeticSignal signal6 = new AlphabeticSignal('Y');
        char actualChar6 = signal6.plus('D').getCharacter();
        assertEquals('C', actualChar6);
    }

    @Test
    void testMinusOperation() {
        final AlphabeticSignal signal1 = new AlphabeticSignal('A');
        char actualChar1 = signal1.minus('A').getCharacter();
        assertEquals('A', actualChar1);

        final AlphabeticSignal signal2 = new AlphabeticSignal('A');
        char actualChar2 = signal2.minus('B').getCharacter();
        assertEquals('Z', actualChar2);

        final AlphabeticSignal signal3 = new AlphabeticSignal('C');
        char actualChar3 = signal3.minus('V').getCharacter();
        assertEquals('H', actualChar3);

        final AlphabeticSignal signal4 = new AlphabeticSignal('M');
        char actualChar4 = signal4.minus('C').getCharacter();
        assertEquals('K', actualChar4);

        final AlphabeticSignal signal5 = new AlphabeticSignal('N');
        char actualChar5 = signal5.minus('R').getCharacter();
        assertEquals('W', actualChar5);

        final AlphabeticSignal signal6 = new AlphabeticSignal('H');
        char actualChar6 = signal6.minus('H').getCharacter();
        assertEquals('A', actualChar6);

        final AlphabeticSignal signal7 = new AlphabeticSignal('V');
        char actualChar7 = signal7.minus('R').getCharacter();
        assertEquals('E', actualChar7);
    }
}