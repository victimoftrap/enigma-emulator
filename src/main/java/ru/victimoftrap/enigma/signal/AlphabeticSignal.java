package ru.victimoftrap.enigma.signal;

import java.util.Objects;

/**
 * Class for alphabetic signal that used in rotors of Enigma.
 */
public class AlphabeticSignal {
    private char character;
    private char MIN_SIGNAL = 'A';
    private char MAX_SIGNAL = 'Z';

    public AlphabeticSignal(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    private char fitInAlphabetBorders(int charCode) {
        char resultChar = (char) charCode;
        if (charCode == 0) {
            return MIN_SIGNAL;
        } else if (charCode < 0) {
            resultChar = (char) (MAX_SIGNAL + charCode + 1);
        } else if (charCode < MIN_SIGNAL) {
            resultChar = (char) (MIN_SIGNAL + charCode);
        } else if (charCode > MAX_SIGNAL) {
            resultChar = (char) ((charCode - MAX_SIGNAL - 1) + MIN_SIGNAL);
        }
        return resultChar;
    }

    public AlphabeticSignal plus(char letter) {
        int resultCode = character + letter % MIN_SIGNAL;
        character = fitInAlphabetBorders(resultCode);
        return this;
    }

    public AlphabeticSignal plus(final AlphabeticSignal signal) {
        return plus(signal.getCharacter());
    }

    public AlphabeticSignal minus(char letter) {
        int resultCode = character - letter;
        character = fitInAlphabetBorders(resultCode);
        return this;
    }

    public AlphabeticSignal minus(final AlphabeticSignal signal) {
        return minus(signal.getCharacter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlphabeticSignal)) return false;
        AlphabeticSignal that = (AlphabeticSignal) o;
        return character == that.character &&
                MIN_SIGNAL == that.MIN_SIGNAL &&
                MAX_SIGNAL == that.MAX_SIGNAL;
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, MIN_SIGNAL, MAX_SIGNAL);
    }
}
