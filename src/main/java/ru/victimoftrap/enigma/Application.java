package ru.victimoftrap.enigma;

public class Application {
    public static void main(final String[] args) {
        final var commandLineEnigma = new CommandLineEnigmaStarter();
        commandLineEnigma.buildAndStart(args);
    }
}
