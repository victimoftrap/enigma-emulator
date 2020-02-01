package ru.victimoftrap.enigma.configuration.file.reader;

public class ConfigurationNotFoundException extends Exception {
    public ConfigurationNotFoundException() {
    }

    public ConfigurationNotFoundException(final String message) {
        super(message);
    }

    public ConfigurationNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
