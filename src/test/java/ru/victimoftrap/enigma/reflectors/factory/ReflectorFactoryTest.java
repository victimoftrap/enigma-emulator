package ru.victimoftrap.enigma.reflectors.factory;

import ru.victimoftrap.enigma.reflectors.ReflectorA;
import ru.victimoftrap.enigma.reflectors.ReflectorB;
import ru.victimoftrap.enigma.reflectors.ReflectorC;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.victimoftrap.enigma.reflectors.factory.ReflectorType.*;

class ReflectorFactoryTest {
    private ReflectorFactory reflectorFactory = new ReflectorFactory();

    @Test
    void testReflectorFactory() {
        assertTrue(reflectorFactory.createReflector(REFLECTOR_A) instanceof ReflectorA);
        assertTrue(reflectorFactory.createReflector(REFLECTOR_B) instanceof ReflectorB);
        assertTrue(reflectorFactory.createReflector(REFLECTOR_C) instanceof ReflectorC);
        assertNull(reflectorFactory.createReflector(null));
    }
}