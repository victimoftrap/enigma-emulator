package ru.victimoftrap.enigma.configuration.file.model;

import java.util.Objects;

public class FileEnigmaRotor {
    private String rotorName;
    private String initialPosition;

    public FileEnigmaRotor() {
    }

    public FileEnigmaRotor(final String rotorName, final String initialPosition) {
        this.rotorName = rotorName;
        this.initialPosition = initialPosition;
    }

    public String getRotorName() {
        return rotorName;
    }

    public void setRotorName(final String rotorName) {
        this.rotorName = rotorName;
    }

    public String getInitialPosition() {
        return initialPosition;
    }

    public void setInitialPosition(final String initialPosition) {
        this.initialPosition = initialPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEnigmaRotor)) return false;
        FileEnigmaRotor that = (FileEnigmaRotor) o;
        return Objects.equals(rotorName, that.rotorName) &&
                Objects.equals(initialPosition, that.initialPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rotorName, initialPosition);
    }
}
