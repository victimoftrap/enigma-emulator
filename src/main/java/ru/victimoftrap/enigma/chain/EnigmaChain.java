package ru.victimoftrap.enigma.chain;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public interface EnigmaChain {
    AlphabeticSignal passTrough(AlphabeticSignal signal);
}
