package ru.victimoftrap.enigma.rotors.factory;

import ru.victimoftrap.enigma.rotors.*;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

public class RotorFactory {
    private final Map<EnigmaIRotor, Supplier<Rotor>> rotorsMap;

    public RotorFactory() {
        this.rotorsMap = new HashMap<>();
        rotorsMap.put(EnigmaIRotor.ROTOR_I, RotorI::new);
        rotorsMap.put(EnigmaIRotor.ROTOR_II, RotorII::new);
        rotorsMap.put(EnigmaIRotor.ROTOR_III, RotorIII::new);
        rotorsMap.put(EnigmaIRotor.ROTOR_IV, RotorIV::new);
        rotorsMap.put(EnigmaIRotor.ROTOR_V, RotorV::new);
        rotorsMap.put(EnigmaIRotor.ROTOR_VI, RotorVI::new);
    }

    public Rotor createRotor(final EnigmaIRotor rotorType) {
        final Supplier<Rotor> rotor = rotorsMap.get(rotorType);
        if (rotor == null) {
            return null;
        }
        return rotor.get();
    }
}
