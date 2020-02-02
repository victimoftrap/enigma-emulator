package ru.victimoftrap.enigma;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;
import ru.victimoftrap.enigma.configuration.EnigmaConfiguration;
import ru.victimoftrap.enigma.chain.SignalTransformationEnigmaChain;
import ru.victimoftrap.enigma.chain.EnigmaChain;

import java.util.Objects;

public class Enigma {
    private EnigmaConfiguration configuration;
    private EnigmaChain enigmaChain;

    public Enigma(final EnigmaConfiguration configuration) {
        this.configuration = configuration;
        this.enigmaChain = new SignalTransformationEnigmaChain(
                configuration.getPlugboard(), configuration.getRotors(), configuration.getReflector()
        );
    }

    public String encode(final String source) {
        final var encodedResult = new StringBuilder();

        for (final var symbol : source.toCharArray()) {
            char encodedSymbol;

            if (Character.isAlphabetic(symbol)) {
                var signal = new AlphabeticSignal(Character.toUpperCase(symbol));
                signal = enigmaChain.passTrough(signal);
                encodedSymbol = signal.getCharacter();
            } else {
                encodedSymbol = symbol;
            }

            encodedResult.append(encodedSymbol);
        }
        return encodedResult.toString();
    }

    public EnigmaConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(final EnigmaConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enigma)) return false;
        Enigma enigma = (Enigma) o;
        return Objects.equals(configuration, enigma.configuration) &&
                Objects.equals(enigmaChain, enigma.enigmaChain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configuration, enigmaChain);
    }
}
