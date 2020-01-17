package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class EndChainElement extends ChainElement {
    public EndChainElement(final Rotor rotor) {
        super(rotor);
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        final AlphabeticSignal betweenChange = backwardBetweenRotorsChange(signal);
        final AlphabeticSignal lastRotor = rotor.backwardExchange(betweenChange);
        final AlphabeticSignal finalSignal = afterAllRotorsChange(lastRotor);
        return passNext(finalSignal);
    }
}
