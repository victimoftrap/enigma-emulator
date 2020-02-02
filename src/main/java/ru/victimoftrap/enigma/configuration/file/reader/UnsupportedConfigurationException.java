package ru.victimoftrap.enigma.configuration.file.reader;

public class UnsupportedConfigurationException extends Exception {
    public UnsupportedConfigurationException() {
    }

    public UnsupportedConfigurationException(final String message) {
        super(message);
    }

    public UnsupportedConfigurationException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
