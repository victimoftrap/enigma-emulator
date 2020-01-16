package ru.victimoftrap.enigma.signal;

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
            resultChar = (char) ((charCode - MAX_SIGNAL) + MIN_SIGNAL);
        }
        return resultChar;
    }

    public AlphabeticSignal plus(char letter) {
        int resultCode = character + letter % MIN_SIGNAL;
        character = fitInAlphabetBorders(resultCode);
        return this;
    }

    public AlphabeticSignal minus(char letter) {
        int resultCode = character - letter;
        character = fitInAlphabetBorders(resultCode);
        return this;
    }
}
