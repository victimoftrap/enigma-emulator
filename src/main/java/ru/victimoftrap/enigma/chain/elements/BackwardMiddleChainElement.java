package ru.victimoftrap.enigma.chain.elements;

import ru.victimoftrap.enigma.rotors.Rotor;
import ru.victimoftrap.enigma.signal.AlphabeticSignal;

public class BackwardMiddleChainElement extends ChainElement {
    public BackwardMiddleChainElement(final Rotor rotor) {
        super(rotor);
    }

    @Override
    public AlphabeticSignal pass(final AlphabeticSignal signal) {
        final AlphabeticSignal betweenChange = backwardBetweenRotorsChange(signal);
        final AlphabeticSignal afterRotor = rotor.backwardExchange(betweenChange);
        return passNext(afterRotor);
    }
}
