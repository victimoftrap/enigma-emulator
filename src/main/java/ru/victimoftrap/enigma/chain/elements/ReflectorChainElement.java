package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.reflectors.Reflector;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class ReflectorChainElement extends ChainElement {
    private Reflector reflector;

    public ReflectorChainElement(final Reflector reflector, final Rotor rotor) {
        super(rotor);
        this.reflector = reflector;
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        final AlphabeticSignal beforeReflector = afterAllRotorsChange(signal);
        final AlphabeticSignal reflectedSignal = reflector.reflectorExchange(beforeReflector);
        return passNext(reflectedSignal);
    }
}
