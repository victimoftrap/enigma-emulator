package ru.victimoftrap.enigma.configuration;

import ru.victimoftrap.enigma.plugboard.Plugboard;
import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.reflectors.Reflector;

import java.util.List;
import java.util.Objects;

public class EnigmaConfiguration {
    private Plugboard plugboard;
    private List<Rotor> rotors;
    private Reflector reflector;

    public EnigmaConfiguration(
            final Plugboard plugboard,
            final List<Rotor> rotors,
            final Reflector reflector
    ) {
        this.plugboard = plugboard;
        this.rotors = rotors;
        this.reflector = reflector;
    }

    public Plugboard getPlugboard() {
        return plugboard;
    }

    public void setPlugboard(final Plugboard plugboard) {
        this.plugboard = plugboard;
    }

    public List<Rotor> getRotors() {
        return rotors;
    }

    public void setRotors(final List<Rotor> rotors) {
        this.rotors = rotors;
    }

    public Reflector getReflector() {
        return reflector;
    }

    public void setReflector(final Reflector reflector) {
        this.reflector = reflector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EnigmaConfiguration)) return false;
        EnigmaConfiguration that = (EnigmaConfiguration) o;
        return Objects.equals(plugboard, that.plugboard) &&
                Objects.equals(rotors, that.rotors) &&
                Objects.equals(reflector, that.reflector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plugboard, rotors, reflector);
    }
}
