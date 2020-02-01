package ru.victimoftrap.enigma.configuration.file;

import ru.victimoftrap.enigma.configuration.EnigmaConfiguration;
import ru.victimoftrap.enigma.configuration.file.model.FileEnigmaConfiguration;
import ru.victimoftrap.enigma.plugboard.Plugboard;
import ru.victimoftrap.enigma.plugboard.StandardPlugboard;
import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.rotors.factory.EnigmaIRotor;
import ru.victimoftrap.enigma.rotors.factory.RotorFactory;
import ru.victimoftrap.enigma.reflectors.Reflector;
import ru.victimoftrap.enigma.reflectors.factory.ReflectorFactory;
import ru.victimoftrap.enigma.reflectors.factory.ReflectorType;

import java.util.List;
import java.util.ArrayList;

public class FileEnigmaConfigurationConverter {
    private static final RotorFactory rotorFactory = new RotorFactory();
    private static final ReflectorFactory reflectorFactory = new ReflectorFactory();

    public static EnigmaConfiguration create(final FileEnigmaConfiguration fileConfiguration) {
        final Plugboard plugboard = new StandardPlugboard();
        for (final var plugboardConnection : fileConfiguration.getPlugboardConnections()) {
            plugboard.reconnect(
                    plugboardConnection.getFromCharacter().charAt(0),
                    plugboardConnection.getToCharacter().charAt(0)
            );
        }

        final List<Rotor> rotors = new ArrayList<>();
        for (final var configRotor : fileConfiguration.getRotors()) {
            final Rotor rotor = rotorFactory.createRotor(
                    EnigmaIRotor.valueOf(configRotor.getRotorName())
            );
            rotor.getInitialPosition().setCharacter(
                    configRotor.getInitialPosition().charAt(0)
            );
            rotors.add(rotor);
        }

        final Reflector reflector = reflectorFactory.createReflector(
                ReflectorType.valueOf(fileConfiguration.getReflector().getReflectorName())
        );
        return new EnigmaConfiguration(plugboard, rotors, reflector);
    }
}
