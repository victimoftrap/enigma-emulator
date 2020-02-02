package ru.victimoftrap.enigma.reflectors.factory;

public class NoSuchReflectorTypeException extends Exception {
    public NoSuchReflectorTypeException() {
        super("No such reflector type in Enigma");
    }

    public NoSuchReflectorTypeException(final String message) {
        super(message);
    }

    public NoSuchReflectorTypeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
