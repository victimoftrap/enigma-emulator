package ru.victimoftrap.enigma.configuration.file.model;

import java.util.Objects;

public class FileEnigmaPlugboardConnection {
    private String fromCharacter;
    private String toCharacter;

    public FileEnigmaPlugboardConnection(final String fromCharacter, final String toCharacter) {
        this.fromCharacter = fromCharacter;
        this.toCharacter = toCharacter;
    }

    public String getFromCharacter() {
        return fromCharacter;
    }

    public String getToCharacter() {
        return toCharacter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FileEnigmaPlugboardConnection)) return false;
        FileEnigmaPlugboardConnection that = (FileEnigmaPlugboardConnection) o;
        return Objects.equals(fromCharacter, that.fromCharacter) &&
                Objects.equals(toCharacter, that.toCharacter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromCharacter, toCharacter);
    }
}
