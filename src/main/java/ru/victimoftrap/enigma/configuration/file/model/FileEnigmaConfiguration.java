package ru.victimoftrap.enigma.configuration.file.model;

import java.util.List;
import java.util.Objects;

public class FileEnigmaConfiguration {
    private List<FileEnigmaRotor> rotors;
    private FileEnigmaReflector reflector;
    private List<FileEnigmaPlugboardConnection> plugboardConnections;

    public FileEnigmaConfiguration(
            final List<FileEnigmaRotor> rotors,
            final FileEnigmaReflector reflector,
            final List<FileEnigmaPlugboardConnection> plugboardConnections
    ) {
        this.rotors = rotors;
        this.reflector = reflector;
        this.plugboardConnections = plugboardConnections;
    }

    public List<FileEnigmaRotor> getRotors() {
        return rotors;
    }

    public FileEnigmaReflector getReflector() {
        return reflector;
    }

    public List<FileEnigmaPlugboardConnection> getPlugboardConnections() {
        return plugboardConnections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEnigmaConfiguration)) return false;
        FileEnigmaConfiguration that = (FileEnigmaConfiguration) o;
        return Objects.equals(rotors, that.rotors) &&
                Objects.equals(reflector, that.reflector) &&
                Objects.equals(plugboardConnections, that.plugboardConnections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rotors, reflector, plugboardConnections);
    }
}
