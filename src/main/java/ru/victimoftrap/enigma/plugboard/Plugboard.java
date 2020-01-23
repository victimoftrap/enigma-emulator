package ru.victimoftrap.enigma.plugboard;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public interface Plugboard {
    AlphabeticSignal exchange(AlphabeticSignal signal);

    AlphabeticSignal backwardExchange(AlphabeticSignal signal);

    void reconnect(char letter1, char letter2);
}
