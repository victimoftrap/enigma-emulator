package ru.victimoftrap.enigma.reflectors;

import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public interface Reflector {
    AlphabeticSignal reflectorExchange(AlphabeticSignal signal);
}
