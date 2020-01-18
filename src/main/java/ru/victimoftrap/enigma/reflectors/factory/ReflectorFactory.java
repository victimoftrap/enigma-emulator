package ru.victimoftrap.enigma.reflectors.factory;

import ru.victimoftrap.enigma.reflectors.Reflector;
import ru.victimoftrap.enigma.reflectors.ReflectorB;
import ru.victimoftrap.enigma.reflectors.ReflectorC;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

public class ReflectorFactory {
    private final Map<ReflectorType, Supplier<Reflector>> reflectorMap;

    public ReflectorFactory() {
        reflectorMap = new HashMap<>();
        reflectorMap.put(ReflectorType.REFLECTOR_B, ReflectorB::new);
        reflectorMap.put(ReflectorType.REFLECTOR_C, ReflectorC::new);
    }

    public Reflector createReflector(final ReflectorType reflectorType) {
        final Supplier<Reflector> reflector = reflectorMap.get(reflectorType);
        if (reflector == null) {
            return null;
        }
        return reflector.get();
    }
}
