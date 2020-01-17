package ru.victimoftrap.enigma.rotors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public interface Rotor {
    AlphabeticSignal exchange(AlphabeticSignal signal);

    AlphabeticSignal backwardExchange(AlphabeticSignal signal);

    AlphabeticSignal getInitialPosition();

    char getTurnoverPosition();

    void rotate();
}
