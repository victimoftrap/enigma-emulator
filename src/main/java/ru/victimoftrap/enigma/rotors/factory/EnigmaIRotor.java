package ru.victimoftrap.enigma.rotors.factory;

import java.util.Arrays;
import java.util.List;

public enum EnigmaIRotor {
    ROTOR_I("RotorI", "Rotor_I", "ROTOR_I", "I"),
    ROTOR_II("RotorII", "Rotor_II", "ROTOR_II", "II"),
    ROTOR_III("RotorIII", "Rotor_III", "ROTOR_III", "III"),
    ROTOR_IV("RotorIV", "Rotor_IV", "ROTOR_IV", "IV"),
    ROTOR_V("RotorV", "Rotor_V", "ROTOR_V", "V"),
    ROTOR_VI("RotorVI", "Rotor_VI", "ROTOR_VI", "VI");

    private List<String> names;

    private EnigmaIRotor(final String... names) {
        this.names = Arrays.asList(names);
    }

    public List<String> getNames() {
        return names;
    }

    public static EnigmaIRotor getByTypeName(final String name) throws NoSuchRotorTypeException {
        for (var item : EnigmaIRotor.values()) {
            if (item.names.contains(name)) {
                return item;
            }
        }
        throw new NoSuchRotorTypeException();
    }
}
