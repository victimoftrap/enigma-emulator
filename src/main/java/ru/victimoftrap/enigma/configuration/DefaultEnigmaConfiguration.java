package ru.victimoftrap.enigma.configuration;

import ru.victimoftrap.enigma.plugboard.StandardPlugboard;
import ru.victimoftrap.enigma.rotors.RotorI;
import ru.victimoftrap.enigma.rotors.RotorII;
import ru.victimoftrap.enigma.rotors.RotorIII;
import ru.victimoftrap.enigma.reflectors.ReflectorB;

import java.util.Arrays;

public class DefaultEnigmaConfiguration extends EnigmaConfiguration {
    public DefaultEnigmaConfiguration() {
        super(
                new StandardPlugboard(),
                Arrays.asList(new RotorI(), new RotorII(), new RotorIII()),
                new ReflectorB()
        );
    }
}
