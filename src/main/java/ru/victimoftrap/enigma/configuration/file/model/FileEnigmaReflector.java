package ru.victimoftrap.enigma.configuration.file.model;

import java.util.Objects;

public class FileEnigmaReflector {
    private String reflectorName;

    public FileEnigmaReflector() {
    }

    public FileEnigmaReflector(final String reflectorName) {
        this.reflectorName = reflectorName;
    }

    public String getReflectorName() {
        return reflectorName;
    }

    public void setReflectorName(final String reflectorName) {
        this.reflectorName = reflectorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEnigmaReflector)) return false;
        FileEnigmaReflector that = (FileEnigmaReflector) o;
        return Objects.equals(reflectorName, that.reflectorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reflectorName);
    }
}
