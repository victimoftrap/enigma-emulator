package ru.victimoftrap.enigma.rotors.factory;

import ru.victimoftrap.enigma.rotors.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.victimoftrap.enigma.rotors.factory.EnigmaIRotor.*;

class RotorFactoryTest {
    private RotorFactory rotorFactory = new RotorFactory();

    @Test
    void testReflectorFactory() {
        assertTrue(rotorFactory.createRotor(ROTOR_I) instanceof RotorI);
        assertTrue(rotorFactory.createRotor(ROTOR_II) instanceof RotorII);
        assertTrue(rotorFactory.createRotor(ROTOR_III) instanceof RotorIII);
        assertTrue(rotorFactory.createRotor(ROTOR_IV) instanceof RotorIV);
        assertTrue(rotorFactory.createRotor(ROTOR_V) instanceof RotorV);
        assertTrue(rotorFactory.createRotor(ROTOR_VI) instanceof RotorVI);
        assertNull(rotorFactory.createRotor(null));
    }
}