package ru.victimoftrap.enigma.reflectors.factory;

import java.util.Arrays;
import java.util.List;

public enum ReflectorType {
    REFLECTOR_A("ReflectorA", "Reflector_A", "REFLECTOR_A", "A"),
    REFLECTOR_B("ReflectorB", "Reflector_B", "REFLECTOR_B", "B"),
    REFLECTOR_C("ReflectorC", "Reflector_C", "REFLECTOR_C", "C");

    private List<String> names;

    ReflectorType(final String... names) {
        this.names = Arrays.asList(names);
    }

    public List<String> getNames() {
        return names;
    }

    public static ReflectorType getByTypeName(final String name) throws NoSuchReflectorTypeException {
        for (var item : ReflectorType.values()) {
            if (item.names.contains(name)) {
                return item;
            }
        }
        throw new NoSuchReflectorTypeException();
    }
}
