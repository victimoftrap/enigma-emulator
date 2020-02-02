package ru.victimoftrap.enigma.rotors.factory;

public class NoSuchRotorTypeException extends Exception {
    public NoSuchRotorTypeException() {
        super("No such rotor type in Enigma");
    }

    public NoSuchRotorTypeException(final String message) {
        super(message);
    }

    public NoSuchRotorTypeException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
