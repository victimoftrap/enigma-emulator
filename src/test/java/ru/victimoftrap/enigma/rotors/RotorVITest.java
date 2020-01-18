package ru.victimoftrap.enigma.rotors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotorVITest {
    private Rotor rotor = new RotorVI();

    @Test
    void testGetTurnoverPosition() {
        assertEquals('A', rotor.getTurnoverPosition());

        rotor.rotate();
        assertEquals('N', rotor.getTurnoverPosition());

        rotor.getInitialPosition().setCharacter('N');
        assertEquals('N', rotor.getTurnoverPosition());

        rotor.rotate();
        assertEquals('A', rotor.getTurnoverPosition());
    }
}